package com.lsports.trade360_java_sdk.common.interfaces;

import java.io.IOException;

import org.springframework.http.codec.ClientCodecConfigurer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

public interface JsonApiSerializer {
    <R> Object serialize(R request);

    JsonNode deserializeToTree(String json) throws JsonProcessingException;

    <T> T deserializeToValue(JsonParser jsonParser, TypeReference<T> valueTypeRef) throws IOException;

    void configureWebClientCodecs(ClientCodecConfigurer config);
}
