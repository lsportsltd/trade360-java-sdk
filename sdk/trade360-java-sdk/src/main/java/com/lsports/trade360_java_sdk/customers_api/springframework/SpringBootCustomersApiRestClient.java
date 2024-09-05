package com.lsports.trade360_java_sdk.customers_api.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.customers_api.http.ApiRestClient;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.io.IOException;
import java.util.List;

class SpringBootCustomersApiRestClient implements ApiRestClient {
    private final WebClient client;
    private final JacksonApiSerializer serializer;
    private final ObjectMapper mapper;

    public SpringBootCustomersApiRestClient(WebClient.Builder builder, JacksonApiSerializer serializer, String baseUrl) {
        this.serializer = serializer;
        mapper = serializer.getJsonMapper();
        this.client = builder
            .baseUrl(baseUrl)
            .codecs(config -> {
                config.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(mapper));
                config.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(mapper, new MediaType[] {MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM}));
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
            .onStatus(HttpStatusCode::isError, res -> {
                throw new Trade360Exception("Request failed because of " + res.statusCode());
            })
            .bodyToMono(String.class)
            .handle((responseJson, sink) -> {
                try {
                    if (responseJson == null) {
                        throw new Trade360Exception("No correct response received. Ensure that correct Trade360 URL is configured.");
                    }

                    var parsedResponse = this.mapper.readTree(responseJson);

                    if (!parsedResponse.has("Header")) {
                        throw new Trade360Exception("'Header' property is missing. Please, ensure that you use the correct URL.");
                    }
                    
                    var body = parsedResponse.get("Body");
                    if (body == null) {
                        throw new Trade360Exception("'Body' property is missing. Please, ensure that you use the correct URL.");
                    }

                    var parsedBody = this.mapper.readValue(body.traverse(), responseTypeReference);

                    sink.next(parsedBody);
                }
                catch(IOException ex) {
                    sink.error(ex);
                }
            });
    }

    @Override
    public <Res> Mono<Res> postRequest(TypeReference<Res> responseTypeReference, String url) throws Trade360Exception {
        return this.client
                .post()
                .uri(url)
                .retrieve()
                .onStatus(HttpStatusCode::isError, res -> {
                    throw new Trade360Exception("Request failed because of " + res.statusCode());
                })
                .bodyToMono(String.class)
                .handle((responseJson, sink) -> {
                    try {
                        if (responseJson == null) {
                            throw new Trade360Exception("No correct response received. Ensure that correct Trade360 URL is configured.");
                        }

                        var parsedResponse = this.mapper.readTree(responseJson);

                        if (!parsedResponse.has("Header")) {
                            throw new Trade360Exception("'Header' property is missing. Please, ensure that you use the correct URL.");
                        }

                        var body = parsedResponse.get("Body");
                        if (body == null) {
                            throw new Trade360Exception("'Body' property is missing. Please, ensure that you use the correct URL.");
                        }

                        var parsedBody = this.mapper.readValue(body.traverse(), responseTypeReference);

                        sink.next(parsedBody);
                    }
                    catch(IOException ex) {
                        sink.error(ex);
                    }
                });
    }
}