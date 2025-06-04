package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.keepalive.KeepAlive;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KeepAliveUpdateTest {
    @Test
    void testFieldAssignment() {
        KeepAliveUpdate update = new KeepAliveUpdate();
        assertNotNull(update);
    }
} 