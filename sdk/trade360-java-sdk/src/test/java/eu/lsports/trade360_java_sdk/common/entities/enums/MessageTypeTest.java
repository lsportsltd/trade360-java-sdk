package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTypeTest {
    @Test
    void testEnumValues() {
        for (MessageType type : MessageType.values()) {
            assertNotNull(type);
            assertEquals(type, MessageType.valueOf(type.name()));
        }
    }
} 