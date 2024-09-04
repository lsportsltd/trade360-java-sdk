package com.lsports.trade360_java_sdk.common.configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
    public ObjectMapper getJsonMapper() {
        return this.jsonMapper;
    }
}
