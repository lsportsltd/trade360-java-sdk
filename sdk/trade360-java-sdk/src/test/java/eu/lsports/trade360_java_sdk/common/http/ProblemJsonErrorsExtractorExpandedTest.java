package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProblemJsonErrorsExtractorExpandedTest {

    @Test
    void testExtractErrorsWithValidProblemJson() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"errors\":{\"field1\":[\"Error message 1\",\"Error message 2\"],\"field2\":[\"Error message 3\"]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(3, errorList.size());
        assertTrue(errorList.contains("field1: Error message 1"));
        assertTrue(errorList.contains("field1: Error message 2"));
        assertTrue(errorList.contains("field2: Error message 3"));
    }

    @Test
    void testExtractErrorsWithoutErrorsField() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"data\":\"some data\"}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNull(errors);
    }

    @Test
    void testExtractErrorsWithEmptyErrors() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"errors\":{}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(0, errorList.size());
    }

    @Test
    void testExtractErrorsWithSingleFieldError() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"errors\":{\"username\":[\"Username is required\"]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(1, errorList.size());
        assertTrue(errorList.contains("username: Username is required"));
    }

    @Test
    void testExtractErrorsWithMultipleFieldsAndMessages() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"errors\":{\"email\":[\"Email is invalid\",\"Email already exists\"],\"password\":[\"Password too short\"],\"age\":[\"Age must be positive\"]}}";
        JsonNode bodyNode = mapper.readTree(jsonString);
        
        Iterable<String> errors = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(errors);
        List<String> errorList = (List<String>) errors;
        assertEquals(4, errorList.size());
        assertTrue(errorList.contains("email: Email is invalid"));
        assertTrue(errorList.contains("email: Email already exists"));
        assertTrue(errorList.contains("password: Password too short"));
        assertTrue(errorList.contains("age: Age must be positive"));
    }
}
