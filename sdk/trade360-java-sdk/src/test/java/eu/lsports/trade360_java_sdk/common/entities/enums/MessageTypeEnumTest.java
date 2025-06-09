package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTypeEnumTest {

    @Test
    void testEnumValues() {
        MessageType[] values = MessageType.values();
        assertNotNull(values);
        assertTrue(values.length > 0);
    }

    @Test
    void testValueOf() {
        for (MessageType messageType : MessageType.values()) {
            assertEquals(messageType, MessageType.valueOf(messageType.name()));
        }
    }

    @Test
    void testEnumInstantiation() {
        assertNotNull(MessageType.values());
    }

    @Test
    void testEnumConsistency() {
        MessageType[] values1 = MessageType.values();
        MessageType[] values2 = MessageType.values();
        assertEquals(values1.length, values2.length);
        
        for (int i = 0; i < values1.length; i++) {
            assertEquals(values1[i], values2[i]);
        }
    }
}
