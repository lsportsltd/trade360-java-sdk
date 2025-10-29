package com.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProblemJsonErrorsExtractorTests {

    @Test
    public void extractErrors_withValidErrorsSection_returnsFormattedErrors() throws Exception {
        // Arrange
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"errors\":{\"field1\":[\"error1\",\"error2\"],\"field2\":[\"error3\"]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        List<String> errors = (List<String>) result;
        assertEquals(3, errors.size());
        assertTrue(errors.contains("field1: error1"));
        assertTrue(errors.contains("field1: error2"));
        assertTrue(errors.contains("field2: error3"));
    }

    @Test
    public void extractErrors_withoutErrorsSection_returnsNull() throws Exception {
        // Arrange
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"status\":\"error\",\"message\":\"Something went wrong\"}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNull(result);
    }

    @Test
    public void extractErrors_withEmptyErrorsSection_returnsEmptyList() throws Exception {
        // Arrange
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"errors\":{}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        assertFalse(result.iterator().hasNext());
    }

    @Test
    public void extractErrors_withSingleFieldMultipleErrors_returnsAllErrorsForField() throws Exception {
        // Arrange
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"errors\":{\"username\":[\"is required\",\"must be at least 3 characters\",\"must be unique\"]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        List<String> errors = (List<String>) result;
        assertEquals(3, errors.size());
        assertTrue(errors.contains("username: is required"));
        assertTrue(errors.contains("username: must be at least 3 characters"));
        assertTrue(errors.contains("username: must be unique"));
    }

    @Test
    public void extractErrors_withMultipleFields_returnsAllErrors() throws Exception {
        // Arrange
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"errors\":{\"email\":[\"is invalid\"],\"password\":[\"is too short\"],\"age\":[\"must be positive\"]}}";
        JsonNode node = mapper.readTree(json);
        
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);

        // Act
        Iterable<String> result = extractor.extractErrors(node, serializer);

        // Assert
        assertNotNull(result);
        List<String> errors = (List<String>) result;
        assertEquals(3, errors.size());
        assertTrue(errors.contains("email: is invalid"));
        assertTrue(errors.contains("password: is too short"));
        assertTrue(errors.contains("age: must be positive"));
    }
}

