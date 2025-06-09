package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class JacksonApiSerializerComprehensiveTest {

    @Test
    void testConstructorWithValidCredentials() {
        PackageCredentials credentials = new PackageCredentials("testPackage", "testUser", "testPass", "json");
        
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        assertNotNull(serializer);
        assertNotNull(serializer.getObjectMapper());
    }

    @Test
    void testConstructorWithNullCredentials() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        
        assertNotNull(serializer);
        assertNotNull(serializer.getObjectMapper());
    }

    @Test
    void testSerializeRequestWithNullRequest() {
        PackageCredentials credentials = new PackageCredentials("testPackage", "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        ObjectNode result = serializer.serializeRequest(null);
        
        assertNotNull(result);
        assertEquals("testPackage", result.get("PackageId").asText());
        assertEquals("testUser", result.get("UserName").asText());
        assertEquals("testPass", result.get("Password").asText());
        assertEquals("json", result.get("MessageFormat").asText());
    }

    @Test
    void testSerializeRequestWithValidRequest() {
        PackageCredentials credentials = new PackageCredentials("testPackage", "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        TestRequest request = new TestRequest("testValue");
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("testValue", result.get("TestField").asText());
        assertEquals("testPackage", result.get("PackageId").asText());
        assertEquals("testUser", result.get("UserName").asText());
        assertEquals("testPass", result.get("Password").asText());
        assertEquals("json", result.get("MessageFormat").asText());
    }

    @Test
    void testSerializeRequestWithNullCredentials() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        TestRequest request = new TestRequest("testValue");
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("testValue", result.get("TestField").asText());
        assertNull(result.get("PackageId"));
        assertNull(result.get("UserName"));
        assertNull(result.get("Password"));
        assertNull(result.get("MessageFormat"));
    }

    @Test
    void testSerializeToStringWithValidObject() throws JsonProcessingException {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        TestRequest request = new TestRequest("testValue");
        
        String result = serializer.serializeToString(request);
        
        assertNotNull(result);
        assertTrue(result.contains("testValue"));
        assertTrue(result.contains("TestField"));
    }

    @Test
    void testSerializeToStringWithNullObject() throws JsonProcessingException {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        
        String result = serializer.serializeToString(null);
        
        assertEquals("null", result);
    }

    @Test
    void testDeserializeToTreeWithValidJson() throws JsonProcessingException {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        String json = "{\"TestField\":\"testValue\"}";
        
        JsonNode result = serializer.deserializeToTree(json);
        
        assertNotNull(result);
        assertEquals("testValue", result.get("TestField").asText());
    }

    @Test
    void testDeserializeToTreeWithInvalidJson() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        String invalidJson = "{invalid json}";
        
        assertThrows(JsonProcessingException.class, () -> {
            serializer.deserializeToTree(invalidJson);
        });
    }

    @Test
    void testDeserializeToValueWithValidParser() throws IOException {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        String json = "{\"TestField\":\"testValue\"}";
        JsonParser parser = serializer.getObjectMapper().getFactory().createParser(json);
        
        TestRequest result = serializer.deserializeToValue(parser, new TypeReference<TestRequest>() {});
        
        assertNotNull(result);
        assertEquals("testValue", result.getTestField());
    }

    @Test
    void testDeserializeToValueWithInvalidParser() throws IOException {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        String invalidJson = "{invalid json}";
        JsonParser parser = serializer.getObjectMapper().getFactory().createParser(invalidJson);
        
        assertThrows(IOException.class, () -> {
            serializer.deserializeToValue(parser, new TypeReference<TestRequest>() {});
        });
    }

    @Test
    void testConvertValueWithValidObject() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        TestRequest request = new TestRequest("testValue");
        
        Map<String, Object> result = serializer.convertValue(request, new TypeReference<Map<String, Object>>() {});
        
        assertNotNull(result);
        assertEquals("testValue", result.get("TestField"));
    }

    @Test
    void testConvertValueWithNullObject() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        
        Map<String, Object> result = serializer.convertValue(null, new TypeReference<Map<String, Object>>() {});
        
        assertNull(result);
    }

    @Test
    void testGetObjectMapper() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        
        ObjectMapper result = serializer.getObjectMapper();
        
        assertNotNull(result);
        assertSame(result, serializer.getObjectMapper());
    }

    @Test
    void testSerializeRequestWithComplexObject() {
        PackageCredentials credentials = new PackageCredentials("testPackage", "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        ComplexTestRequest request = new ComplexTestRequest("testValue", 123, true);
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("testValue", result.get("StringField").asText());
        assertEquals(123, result.get("IntField").asInt());
        assertTrue(result.get("BooleanField").asBoolean());
        assertEquals("testPackage", result.get("PackageId").asText());
    }

    @Test
    void testSerializeRequestWithEmptyCredentials() {
        PackageCredentials credentials = new PackageCredentials("", "", "", "");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        TestRequest request = new TestRequest("testValue");
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("testValue", result.get("TestField").asText());
        assertEquals("", result.get("PackageId").asText());
        assertEquals("", result.get("UserName").asText());
        assertEquals("", result.get("Password").asText());
        assertEquals("", result.get("MessageFormat").asText());
    }

    @Test
    void testObjectMapperConfiguration() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        ObjectMapper mapper = serializer.getObjectMapper();
        
        assertNotNull(mapper);
        assertFalse(mapper.getSerializationConfig().isEnabled(com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS));
        assertFalse(mapper.getDeserializationConfig().isEnabled(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));
        assertEquals(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL, mapper.getSerializationConfig().getSerializationInclusion());
    }

    @Test
    void testSerializeRequestPreservesOriginalObject() {
        PackageCredentials credentials = new PackageCredentials("testPackage", "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        TestRequest originalRequest = new TestRequest("originalValue");
        
        ObjectNode result = serializer.serializeRequest(originalRequest);
        
        assertEquals("originalValue", originalRequest.getTestField());
        assertEquals("originalValue", result.get("TestField").asText());
    }

    private static class TestRequest {
        private String testField;
        
        public TestRequest() {}
        
        public TestRequest(String testField) {
            this.testField = testField;
        }
        
        public String getTestField() {
            return testField;
        }
        
        public void setTestField(String testField) {
            this.testField = testField;
        }
    }

    private static class ComplexTestRequest {
        private String stringField;
        private int intField;
        private boolean booleanField;
        
        public ComplexTestRequest() {}
        
        public ComplexTestRequest(String stringField, int intField, boolean booleanField) {
            this.stringField = stringField;
            this.intField = intField;
            this.booleanField = booleanField;
        }
        
        public String getStringField() {
            return stringField;
        }
        
        public void setStringField(String stringField) {
            this.stringField = stringField;
        }
        
        public int getIntField() {
            return intField;
        }
        
        public void setIntField(int intField) {
            this.intField = intField;
        }
        
        public boolean isBooleanField() {
            return booleanField;
        }
        
        public void setBooleanField(boolean booleanField) {
            this.booleanField = booleanField;
        }
    }
}
