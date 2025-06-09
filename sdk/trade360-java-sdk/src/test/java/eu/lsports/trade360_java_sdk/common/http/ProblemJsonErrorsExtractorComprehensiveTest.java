package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProblemJsonErrorsExtractorComprehensiveTest {

    @Test
    void testExtractErrorsWithValidErrorsProperty() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode fieldErrors = JsonNodeFactory.instance.arrayNode();
        fieldErrors.add("Field is required");
        fieldErrors.add("Field must be valid");
        errorsNode.set("fieldName", fieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(2, errorMessages.size());
        assertEquals("fieldName: Field is required", errorMessages.get(0));
        assertEquals("fieldName: Field must be valid", errorMessages.get(1));
    }

    @Test
    void testExtractErrorsWithNoErrorsProperty() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        bodyNode.put("message", "Some other property");
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithEmptyErrorsProperty() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    void testExtractErrorsWithMultipleFields() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        
        ArrayNode field1Errors = JsonNodeFactory.instance.arrayNode();
        field1Errors.add("Field1 error 1");
        field1Errors.add("Field1 error 2");
        errorsNode.set("field1", field1Errors);
        
        ArrayNode field2Errors = JsonNodeFactory.instance.arrayNode();
        field2Errors.add("Field2 error 1");
        errorsNode.set("field2", field2Errors);
        
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(3, errorMessages.size());
        assertTrue(errorMessages.contains("field1: Field1 error 1"));
        assertTrue(errorMessages.contains("field1: Field1 error 2"));
        assertTrue(errorMessages.contains("field2: Field2 error 1"));
    }

    @Test
    void testExtractErrorsWithSingleFieldSingleError() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode fieldErrors = JsonNodeFactory.instance.arrayNode();
        fieldErrors.add("Single error message");
        errorsNode.set("singleField", fieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(1, errorMessages.size());
        assertEquals("singleField: Single error message", errorMessages.get(0));
    }

    @Test
    void testExtractErrorsWithNullBodyNode() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        assertThrows(NullPointerException.class, () -> {
            extractor.extractErrors(null, mockSerializer);
        });
    }

    @Test
    void testExtractErrorsWithNullSerializer() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, null);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    void testExtractErrorsWithEmptyArrayErrors() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode emptyFieldErrors = JsonNodeFactory.instance.arrayNode();
        errorsNode.set("emptyField", emptyFieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertTrue(errorMessages.isEmpty());
    }

    @Test
    void testExtractErrorsWithSpecialCharacters() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode fieldErrors = JsonNodeFactory.instance.arrayNode();
        fieldErrors.add("Error with special chars: @#$%^&*()");
        fieldErrors.add("Unicode error: ñáéíóú");
        errorsNode.set("specialField", fieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(2, errorMessages.size());
        assertEquals("specialField: Error with special chars: @#$%^&*()", errorMessages.get(0));
        assertEquals("specialField: Unicode error: ñáéíóú", errorMessages.get(1));
    }

    @Test
    void testExtractErrorsWithNumericFieldNames() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode fieldErrors = JsonNodeFactory.instance.arrayNode();
        fieldErrors.add("Numeric field error");
        errorsNode.set("123", fieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(1, errorMessages.size());
        assertEquals("123: Numeric field error", errorMessages.get(0));
    }

    @Test
    void testExtractErrorsWithLongErrorMessages() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        ArrayNode fieldErrors = JsonNodeFactory.instance.arrayNode();
        String longError = "This is a very long error message that contains a lot of text to test how the extractor handles lengthy error descriptions that might be returned from validation processes";
        fieldErrors.add(longError);
        errorsNode.set("longField", fieldErrors);
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(1, errorMessages.size());
        assertEquals("longField: " + longError, errorMessages.get(0));
    }

    @Test
    void testExtractErrorsWithMixedFieldTypes() {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        ObjectNode bodyNode = JsonNodeFactory.instance.objectNode();
        ObjectNode errorsNode = JsonNodeFactory.instance.objectNode();
        
        ArrayNode stringFieldErrors = JsonNodeFactory.instance.arrayNode();
        stringFieldErrors.add("String field error");
        errorsNode.set("stringField", stringFieldErrors);
        
        ArrayNode numberFieldErrors = JsonNodeFactory.instance.arrayNode();
        numberFieldErrors.add("Number field error");
        errorsNode.set("numberField", numberFieldErrors);
        
        ArrayNode booleanFieldErrors = JsonNodeFactory.instance.arrayNode();
        booleanFieldErrors.add("Boolean field error");
        errorsNode.set("booleanField", booleanFieldErrors);
        
        bodyNode.set("errors", errorsNode);
        
        Iterable<String> result = extractor.extractErrors(bodyNode, mockSerializer);
        
        assertNotNull(result);
        List<String> errorMessages = (List<String>) result;
        assertEquals(3, errorMessages.size());
        assertTrue(errorMessages.contains("stringField: String field error"));
        assertTrue(errorMessages.contains("numberField: Number field error"));
        assertTrue(errorMessages.contains("booleanField: Boolean field error"));
    }
}
