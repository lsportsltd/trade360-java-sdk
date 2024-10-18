package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;

/**
 * The {@code ErrorsExtractor} interface defines a method for extracting errors from a JSON response.
 */
public interface ErrorsExtractor {

    /**
     * Extracts errors from the given JSON response body using the specified serializer.
     *
     * @param bodyJsonNode the JSON response body
     * @param serializer the serializer to use for extracting errors
     * @return an iterable of error messages
     */
    Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer);
}