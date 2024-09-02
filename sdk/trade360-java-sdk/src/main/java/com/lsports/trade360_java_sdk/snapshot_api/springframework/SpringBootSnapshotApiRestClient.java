package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.snapshot_api.JsonSnapshotApiSerializer;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

import reactor.core.publisher.Mono;

class SpringBootSnapshotApiRestClient implements SnapshotApiRestClient {
    private final WebClient client;
    private final JsonSnapshotApiSerializer serializer;
    private final ObjectMapper mapper;

    public SpringBootSnapshotApiRestClient(WebClient.Builder builder, JsonSnapshotApiSerializer serializer, SnapshotApiSettings settings) {
        this.serializer = serializer;
        mapper = serializer.getJsonMapper();
        this.client = builder
            .baseUrl(settings.baseUrl().toString())
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
    public <Req, Res> Mono<Res> postRequest(Req requestBody, TypeReference<Res> responseType, String url) throws Trade360Exception {
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
                        throw new Trade360Exception("'Header' property is missed. Ensure that correct Trade360 URL is configured.");
                    }
                    
                    var body = parsedResponse.get("Body");
                    if (body == null) {
                        throw new Trade360Exception("'Body' property is missed. Ensure that correct Trade360 URL is configured.");
                    }

                    var parsedBody = this.mapper.readValue(body.traverse(), responseType);

                    sink.next(parsedBody);
                }
                catch(IOException ex) {
                    sink.error(ex);
                }
            });
    }
}