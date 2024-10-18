package com.lsports.trade360_java_sdk.common.interfaces;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The {@code JsonApiSerializer} interface defines methods for serializing and deserializing JSON data.
 */
public interface JsonApiSerializer {

    /**
     * Serializes the given request object to an {@code ObjectNode}.
     *
     * @param <R> the type of the request object
     * @param request the request object to serialize
     * @return the serialized {@code ObjectNode}
     */
    <R> ObjectNode serializeRequest(R request);

    /**
     * Serializes the given request object to a JSON string.
     *
     * @param <R> the type of the request object
     * @param request the request object to serialize
     * @return the serialized JSON string
     * @throws JsonProcessingException if an error occurs during serialization
     */
    <R> String serializeToString(R request) throws JsonProcessingException;

    /**
     * Deserializes the given JSON string to a {@code JsonNode}.
     *
     * @param json the JSON string to deserialize
     * @return the deserialized {@code JsonNode}
     * @throws JsonProcessingException if an error occurs during deserialization
     */
    JsonNode deserializeToTree(String json) throws JsonProcessingException;

    /**
     * Deserializes the given JSON parser to a value of the specified type.
     *
     * @param <T> the type of the value to deserialize
     * @param jsonParser the JSON parser to deserialize
     * @param valueTypeRef the type reference of the value
     * @return the deserialized value
     * @throws IOException if an error occurs during deserialization
     */
    <T> T deserializeToValue(JsonParser jsonParser, TypeReference<T> valueTypeRef) throws IOException;

    /**
     * Converts the given value to another value of the specified type.
     *
     * @param <T> the type of the original value
     * @param <R> the type of the converted value
     * @param fromValue the original value to convert
     * @param valueTypeRef the type reference of the converted value
     * @return the converted value
     */
    <T, R> R convertValue(T fromValue, TypeReference<R> valueTypeRef);

    /**
     * Returns the {@code ObjectMapper} used for JSON serialization and deserialization.
     *
     * @return the {@code ObjectMapper}
     */
    ObjectMapper getObjectMapper();
}