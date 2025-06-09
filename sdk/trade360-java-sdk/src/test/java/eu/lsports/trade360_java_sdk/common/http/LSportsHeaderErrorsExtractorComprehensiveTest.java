package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.entities.base.Error;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class LSportsHeaderErrorsExtractorComprehensiveTest {

    @Test
    void testExtractErrorsWithValidHeaderAndErrors() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        
        List<Error> errors = List.of(
            new Error("Error 1"),
            new Error("Error 2")
        );
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(errors);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(2, errorMessages.size());
        assertEquals("Error 1", errorMessages.get(0));
        assertEquals("Error 2", errorMessages.get(1));
    }

    @Test
    void testExtractErrorsWithNoHeader() {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(false);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithHeaderButNoErrors() {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(false);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithEmptyErrorsList() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(List.of());
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    void testExtractErrorsWithSingleError() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        
        List<Error> errors = List.of(new Error("Single error"));
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(errors);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(1, errorMessages.size());
        assertEquals("Single error", errorMessages.get(0));
    }

    @Test
    void testExtractErrorsWithNullErrorMessage() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        
        List<Error> errors = List.of(new Error(null));
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(errors);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(1, errorMessages.size());
        assertNull(errorMessages.get(0));
    }

    @Test
    void testExtractErrorsWithDeserializationException() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenThrow(new IOException("Deserialization failed"));
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithRuntimeException() {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenThrow(new RuntimeException("Unexpected error"));
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithNullBodyNode() {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        Iterable<String> result = extractor.extractErrors(null, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithNullSerializer() {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, null);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithMultipleErrorsAndNullMessages() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        
        List<Error> errors = List.of(
            new Error("Valid error"),
            new Error(null),
            new Error("Another valid error")
        );
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(errors);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(3, errorMessages.size());
        assertEquals("Valid error", errorMessages.get(0));
        assertNull(errorMessages.get(1));
        assertEquals("Another valid error", errorMessages.get(2));
    }

    @Test
    void testExtractErrorsWithLargeErrorsList() throws IOException {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonNode mockBodyNode = mock(JsonNode.class);
        JsonNode mockHeaderNode = mock(JsonNode.class);
        JsonNode mockErrorsNode = mock(JsonNode.class);
        JsonParser mockParser = mock(JsonParser.class);
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        when(mockBodyNode.has("Header")).thenReturn(true);
        when(mockBodyNode.get("Header")).thenReturn(mockHeaderNode);
        when(mockHeaderNode.has("Errors")).thenReturn(true);
        when(mockHeaderNode.get("Errors")).thenReturn(mockErrorsNode);
        when(mockErrorsNode.traverse()).thenReturn(mockParser);
        
        List<Error> errors = List.of(
            new Error("Error 1"),
            new Error("Error 2"),
            new Error("Error 3"),
            new Error("Error 4"),
            new Error("Error 5")
        );
        when(mockSerializer.deserializeToValue(eq(mockParser), any(TypeReference.class))).thenReturn(errors);
        
        Iterable<String> result = extractor.extractErrors(mockBodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(5, errorMessages.size());
        for (int i = 0; i < 5; i++) {
            assertEquals("Error " + (i + 1), errorMessages.get(i));
        }
    }
}
