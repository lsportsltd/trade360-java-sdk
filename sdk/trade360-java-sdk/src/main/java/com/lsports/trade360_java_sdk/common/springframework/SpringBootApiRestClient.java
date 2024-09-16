package com.lsports.trade360_java_sdk.common.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.lsports.trade360_java_sdk.common.entities.base.Error;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class SpringBootApiRestClient implements ApiRestClient {
    private final WebClient client;
    private final JsonApiSerializer serializer;

    public SpringBootApiRestClient(WebClient.Builder builder, JsonApiSerializer serializer, URI baseUrl) {
        this.serializer = serializer;
        this.client = builder
            .baseUrl(baseUrl.toString())
            .codecs(config -> {
                this.serializer.configureWebClientCodecs(config);
            })
            .defaultHeaders(t -> {
                t.setContentType(MediaType.APPLICATION_JSON);
                t.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .build();
    }

    @Override
    public <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseTypeReference, String url) {
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serializeRequest(requestBody)))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    @Override
    public <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url) {
        return this.client
            .post()
            .uri(url)
            .body(BodyInserters.fromValue(this.serializer.serializeRequest(new Object())))
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    @Override
    public <Req, Res> Mono<Res> getRequest(Req requestQueryStringObject, TypeReference<Res> responseTypeReference, String url) {
        MultiValueMap<String, String> queryParams;
        try {
            queryParams = this.convertToQueryParams(requestQueryStringObject);
        } catch (IOException e) {
            return Mono.error(e);
        }

        return this.client
            .get()
            .uri(urlBuilder -> urlBuilder
                .path(url)
                .queryParams(queryParams)
                .build())
            .retrieve()
            .onStatus(HttpStatusCode::isError, res -> this.createErrorMono(res))
            .bodyToMono(JsonNode.class)
            .handle((responseJson, sink) -> this.handleResponse(responseTypeReference, responseJson, sink));
    }

    private <Req> MultiValueMap<String, String> convertToQueryParams(Req requestParams) throws IOException {
        var serialized = this.serializer.serializeRequest(requestParams);
        Map<String, String> map = this.serializer.deserializeToValue(serialized.traverse(), new TypeReference<Map<String, String>>() {});
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        map.forEach(params::add);
        return params;
    }

    private <Res> void handleResponse(TypeReference<Res> responseTypeReference, JsonNode parsedResponse, SynchronousSink<Res> sink) {
        try {
            if (parsedResponse == null) {
                throw new Trade360Exception("No correct response received. Ensure that correct Trade360 URL is configured.");
            }

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
        return extractErrorMessage(response).flatMap(errorMessages ->
            Mono.error(new Trade360Exception("Request failed because of " + response.statusCode(), errorMessages))
        );
    }

    private Mono<Iterable<String>> extractErrorMessage(ClientResponse response) {
        if(response.headers().contentLength().orElse(0L) == 0) {
            return Mono.just(List.of("Unknown error occured."));
        }

        return response.bodyToMono(JsonNode.class).map(body -> {
            try {
                var jsonNode = body;
                if (jsonNode.has("Header") && jsonNode.get("Header").has("Errors")) {
                    var errors = jsonNode.get("Header").get("Errors");
                    var parsedErrors = this.serializer.deserializeToValue(errors.traverse(), new TypeReference<Iterable<Error>>() {});
                    return StreamSupport.stream(parsedErrors.spliterator(), false)
                        .map(e -> e.message)
                        .toList();
                } else {
                    return List.of(body.toString());
                }
            } catch (Throwable e) {
                return List.of("Failed to parse errors from response body.");
            }
        });
    }
}