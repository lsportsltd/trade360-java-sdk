package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

import com.lsports.trade360_java_sdk.snapshot_api.JsonSnapshotApiSerializer;
import com.lsports.trade360_java_sdk.snapshot_api.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.http.ApiResponse;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

class SpringBootSnapshotApiRestClient implements SnapshotApiRestClient {
    private final RestClient client;
    private final JsonSnapshotApiSerializer serializer;

    public SpringBootSnapshotApiRestClient(RestClient.Builder builder, JsonSnapshotApiSerializer serializer, SnapshotApiSettings settings) {
        this.serializer = serializer;
        this.client = builder
            .baseUrl(settings.baseUrl().toString())
            .messageConverters(converters -> {
                converters.clear();
                converters.add(new AbstractJackson2HttpMessageConverter(serializer.getJsonMapper(), new MediaType[] {MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM}){});
            })
            .defaultHeaders(t -> {
                t.setContentType(MediaType.APPLICATION_JSON);
                t.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .build();
    }

    @Override
    public <Req, Res> Res postRequest(Req requestBody, String url) throws Trade360Exception {
        var response = this.client
            .post()
            .uri(url)
            .body(this.serializer.serialize(requestBody))
            .retrieve()
            .onStatus(HttpStatusCode::isError, (req, res) -> {
                throw new Trade360Exception("Request failed because of " + res.getStatusCode());
            })
            .body(new ParameterizedTypeReference<ApiResponse<Res>>() {});

        if (response == null || response.header() == null) {
            throw new Trade360Exception("'Header' property is missed. Ensure that correct Trade360 URL is configured.");
        }

        if (response.body() == null) {
            throw new Trade360Exception("'Body' property is missed. Ensure that correct Trade360 URL is configured.");
        }

        return response.body();
    }
}