package com.lsports.trade360_java_sdk.snapshot_api;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.http.ApiResponse;

class SnapshotApiRestClient {
    private final Builder builder;
    private RestClient client;
    private SnapshotApiSettings settings;
    private final ObjectMapper jsonMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
        .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        .setSerializationInclusion(Include.NON_NULL);

    public SnapshotApiRestClient(RestClient.Builder builder) {
        this.builder = builder;
    }

    public void configure(SnapshotApiSettings settings) {
        this.settings = settings;
        this.client = builder
            .baseUrl(settings.baseUrl().toString())
            .messageConverters(converters -> {
                converters.clear();
                converters.add(new AbstractJackson2HttpMessageConverter(this.jsonMapper, new MediaType[] {MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM}){});
            })
            .defaultHeaders(t -> {
                t.setContentType(MediaType.APPLICATION_JSON);
                t.setAccept(List.of(MediaType.APPLICATION_JSON));
            })
            .build();
    }

    public <Req, Res> Res postRequest(Req requestBody, String url) throws Trade360Exception {
        ObjectNode jsonObject = this.jsonMapper.valueToTree(requestBody);
        jsonObject.put("PackageId", this.settings.packageId());
        jsonObject.put("UserName", this.settings.userName());
        jsonObject.put("Password", this.settings.password());

        var response = this.client
            .post()
            .uri(url)
            .body(jsonObject)
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