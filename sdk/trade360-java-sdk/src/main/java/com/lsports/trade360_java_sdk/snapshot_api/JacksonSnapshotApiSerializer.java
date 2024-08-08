package com.lsports.trade360_java_sdk.snapshot_api;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;

public class JacksonSnapshotApiSerializer implements JsonSnapshotApiSerializer {
    private final ObjectMapper jsonMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
        .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        .setSerializationInclusion(Include.NON_NULL);
    private final SnapshotApiSettings settings;

    public JacksonSnapshotApiSerializer(SnapshotApiSettings settings) {
        this.settings = settings;
    }

    @Override
    public <R> Object serialize(R request) {
        ObjectNode jsonObject = this.jsonMapper.valueToTree(request);
        jsonObject.put("PackageId", this.settings.packageId());
        jsonObject.put("UserName", this.settings.userName());
        jsonObject.put("Password", this.settings.password());

        return jsonObject;
    }

    @Override
    public ObjectMapper getJsonMapper() {
        return this.jsonMapper;
    }
}
