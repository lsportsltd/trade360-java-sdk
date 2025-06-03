package eu.lsports.trade360_java_sdk.common.entities.message_types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeartbeatUpdateTest {
    @Test
    void testEntityKey() {
        assertEquals(32, HeartbeatUpdate.entityKey);
    }
} 