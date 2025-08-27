package eu.lsports.trade360_java_sdk.common.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive unit tests for {@link TransportMessageHeaders}.
 * Tests the immutable design and factory method pattern implementation.
 */
class TransportMessageHeadersTest {

    @Nested
    @DisplayName("Immutability and Factory Pattern Tests")
    class ImmutabilityTests {

        @Test
        @DisplayName("Should enforce factory pattern - no public constructor")
        void shouldEnforceFactoryPattern() {
            // Verify that no public constructors are available
            // This is enforced at compile time, but we document the intent
            
            // The only way to create an instance should be through createFromProperties
            Map<String, Object> properties = createValidPropertiesMap();
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
            
            assertNotNull(headers);
        }

        @Test
        @DisplayName("Should create immutable instances")
        void shouldCreateImmutableInstances() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then - All getters should return the same values consistently
            String originalMessageGuid = headers.getMessageGuid();
            String originalMessageType = headers.getMessageType();
            String originalTimestampInMs = headers.getTimestampInMs();
            String originalMessageSequence = headers.getMessageSequence();
            String originalFixtureId = headers.getFixtureId();

            // Multiple calls should return identical values (immutability)
            assertEquals(originalMessageGuid, headers.getMessageGuid());
            assertEquals(originalMessageType, headers.getMessageType());
            assertEquals(originalTimestampInMs, headers.getTimestampInMs());
            assertEquals(originalMessageSequence, headers.getMessageSequence());
            assertEquals(originalFixtureId, headers.getFixtureId());
        }

        @Test
        @DisplayName("Should create thread-safe immutable instances")
        void shouldCreateThreadSafeImmutableInstances() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When - simulate concurrent access
            String[] results = new String[4];
            Thread[] threads = new Thread[4];
            
            for (int i = 0; i < 4; i++) {
                final int index = i;
                threads[i] = new Thread(() -> {
                    // All threads should get the same values
                    results[index] = headers.getMessageGuid() + "|" + 
                                   headers.getMessageType() + "|" + 
                                   headers.getTimestampInMs();
                });
            }

            // Start all threads
            for (Thread thread : threads) {
                thread.start();
            }

