package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTypeEnumComprehensiveTest {

    @Test
    void testAllEnumValues() {
        MessageType[] values = MessageType.values();
        
        assertTrue(values.length > 0);
        
        for (MessageType messageType : values) {
            assertNotNull(messageType);
            assertNotNull(messageType.name());
            assertTrue(messageType.getValue() > 0);
        }
    }

    @Test
    void testGetValueMethod() {
        for (MessageType messageType : MessageType.values()) {
            int value = messageType.getValue();
            assertTrue(value > 0);
        }
    }

    @Test
    void testFindMessageTypeWithValidId() throws ClassNotFoundException {
        for (MessageType messageType : MessageType.values()) {
            int typeId = messageType.getValue();
            MessageType found = MessageType.findMessageType(typeId);
            
            assertNotNull(found);
            assertEquals(messageType, found);
            assertEquals(typeId, found.getValue());
        }
    }

    @Test
    void testFindMessageTypeWithInvalidId() {
        assertThrows(ClassNotFoundException.class, () -> {
            MessageType.findMessageType(-1);
        });
        
        assertThrows(ClassNotFoundException.class, () -> {
            MessageType.findMessageType(99999);
        });
        
        assertThrows(ClassNotFoundException.class, () -> {
            MessageType.findMessageType(0);
        });
    }

    @Test
    void testEnumValueUniqueness() {
        MessageType[] values = MessageType.values();
        
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotEquals(values[i].getValue(), values[j].getValue(),
                    "Enum values should be unique: " + values[i] + " and " + values[j]);
            }
        }
    }

    @Test
    void testEnumNameUniqueness() {
        MessageType[] values = MessageType.values();
        
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotEquals(values[i].name(), values[j].name(),
                    "Enum names should be unique: " + values[i] + " and " + values[j]);
            }
        }
    }

    @Test
    void testValueOfMethod() {
        for (MessageType messageType : MessageType.values()) {
            MessageType found = MessageType.valueOf(messageType.name());
            assertEquals(messageType, found);
        }
    }

    @Test
    void testValueOfWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            MessageType.valueOf("INVALID_MESSAGE_TYPE");
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            MessageType.valueOf("");
        });
        
        assertThrows(NullPointerException.class, () -> {
            MessageType.valueOf(null);
        });
    }

    @Test
    void testEnumConsistency() {
        for (MessageType messageType : MessageType.values()) {
            assertEquals(messageType, MessageType.valueOf(messageType.name()));
            assertTrue(messageType.getValue() > 0);
            assertNotNull(messageType.toString());
        }
    }

    @Test
    void testFindMessageTypePerformance() throws ClassNotFoundException {
        MessageType firstType = MessageType.values()[0];
        int typeId = firstType.getValue();
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            MessageType.findMessageType(typeId);
        }
        long endTime = System.nanoTime();
        
        assertTrue(endTime - startTime < 1_000_000_000, "findMessageType should be reasonably fast");
    }

    @Test
    void testEnumToString() {
        for (MessageType messageType : MessageType.values()) {
            String toString = messageType.toString();
            assertNotNull(toString);
            assertEquals(messageType.name(), toString);
        }
    }

    @Test
    void testEnumOrdinal() {
        MessageType[] values = MessageType.values();
        
        for (int i = 0; i < values.length; i++) {
            assertEquals(i, values[i].ordinal());
        }
    }

    @Test
    void testEnumCompareTo() {
        MessageType[] values = MessageType.values();
        
        if (values.length > 1) {
            assertTrue(values[0].compareTo(values[1]) < 0);
            assertTrue(values[1].compareTo(values[0]) > 0);
            assertEquals(0, values[0].compareTo(values[0]));
        }
    }
}
