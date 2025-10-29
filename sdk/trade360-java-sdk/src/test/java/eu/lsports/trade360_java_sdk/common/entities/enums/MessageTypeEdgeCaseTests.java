package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Edge case tests for MessageType enum.
 * Tests documented issues from Confluence test cases including:
 * - Unsupported message type ID 222
 * - Null and boundary value handling
 */
public class MessageTypeEdgeCaseTests {

    @Test
    public void findMessageType_withValidId1_returnsFixtureMetadataUpdate() throws ClassNotFoundException {
        // Arrange & Act
        MessageType result = MessageType.findMessageType(1);

        // Assert
        assertNotNull(result);
        assertEquals(MessageType.FixtureMetadataUpdate, result);
        assertEquals(1, result.getValue());
    }

    @Test
    public void findMessageType_withValidId3_returnsMarketUpdate() throws ClassNotFoundException {
        // Arrange & Act
        MessageType result = MessageType.findMessageType(3);

        // Assert
        assertNotNull(result);
        assertEquals(MessageType.MarketUpdate, result);
        assertEquals(3, result.getValue());
    }

    @Test
    public void findMessageType_withValidId42_returnsOutrightSettlementsUpdate() throws ClassNotFoundException {
        // Arrange & Act
        MessageType result = MessageType.findMessageType(42);

        // Assert
        assertNotNull(result);
        assertEquals(MessageType.OutrightSettlementsUpdate, result);
        assertEquals(42, result.getValue());
    }

    @Test(expected = ClassNotFoundException.class)
    public void findMessageType_withUnsupportedId222_throwsClassNotFoundException() throws ClassNotFoundException {
        // Confluence-documented edge case: Message type ID 222 is unsupported
        // Expected: Should throw ClassNotFoundException
        MessageType.findMessageType(222);
    }

    @Test(expected = ClassNotFoundException.class)
    public void findMessageType_withNegativeId_throwsClassNotFoundException() throws ClassNotFoundException {
        // Arrange & Act & Assert
        MessageType.findMessageType(-1);
    }

    @Test(expected = ClassNotFoundException.class)
    public void findMessageType_withZeroId_throwsClassNotFoundException() throws ClassNotFoundException {
        // Arrange & Act & Assert
        MessageType.findMessageType(0);
    }

    @Test(expected = ClassNotFoundException.class)
    public void findMessageType_withVeryLargeId_throwsClassNotFoundException() throws ClassNotFoundException {
        // Arrange & Act & Assert
        MessageType.findMessageType(Integer.MAX_VALUE);
    }

    @Test
    public void findMessageType_withAllValidIds_returnsCorrectTypes() throws ClassNotFoundException {
        // Test all supported message type IDs from Confluence documentation
        int[] validIds = {1, 2, 3, 31, 32, 35, 37, 38, 39, 40, 41, 42, 43};
        
        for (int id : validIds) {
            MessageType result = MessageType.findMessageType(id);
            assertNotNull("Message type for ID " + id + " should not be null", result);
            assertEquals("Message type ID should match", id, result.getValue());
        }
    }

    @Test
    public void getValue_forAllEnumValues_returnsPositiveValue() {
        // Verify all enum values have valid positive integer IDs
        for (MessageType type : MessageType.values()) {
            assertTrue("Message type value should be positive: " + type.name(), 
                      type.getValue() > 0);
        }
    }

    @Test
    public void getMessageClass_forAllEnumValues_returnsNonNullClass() {
        // Verify all enum values have associated message classes
        for (MessageType type : MessageType.values()) {
            assertNotNull("Message type should have associated class: " + type.name(), 
                         type.getMessageClass());
        }
    }

    @Test
    public void hasBody_forHeartbeatUpdate_returnsFalse() {
        // HeartbeatUpdate is defined with hasBody=false
        assertFalse("HeartbeatUpdate should not have body", 
                   MessageType.HeartbeatUpdate.hasBody());
    }

    @Test
    public void hasBody_forMarketUpdate_returnsTrue() {
        // Most message types have hasBody=true by default
        assertTrue("MarketUpdate should have body", 
                  MessageType.MarketUpdate.hasBody());
    }

    @Test
    public void enumValues_containsAllRequiredMessageTypes() {
        // Verify all 13 message types from Confluence documentation exist
        MessageType[] allTypes = MessageType.values();
        assertEquals("Should have 13 message types", 13, allTypes.length);
    }

    @Test
    public void findMessageType_exceptionMessage_containsTypeId() {
        // Verify exception message contains the invalid type ID for debugging
        try {
            MessageType.findMessageType(999);
            fail("Should have thrown ClassNotFoundException");
        } catch (ClassNotFoundException e) {
            assertTrue("Exception message should contain type ID", 
                      e.getMessage().contains("999"));
        }
    }
}

