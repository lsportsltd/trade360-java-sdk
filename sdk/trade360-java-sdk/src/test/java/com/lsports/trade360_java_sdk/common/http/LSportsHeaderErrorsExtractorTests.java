package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LSportsHeaderErrorsExtractorTests {

    @Test
    public void extractErrors_withValidHeaderErrors_returnsErrorMessages() throws Exception {
        // Arrange
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"Header\":{\"Errors\":[{\"message\":\"Error 1\"},{\"message\":\"Error 2\"}]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        when(serializer.deserializeToValue(any(), any())).thenAnswer(invocation -> {
            return java.util.List.of(
                createError("Error 1"),
                createError("Error 2")
            );
        });

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        assertEquals(java.util.List.of("Error 1", "Error 2"), result);
    }

    @Test
    public void extractErrors_withoutHeaderSection_returnsNull() throws Exception {
        // Arrange
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"SomeOtherField\":\"value\"}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNull(result);
    }

    @Test
    public void extractErrors_withHeaderButNoErrors_returnsNull() throws Exception {
        // Arrange
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"Header\":{\"Status\":\"OK\"}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNull(result);
    }

    @Test
    public void extractErrors_withEmptyErrorsArray_returnsEmptyList() throws Exception {
        // Arrange
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"Header\":{\"Errors\":[]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        when(serializer.deserializeToValue(any(), any())).thenReturn(java.util.List.of());

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        assertFalse(result.iterator().hasNext());
    }

    @Test
    public void extractErrors_withSerializationException_returnsNull() throws Exception {
        // Arrange
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"Header\":{\"Errors\":[{\"message\":\"Error 1\"}]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        when(serializer.deserializeToValue(any(), any())).thenThrow(new RuntimeException("Serialization error"));

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNull(result);
    }

    private com.lsports.trade360_java_sdk.common.entities.base.Error createError(String message) {
        var error = new com.lsports.trade360_java_sdk.common.entities.base.Error();
        error.message = message;
        return error;
    }
}

