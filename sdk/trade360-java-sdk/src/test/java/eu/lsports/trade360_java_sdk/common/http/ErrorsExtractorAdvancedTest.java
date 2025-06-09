package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ErrorsExtractorAdvancedTest {

    @Test
    void testErrorsExtractorInterface() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectNode testNode = JsonNodeFactory.instance.objectNode();
        testNode.put("test", "value");
        
        Iterable<String> result = extractor.extractErrors(testNode, mockSerializer);
        
        assertNotNull(result);
    }

    @Test
    void testErrorsExtractorWithNullNode() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        
        Iterable<String> result = extractor.extractErrors(null, mockSerializer);
        
        assertNull(result);
    }

    @Test
    void testErrorsExtractorWithNullSerializer() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        ObjectNode testNode = JsonNodeFactory.instance.objectNode();
        testNode.put("test", "value");
        
        Iterable<String> result = extractor.extractErrors(testNode, null);
        
        assertNotNull(result);
    }

    @Test
    void testErrorsExtractorWithEmptyNode() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectNode emptyNode = JsonNodeFactory.instance.objectNode();
        
        Iterable<String> result = extractor.extractErrors(emptyNode, mockSerializer);
        
        assertNotNull(result);
    }

    @Test
    void testErrorsExtractorWithComplexNode() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectNode complexNode = JsonNodeFactory.instance.objectNode();
        ObjectNode nestedNode = JsonNodeFactory.instance.objectNode();
        nestedNode.put("nested", "value");
        complexNode.set("complex", nestedNode);
        complexNode.put("simple", "value");
        
        Iterable<String> result = extractor.extractErrors(complexNode, mockSerializer);
        
        assertNotNull(result);
    }

    @Test
    void testErrorsExtractorMultipleImplementations() {
        ErrorsExtractor extractor1 = new TestErrorsExtractor();
        ErrorsExtractor extractor2 = new AlternativeErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectNode testNode = JsonNodeFactory.instance.objectNode();
        testNode.put("test", "value");
        
        Iterable<String> result1 = extractor1.extractErrors(testNode, mockSerializer);
        Iterable<String> result2 = extractor2.extractErrors(testNode, mockSerializer);
        
        assertNotNull(result1);
        assertNotNull(result2);
        assertNotEquals(result1, result2);
    }

    @Test
    void testErrorsExtractorConsistency() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer = mock(JsonApiSerializer.class);
        ObjectNode testNode = JsonNodeFactory.instance.objectNode();
        testNode.put("test", "value");
        
        Iterable<String> result1 = extractor.extractErrors(testNode, mockSerializer);
        Iterable<String> result2 = extractor.extractErrors(testNode, mockSerializer);
        
        assertEquals(result1.toString(), result2.toString());
    }

    @Test
    void testErrorsExtractorWithDifferentSerializers() {
        ErrorsExtractor extractor = new TestErrorsExtractor();
        JsonApiSerializer mockSerializer1 = mock(JsonApiSerializer.class);
        JsonApiSerializer mockSerializer2 = mock(JsonApiSerializer.class);
        ObjectNode testNode = JsonNodeFactory.instance.objectNode();
        testNode.put("test", "value");
        
        Iterable<String> result1 = extractor.extractErrors(testNode, mockSerializer1);
        Iterable<String> result2 = extractor.extractErrors(testNode, mockSerializer2);
        
        assertNotNull(result1);
        assertNotNull(result2);
    }

    private static class TestErrorsExtractor implements ErrorsExtractor {
        @Override
        public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
            if (bodyJsonNode == null) {
                return null;
            }
            return java.util.Collections.singletonList("Test error");
        }
    }

    private static class AlternativeErrorsExtractor implements ErrorsExtractor {
        @Override
        public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
            if (bodyJsonNode == null) {
                return null;
            }
            return java.util.Collections.singletonList("Alternative error");
        }
    }
}
