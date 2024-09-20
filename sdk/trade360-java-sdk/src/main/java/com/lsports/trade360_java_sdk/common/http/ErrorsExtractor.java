package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

public interface ErrorsExtractor {
    Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer);
}