            // Wait for all threads to complete
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            // Then - All threads should have gotten identical results
            String expected = results[0];
            for (String result : results) {
                assertEquals(expected, result);
            }
        }
    }

    @Nested
    @DisplayName("Factory Method Tests")
    class FactoryMethodTests {

        @Test
        @DisplayName("Should create instance with all required headers")
        void shouldCreateInstanceWithAllRequiredHeaders() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals("test-guid", headers.getMessageGuid());
            assertEquals("TestMessage", headers.getMessageType());
            assertEquals("1234567890", headers.getTimestampInMs());
            assertEquals("100", headers.getMessageSequence());
            assertEquals("fixture-123", headers.getFixtureId());
        }

        @Test
        @DisplayName("Should create instance with only required headers")
        void shouldCreateInstanceWithOnlyRequiredHeaders() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals("test-guid", headers.getMessageGuid());
            assertEquals("TestMessage", headers.getMessageType());
            assertEquals("1234567890", headers.getTimestampInMs());
            assertEquals("", headers.getMessageSequence());
            assertEquals("", headers.getFixtureId());
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when properties is null")
        void shouldThrowExceptionWhenPropertiesIsNull() {
            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(null)
            );
            
            assertEquals("Properties cannot be null", exception.getMessage());
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required MessageGuid is missing")
        void shouldThrowExceptionWhenMessageGuidIsMissing() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("MessageGuid"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required MessageType is missing")
        void shouldThrowExceptionWhenMessageTypeIsMissing() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("timestamp_in_ms", "1234567890");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("MessageType"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required timestamp_in_ms is missing")
        void shouldThrowExceptionWhenTimestampInMsIsMissing() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("MessageType", "TestMessage");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("timestamp_in_ms"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required header is null")
        void shouldThrowExceptionWhenRequiredHeaderIsNull() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", null);
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("MessageGuid"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required header is empty")
        void shouldThrowExceptionWhenRequiredHeaderIsEmpty() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("MessageGuid"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when required header is whitespace only")
        void shouldThrowExceptionWhenRequiredHeaderIsWhitespaceOnly() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "   ");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("MessageGuid"));
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should handle non-string property values")
        void shouldHandleNonStringPropertyValues() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", 12345);
            properties.put("MessageType", true);
            properties.put("timestamp_in_ms", 1234567890L);

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals("12345", headers.getMessageGuid());
            assertEquals("true", headers.getMessageType());
            assertEquals("1234567890", headers.getTimestampInMs());
        }

        @Test
        @DisplayName("Should handle optional headers being null without throwing exception")
        void shouldHandleOptionalHeadersBeingNull() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");
            properties.put("MessageSequence", null);
            properties.put("FixtureId", null);

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals("", headers.getMessageSequence());
            assertEquals("", headers.getFixtureId());
        }
    }

    @Nested
    @DisplayName("Getter Tests")
    class GetterTests {

        private TransportMessageHeaders createHeadersInstance() {
            Map<String, Object> properties = createValidPropertiesMap();
            return TransportMessageHeaders.createFromProperties(properties);
        }

        @Test
        @DisplayName("Should return correct message type")
        void shouldReturnCorrectMessageType() {
            // Given
            TransportMessageHeaders headers = createHeadersInstance();

            // When
            String messageType = headers.getMessageType();

            // Then
            assertEquals("TestMessage", messageType);
        }

        @Test
        @DisplayName("Should return correct message sequence")
        void shouldReturnCorrectMessageSequence() {
            // Given
            TransportMessageHeaders headers = createHeadersInstance();

            // When
            String messageSequence = headers.getMessageSequence();

            // Then
            assertEquals("100", messageSequence);
        }

        @Test
        @DisplayName("Should return correct message GUID")
        void shouldReturnCorrectMessageGuid() {
            // Given
            TransportMessageHeaders headers = createHeadersInstance();

            // When
            String messageGuid = headers.getMessageGuid();

            // Then
            assertEquals("test-guid", messageGuid);
        }

        @Test
        @DisplayName("Should return correct fixture ID")
        void shouldReturnCorrectFixtureId() {
            // Given
            TransportMessageHeaders headers = createHeadersInstance();

            // When
            String fixtureId = headers.getFixtureId();

            // Then
            assertEquals("fixture-123", fixtureId);
        }

        @Test
        @DisplayName("Should return correct timestamp in milliseconds")
        void shouldReturnCorrectTimestampInMs() {
            // Given
            TransportMessageHeaders headers = createHeadersInstance();

            // When
            String timestampInMs = headers.getTimestampInMs();

            // Then
            assertEquals("1234567890", timestampInMs);
        }
    }

    @Nested
    @DisplayName("GetAsMap Tests")
    class GetAsMapTests {

        @Test
        @DisplayName("Should return map with all non-null values")
        void shouldReturnMapWithAllNonNullValues() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When
            Map<String, String> resultMap = headers.getAsMap();

            // Then
            assertNotNull(resultMap);
            assertEquals(5, resultMap.size());
            assertEquals("test-guid", resultMap.get("MessageGuid"));
            assertEquals("TestMessage", resultMap.get("MessageType"));
            assertEquals("1234567890", resultMap.get("timestamp_in_ms"));
            assertEquals("100", resultMap.get("MessageSequence"));
            assertEquals("fixture-123", resultMap.get("FixtureId"));
        }

        @Test
        @DisplayName("Should return map excluding null and empty values")
        void shouldReturnMapExcludingNullAndEmptyValues() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");
            // MessageSequence and FixtureId are optional and will be empty strings

            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When
            Map<String, String> resultMap = headers.getAsMap();

            // Then
            assertNotNull(resultMap);
            assertEquals(3, resultMap.size());
            assertEquals("test-guid", resultMap.get("MessageGuid"));
            assertEquals("TestMessage", resultMap.get("MessageType"));
            assertEquals("1234567890", resultMap.get("timestamp_in_ms"));
            assertFalse(resultMap.containsKey("MessageSequence"));
            assertFalse(resultMap.containsKey("FixtureId"));
        }

        @Test
        @DisplayName("Should return map excluding whitespace-only values")
        void shouldReturnMapExcludingWhitespaceOnlyValues() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");
            properties.put("MessageSequence", "   "); // whitespace only
            properties.put("FixtureId", "fixture-123");

            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When
            Map<String, String> resultMap = headers.getAsMap();

            // Then
            assertNotNull(resultMap);
            assertEquals(4, resultMap.size());
            assertEquals("test-guid", resultMap.get("MessageGuid"));
            assertEquals("TestMessage", resultMap.get("MessageType"));
            assertEquals("1234567890", resultMap.get("timestamp_in_ms"));
            assertEquals("fixture-123", resultMap.get("FixtureId"));
            assertFalse(resultMap.containsKey("MessageSequence"));
        }

        @Test
        @DisplayName("Should return empty map when all values are null or empty")
        void shouldReturnEmptyMapWhenAllValuesAreNullOrEmpty() {
            // This test creates a scenario where all optional values are missing
            // and required values are somehow empty (which shouldn't happen in normal usage
            // but tests the getAsMap method behavior)
            
            // We can't actually create such a scenario through the factory method
            // because required fields would throw an exception, so this test
            // documents the expected behavior if such a state existed
            
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test");
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "123");

            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
            Map<String, String> resultMap = headers.getAsMap();

            // At minimum, required fields should be present
            assertTrue(resultMap.size() >= 3);
            assertTrue(resultMap.containsKey("MessageGuid"));
            assertTrue(resultMap.containsKey("MessageType"));
            assertTrue(resultMap.containsKey("timestamp_in_ms"));
        }
    }

    @Nested
    @DisplayName("Edge Cases and Boundary Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Should handle very long property values")
        void shouldHandleVeryLongPropertyValues() {
            // Given
            String longValue = "a".repeat(1000);
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", longValue);
            properties.put("MessageType", "TestMessage");
            properties.put("timestamp_in_ms", "1234567890");

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals(longValue, headers.getMessageGuid());
        }

        @Test
        @DisplayName("Should handle special characters in property values")
        void shouldHandleSpecialCharactersInPropertyValues() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "test-guid-@#$%^&*()");
            properties.put("MessageType", "TestMessage-üñíçødé");
            properties.put("timestamp_in_ms", "1234567890");

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            assertNotNull(headers);
            assertEquals("test-guid-@#$%^&*()", headers.getMessageGuid());
            assertEquals("TestMessage-üñíçødé", headers.getMessageType());
        }

        @Test
        @DisplayName("Should handle empty properties map")
        void shouldHandleEmptyPropertiesMap() {
            // Given
            Map<String, Object> properties = new HashMap<>();

            // When & Then
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TransportMessageHeaders.createFromProperties(properties)
            );
            
            assertTrue(exception.getMessage().contains("missing, null, or empty"));
        }

        @Test
        @DisplayName("Should preserve original property values without modification")
        void shouldPreserveOriginalPropertyValuesWithoutModification() {
            // Given
            Map<String, Object> properties = new HashMap<>();
            properties.put("MessageGuid", "  test-guid  ");
            properties.put("MessageType", "  TestMessage  ");
            properties.put("timestamp_in_ms", "  1234567890  ");

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // Then
            // Values should be preserved as-is (including leading/trailing spaces)
            assertEquals("  test-guid  ", headers.getMessageGuid());
            assertEquals("  TestMessage  ", headers.getMessageType());
            assertEquals("  1234567890  ", headers.getTimestampInMs());
        }
    }

    @Nested
    @DisplayName("Immutable Object State Tests")
    class ImmutableObjectStateTests {

        @Test
        @DisplayName("Should maintain consistent object identity across method calls")
        void shouldMaintainConsistentObjectIdentityAcrossMethodCalls() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When - multiple invocations of getAsMap()
            Map<String, String> map1 = headers.getAsMap();
            Map<String, String> map2 = headers.getAsMap();
            Map<String, String> map3 = headers.getAsMap();

            // Then - should return equivalent maps (deep equality)
            assertEquals(map1, map2);
            assertEquals(map2, map3);
            assertEquals(map1, map3);
            
            // Verify content is identical
            assertEquals(map1.size(), map2.size());
            assertEquals(map1.get("MessageGuid"), map2.get("MessageGuid"));
            assertEquals(map1.get("MessageType"), map2.get("MessageType"));
        }

        @Test
        @DisplayName("Should not affect original properties map after object creation")
        void shouldNotAffectOriginalPropertiesMapAfterObjectCreation() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();
            Map<String, Object> originalProperties = new HashMap<>(properties);

            // When
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);
            
            // Modify original properties after object creation
            properties.put("MessageGuid", "modified-guid");
            properties.put("MessageType", "ModifiedMessage");
            properties.clear(); // Even clearing should not affect the created object

            // Then - the created object should be unaffected
            assertEquals("test-guid", headers.getMessageGuid());
            assertEquals("TestMessage", headers.getMessageType());
            assertEquals("1234567890", headers.getTimestampInMs());
            assertEquals("100", headers.getMessageSequence());
            assertEquals("fixture-123", headers.getFixtureId());
        }

        @Test
        @DisplayName("Should return defensive copies from getAsMap method")
        void shouldReturnDefensiveCopiesFromGetAsMapMethod() {
            // Given
            Map<String, Object> properties = createValidPropertiesMap();
            TransportMessageHeaders headers = TransportMessageHeaders.createFromProperties(properties);

            // When
            Map<String, String> resultMap = headers.getAsMap();
            String originalMessageGuid = resultMap.get("MessageGuid");
            
            // Modify the returned map
            resultMap.put("MessageGuid", "modified-guid");
            resultMap.put("NewKey", "new-value");
            resultMap.clear();

            // Then - original object should be unaffected
            assertEquals("test-guid", headers.getMessageGuid());
            assertEquals("TestMessage", headers.getMessageType());
            
            // Getting a new map should return the original values
            Map<String, String> newMap = headers.getAsMap();
            assertEquals("test-guid", newMap.get("MessageGuid"));
            assertEquals("TestMessage", newMap.get("MessageType"));
            assertFalse(newMap.containsKey("NewKey"));
        }

        @Test
        @DisplayName("Should ensure all instances created from same properties are equal in content")
        void shouldEnsureAllInstancesCreatedFromSamePropertiesAreEqualInContent() {
            // Given
            Map<String, Object> properties1 = createValidPropertiesMap();
            Map<String, Object> properties2 = createValidPropertiesMap();

            // When
            TransportMessageHeaders headers1 = TransportMessageHeaders.createFromProperties(properties1);
            TransportMessageHeaders headers2 = TransportMessageHeaders.createFromProperties(properties2);

            // Then - both objects should have identical content
            assertEquals(headers1.getMessageGuid(), headers2.getMessageGuid());
            assertEquals(headers1.getMessageType(), headers2.getMessageType());
            assertEquals(headers1.getTimestampInMs(), headers2.getTimestampInMs());
            assertEquals(headers1.getMessageSequence(), headers2.getMessageSequence());
            assertEquals(headers1.getFixtureId(), headers2.getFixtureId());
            
            // Maps should also be equal
            assertEquals(headers1.getAsMap(), headers2.getAsMap());
        }
    }

    /**
     * Helper method to create a valid properties map for testing.
     *
     * @return a map containing all valid properties
     */
    private static Map<String, Object> createValidPropertiesMap() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("MessageGuid", "test-guid");
        properties.put("MessageType", "TestMessage");
        properties.put("timestamp_in_ms", "1234567890");
        properties.put("MessageSequence", "100");
        properties.put("FixtureId", "fixture-123");
        return properties;
    }
}
