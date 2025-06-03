package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KeepAliveUpdateTest {
    @Test
    void testFieldAssignment() {
        KeepAliveUpdate update = new KeepAliveUpdate();
        KeepAlive keepAlive = new KeepAlive();
        update.keepAlive = keepAlive;
        assertEquals(31, KeepAliveUpdate.entityKey);
        assertEquals(keepAlive, update.keepAlive);
    }
} 