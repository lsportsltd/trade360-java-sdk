package eu.lsports.trade360_java_sdk.common.models;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TransportMessageHeadersTests {

    @Test
    public void createFromProperties_withAllRequiredFields_createsValidInstance() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertEquals("guid-123", headers.getMessageGuid());
        assertEquals("1", headers.getMessageType());
        assertEquals("1234567890", headers.getTimestampInMs());
        assertNotNull(headers.getMessageSequence());
        assertNotNull(headers.getFixtureId());
    }

    @Test
    public void createFromProperties_withAllFields_createsValidInstance() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-456");
        properties.put("MessageType", "2");
        properties.put("timestamp_in_ms", "9876543210");
        properties.put("MessageSequence", "100");
        properties.put("FixtureId", "12345");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertEquals("guid-456", headers.getMessageGuid());
        assertEquals("2", headers.getMessageType());
        assertEquals("9876543210", headers.getTimestampInMs());
        assertEquals("100", headers.getMessageSequence());
        assertEquals("12345", headers.getFixtureId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withNullProperties_throwsIllegalArgumentException() {
        TransportMessageHeaders.createFromProperties(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withMissingMessageGuid_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withMissingMessageType_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withMissingTimestamp_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withNullMessageGuid_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", null);
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withEmptyMessageGuid_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFromProperties_withWhitespaceOnlyMessageGuid_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "   ");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders.createFromProperties(properties);
    }

    @Test
    public void createFromProperties_withMissingOptionalFields_createsValidInstance() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertNotNull(headers);
        assertEquals("", headers.getMessageSequence());
        assertEquals("", headers.getFixtureId());
    }

    @Test
    public void createFromProperties_withNullOptionalFields_createsValidInstance() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        properties.put("MessageSequence", null);
        properties.put("FixtureId", null);
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertNotNull(headers);
        assertEquals("", headers.getMessageSequence());
        assertEquals("", headers.getFixtureId());
    }

    @Test
    public void getAsMap_withAllFields_returnsMapWithAllFields() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-789");
        properties.put("MessageType", "3");
        properties.put("timestamp_in_ms", "111222333");
        properties.put("MessageSequence", "50");
        properties.put("FixtureId", "999");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        Map<String, String> resultMap = headers.getAsMap();
        
        assertEquals(5, resultMap.size());
        assertEquals("guid-789", resultMap.get("MessageGuid"));
        assertEquals("3", resultMap.get("MessageType"));
        assertEquals("111222333", resultMap.get("timestamp_in_ms"));
        assertEquals("50", resultMap.get("MessageSequence"));
        assertEquals("999", resultMap.get("FixtureId"));
    }

    @Test
    public void getAsMap_withOnlyRequiredFields_returnsMapWithRequiredFields() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-abc");
        properties.put("MessageType", "5");
        properties.put("timestamp_in_ms", "555666777");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        Map<String, String> resultMap = headers.getAsMap();
        
        assertEquals(3, resultMap.size());
        assertTrue(resultMap.containsKey("MessageGuid"));
        assertTrue(resultMap.containsKey("MessageType"));
        assertTrue(resultMap.containsKey("timestamp_in_ms"));
        assertFalse(resultMap.containsKey("MessageSequence"));
        assertFalse(resultMap.containsKey("FixtureId"));
    }

    @Test
    public void getAsMap_doesNotIncludeEmptyOptionalFields() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        properties.put("MessageSequence", "");
        properties.put("FixtureId", "   ");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        Map<String, String> resultMap = headers.getAsMap();
        
        assertFalse(resultMap.containsKey("MessageSequence"));
        assertFalse(resultMap.containsKey("FixtureId"));
    }

    @Test
    public void getAsMap_includesOnlyNonEmptyOptionalFields() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", "1");
        properties.put("timestamp_in_ms", "1234567890");
        properties.put("MessageSequence", "42");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        Map<String, String> resultMap = headers.getAsMap();
        
        assertEquals(4, resultMap.size());
        assertTrue(resultMap.containsKey("MessageSequence"));
        assertFalse(resultMap.containsKey("FixtureId"));
    }

    @Test
    public void createFromProperties_withIntegerValues_convertsToStrings() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-123");
        properties.put("MessageType", 10);
        properties.put("timestamp_in_ms", 1234567890L);
        properties.put("MessageSequence", 100);
        properties.put("FixtureId", 12345);
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertEquals("10", headers.getMessageType());
        assertEquals("1234567890", headers.getTimestampInMs());
        assertEquals("100", headers.getMessageSequence());
        assertEquals("12345", headers.getFixtureId());
    }

    @Test
    public void createFromProperties_withSpecialCharacters_preservesValues() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid-with-special-chars-!@#");
        properties.put("MessageType", "type-1");
        properties.put("timestamp_in_ms", "12345");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertEquals("guid-with-special-chars-!@#", headers.getMessageGuid());
    }

    @Test
    public void getters_returnCorrectValues() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "test-guid");
        properties.put("MessageType", "test-type");
        properties.put("timestamp_in_ms", "test-timestamp");
        properties.put("MessageSequence", "test-sequence");
        properties.put("FixtureId", "test-fixture");
        
        TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
        
        assertEquals("test-guid", headers.getMessageGuid());
        assertEquals("test-type", headers.getMessageType());
        assertEquals("test-timestamp", headers.getTimestampInMs());
        assertEquals("test-sequence", headers.getMessageSequence());
        assertEquals("test-fixture", headers.getFixtureId());
    }

    @Test
    public void createFromProperties_withEmptyMap_throwsIllegalArgumentException() {
        Map<String, Object> properties = new HashMap<>();
        
        try {
            TransportMessageHeaders.createFromProperties(properties);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("missing"));
        }
    }

    @Test
    public void exceptionMessage_containsFieldName_whenFieldIsMissing() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "guid");
        properties.put("MessageType", "type");
        
        try {
            TransportMessageHeaders.createFromProperties(properties);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("timestamp_in_ms"));
        }
    }
}

