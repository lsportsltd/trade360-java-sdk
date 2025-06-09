package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LSportsHeaderErrorsExtractorExpandedTest {

    @Test
    void testExtractErrorsWithValidHeader() throws Exception {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"Header\":{\"Errors\":[{\"message\":\"Error 1\"},{\"message\":\"Error 2\"}]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        when(mockSerializer.deserializeToValue(any(), any())).thenReturn(
            List.of(
                new eu.lsports.trade360_java_sdk.common.entities.base.Error() {{ message = "Error 1"; }},
                new eu.lsports.trade360_java_sdk.common.entities.base.Error() {{ message = "Error 2"; }}
            )
        );
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(2, errorList.size());
        assertTrue(errorList.contains("Error 1"));
        assertTrue(errorList.contains("Error 2"));
    }

    @Test
    void testExtractErrorsWithoutHeader() throws Exception {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"data\":\"some data\"}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNull(errors);
    }

    @Test
    void testExtractErrorsWithHeaderButNoErrors() throws Exception {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"Header\":{\"status\":\"success\"}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNull(errors);
    }

    @Test
    void testExtractErrorsWithException() throws Exception {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"Header\":{\"Errors\":[{\"message\":\"Error 1\"}]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        when(mockSerializer.deserializeToValue(any(), any())).thenThrow(new RuntimeException("Serialization error"));
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNull(errors);
    }

    @Test
    void testExtractErrorsWithEmptyErrorsList() throws Exception {
        LSportsHeaderErrorsExtractor extractor = new LSportsHeaderErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"Header\":{\"Errors\":[]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        when(mockSerializer.deserializeToValue(any(), any())).thenReturn(List.of());
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(0, errorList.size());
    }
}
