package com.lsports.trade360_java_sdk.common.http;

import java.util.stream.StreamSupport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.lsports.trade360_java_sdk.common.entities.base.Error;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

public class LSportsHeaderErrorsExtractor implements ErrorsExtractor {
    @Override
    public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
        try {
            if (bodyJsonNode.has("Header") && bodyJsonNode.get("Header").has("Errors")) {
                var errors = bodyJsonNode.get("Header").get("Errors");
                var parsedErrors = serializer.deserializeToValue(errors.traverse(), new TypeReference<Iterable<Error>>() {});
                return StreamSupport.stream(parsedErrors.spliterator(), false)
                    .map(e -> e.message)
                    .toList();
            } else {
                return null;
            }
        } catch (Throwable e) {
            return null;
        }
    }
}