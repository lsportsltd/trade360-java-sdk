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
        
        Error error1 = new Error();
        error1.message = "Error 1";
        Error error2 = new Error();
        error2.message = "Error 2";
        List<Error> errors = List.of(error1, error2);
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
        
        Error error = new Error();
        error.message = "Single error";
        List<Error> errors = List.of(error);
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
        
        Error error = new Error();
        error.message = null;
        List<Error> errors = List.of(error);
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
        
        Error error1 = new Error();
        error1.message = "Valid error";
        Error error2 = new Error();
        error2.message = null;
        Error error3 = new Error();
        error3.message = "Another valid error";
        List<Error> errors = List.of(error1, error2, error3);
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
        
        Error error1 = new Error();
        error1.message = "Error 1";
        Error error2 = new Error();
        error2.message = "Error 2";
        Error error3 = new Error();
        error3.message = "Error 3";
        Error error4 = new Error();
        error4.message = "Error 4";
        Error error5 = new Error();
        error5.message = "Error 5";
        List<Error> errors = List.of(error1, error2, error3, error4, error5);
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
