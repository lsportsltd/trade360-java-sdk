package com.lsports.trade360_java_sdk.common.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class SpringBootApiRestClient implements ApiRestClient {
    private final WebClient client;
    private final JacksonApiSerializer serializer;

    public SpringBootApiRestClient(WebClient.Builder builder, JacksonApiSerializer serializer, URI baseUrl) {
        this.serializer = serializer;
        this.client = builder
            .baseUrl(baseUrl.toString())
            .codecs(config -> {
                this.serializer.configureWebClientCodecs(config);
                config.defaultCodecs().maxInMemorySize(1024 * 1024 * 16);
            })
            .defaultHeaders(t -> {
                t.setContentType(MediaType.APPLICATION_JSON);
                t.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .build();
    }

    @Override
    public <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url) throws Trade360Exception {
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serialize(requestBody)))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(String.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    @Override
    public <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url) throws Trade360Exception {
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serialize(new Object())))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(String.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    private <Res> void handleResponse(TypeReference<Res> responseTypeReference, String responseJson, SynchronousSink<Res> sink) {
        try {
            if (responseJson == null) {
                throw new Trade360Exception("No correct response received. Ensure that correct Trade360 URL is configured.");
            }

            var parsedResponse = this.serializer.deserializeToTree(responseJson);

            if (!parsedResponse.has("Header")) {
                throw new Trade360Exception("'Header' property is missing. Please, ensure that you use the correct URL.");
            }

            var body = parsedResponse.get("Body");
            if (body == null) {
                throw new Trade360Exception("'Body' property is missing. Please, ensure that you use the correct URL.");
            }

            var parsedBody = this.serializer.deserializeToValue(body.traverse(), responseTypeReference);

            sink.next(parsedBody);
        }
        catch(IOException ex) {
            sink.error(ex);
        }
    }

    private Mono<Throwable> createErrorMono(ClientResponse response) {
        return extractErrorMessage(response).flatMap(errorMessage ->
                Mono.error(new Trade360Exception("Request failed because of " + response.statusCode() + errorMessage))
        );
    }

    private Mono<String> extractErrorMessage(ClientResponse response) {
        return response.bodyToMono(String.class).map(body -> {
            StringBuilder errorMessage = new StringBuilder(" Errors: ");
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(body);
                if (jsonNode.has("Header") && jsonNode.get("Header").has("Errors")) {
                    JsonNode errors = jsonNode.get("Header").get("Errors");
                    errorMessage.append(errors.toString());
                } else {
                    errorMessage.append(body);
                }
            } catch (Exception e) {
                errorMessage.append(" Failed to parse errors from response body.");
            }
            return errorMessage.toString();
        });
    }
}