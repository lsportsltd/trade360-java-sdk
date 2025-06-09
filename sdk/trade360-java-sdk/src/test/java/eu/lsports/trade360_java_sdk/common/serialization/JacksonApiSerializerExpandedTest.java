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
import static org.mockito.Mockito.*;

class JacksonApiSerializerExpandedTest {

    @Test
    void testSerializeRequestWithCredentials() {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        TestRequest request = new TestRequest();
        request.field1 = "value1";
        request.field2 = 42;
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("value1", result.get("Field1").asText());
        assertEquals(42, result.get("Field2").asInt());
        assertEquals(123, result.get("PackageId").asInt());
        assertEquals("testUser", result.get("UserName").asText());
        assertEquals("testPass", result.get("Password").asText());
        assertEquals("json", result.get("MessageFormat").asText());
    }

    @Test
    void testSerializeRequestWithNullCredentials() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        
        TestRequest request = new TestRequest();
        request.field1 = "value1";
        
        ObjectNode result = serializer.serializeRequest(request);
        
        assertNotNull(result);
        assertEquals("value1", result.get("Field1").asText());
        assertNull(result.get("PackageId"));
    }

    @Test
    void testSerializeRequestWithNullRequest() {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        ObjectNode result = serializer.serializeRequest(null);
        
        assertNotNull(result);
        assertEquals(123, result.get("PackageId").asInt());
        assertEquals("testUser", result.get("UserName").asText());
        assertEquals("testPass", result.get("Password").asText());
        assertEquals("json", result.get("MessageFormat").asText());
    }

    @Test
    void testSerializeToString() throws JsonProcessingException {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        TestRequest request = new TestRequest();
        request.field1 = "value1";
        
        String result = serializer.serializeToString(request);
        
        assertNotNull(result);
        assertTrue(result.contains("Field1"));
        assertTrue(result.contains("value1"));
    }

    @Test
    void testDeserializeToTree() throws JsonProcessingException {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        String json = "{\"Field1\":\"value1\",\"Field2\":42}";
        
        JsonNode result = serializer.deserializeToTree(json);
        
        assertNotNull(result);
        assertEquals("value1", result.get("Field1").asText());
        assertEquals(42, result.get("Field2").asInt());
    }

    @Test
    void testDeserializeToValue() throws IOException {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        JsonParser parser = serializer.getObjectMapper().createParser(json);
        
        Map<String, String> result = serializer.deserializeToValue(parser, new TypeReference<Map<String, String>>() {});
        
        assertNotNull(result);
        assertEquals("value1", result.get("key1"));
        assertEquals("value2", result.get("key2"));
    }

    @Test
    void testConvertValue() {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        TestRequest request = new TestRequest();
        request.field1 = "value1";
        request.field2 = 42;
        
        Map<String, Object> result = serializer.convertValue(request, new TypeReference<Map<String, Object>>() {});
        
        assertNotNull(result);
        assertEquals("value1", result.get("Field1"));
        assertEquals(42, result.get("Field2"));
    }

    @Test
    void testGetObjectMapper() {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        ObjectMapper mapper = serializer.getObjectMapper();
        
        assertNotNull(mapper);
    }

    @Test
    void testConstructorWithCredentials() {
        PackageCredentials credentials = new PackageCredentials(123, "testUser", "testPass", "json");
        
        JacksonApiSerializer serializer = new JacksonApiSerializer(credentials);
        
        assertNotNull(serializer);
    }

    private static class TestRequest {
        public String field1;
        public int field2;
    }
}
