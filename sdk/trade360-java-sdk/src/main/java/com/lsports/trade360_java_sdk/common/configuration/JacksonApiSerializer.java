package com.lsports.trade360_java_sdk.common.configuration;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

public class JacksonApiSerializer implements JsonApiSerializer {
    private final ObjectMapper jsonMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
        .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setSerializationInclusion(Include.NON_NULL);

    private final PackageCredentials packageCredentials;

    public JacksonApiSerializer(PackageCredentials packageCredentials) {
        this.packageCredentials = packageCredentials;
    }

    @Override
    public <R> Object serialize(R request) {
        ObjectNode jsonObject = this.jsonMapper.valueToTree(request);
        jsonObject.put("PackageId", this.packageCredentials.packageId());
        jsonObject.put("UserName", this.packageCredentials.userName());
        jsonObject.put("Password", this.packageCredentials.password());
        jsonObject.put("MessageFormat", this.packageCredentials.messageFormat());

        return jsonObject;
    }

    @Override
    public JsonNode deserializeToTree(String json) throws JsonProcessingException {
        return this.jsonMapper.readTree(json);
    }

    @Override
    public <T> T deserializeToValue(JsonParser jsonParser, TypeReference<T> valueTypeRef) throws IOException {
        return this.jsonMapper.readValue(jsonParser, valueTypeRef);
    }

    @Override
    public void configureWebClientCodecs(ClientCodecConfigurer config) {
        config.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(this.jsonMapper));
        config.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(this.jsonMapper, new MediaType[] {MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM}));
    }
}
