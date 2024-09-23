package com.lsports.trade360_java_sdk.common.http;

import java.util.stream.StreamSupport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

public class ProblemJsonErrorsExtractor implements ErrorsExtractor {
    @Override
    public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
        if(bodyJsonNode.has("errors")) {
            return StreamSupport.stream(bodyJsonNode.get("errors").properties().spliterator(), false)
                .flatMap(p -> StreamSupport.stream(((ArrayNode) p.getValue()).spliterator(), false)
                    .map(e -> p.getKey() + ": " + e.asText()))
                .toList();
        } else {
            return null;
        }
    }
}