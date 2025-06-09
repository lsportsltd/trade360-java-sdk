package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class JacksonApiSerializerComprehensiveTest {

    private JacksonApiSerializer serializer;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        serializer = new JacksonApiSerializer();
        objectMapper = serializer.getObjectMapper();
    }

    @Test
    void testSerializeComplexObject() {
        Map<String, Object> complexObject = new HashMap<>();
        complexObject.put("id", 123);
        complexObject.put("name", "Test Object");
        complexObject.put("active", true);
        complexObject.put("values", Arrays.asList(1, 2, 3));
        
        String json = serializer.serialize(complexObject);
        assertNotNull(json);
        assertTrue(json.contains("\"id\":123"));
        assertTrue(json.contains("\"name\":\"Test Object\""));
        assertTrue(json.contains("\"active\":true"));
    }

    @Test
    void testDeserializeComplexObject() {
        String json = "{\"id\":456,\"name\":\"Deserialized Object\",\"active\":false,\"count\":10}";
        
        Map<String, Object> result = serializer.deserialize(json, new TypeReference<Map<String, Object>>() {});
        
        assertNotNull(result);
        assertEquals(456, result.get("id"));
        assertEquals("Deserialized Object", result.get("name"));
        assertEquals(false, result.get("active"));
        assertEquals(10, result.get("count"));
    }

    @Test
    void testSerializeNullObject() {
        String result = serializer.serialize(null);
        assertEquals("null", result);
    }

    @Test
    void testDeserializeEmptyJson() {
        String json = "{}";
        Map<String, Object> result = serializer.deserialize(json, new TypeReference<Map<String, Object>>() {});
        
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSerializeList() {
        List<String> list = Arrays.asList("item1", "item2", "item3");
        String json = serializer.serialize(list);
        
        assertNotNull(json);
        assertTrue(json.contains("\"item1\""));
        assertTrue(json.contains("\"item2\""));
        assertTrue(json.contains("\"item3\""));
    }

    @Test
    void testDeserializeList() {
        String json = "[\"value1\",\"value2\",\"value3\"]";
        List<String> result = serializer.deserialize(json, new TypeReference<List<String>>() {});
        
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("value1", result.get(0));
        assertEquals("value2", result.get(1));
        assertEquals("value3", result.get(2));
    }

    @Test
    void testObjectMapperConfiguration() {
        ObjectMapper mapper = serializer.getObjectMapper();
        assertNotNull(mapper);
        assertSame(objectMapper, mapper);
    }

    @Test
    void testSerializeWithSpecialCharacters() {
        Map<String, String> object = new HashMap<>();
        object.put("special", "Test with \"quotes\" and \n newlines");
        
        String json = serializer.serialize(object);
        assertNotNull(json);
        assertTrue(json.contains("\\\"quotes\\\""));
        assertTrue(json.contains("\\n"));
    }
}
