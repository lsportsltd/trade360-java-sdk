package eu.lsports.trade360_java_sdk.common.entities.keepalive;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class KeepAliveBusinessTest {
    @Test
    void testFullFieldAssignment() {
        KeepAlive keepAlive = new KeepAlive();
        keepAlive.activeEvents = List.of(1, 2, 3);
        NameValuePair pair = new NameValuePair();
        keepAlive.extraData = List.of(pair);
        keepAlive.providerId = 99;
        assertNotNull(keepAlive.activeEvents);
        assertNotNull(keepAlive.extraData);
        assertEquals(99, keepAlive.providerId);
    }

    @Test
    void testNullFields() {
        KeepAlive keepAlive = new KeepAlive();
        keepAlive.activeEvents = null;
        keepAlive.extraData = null;
        keepAlive.providerId = null;
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
        assertNull(keepAlive.providerId);
    }

    @Test
    void testEmptyCollections() {
        KeepAlive keepAlive = new KeepAlive();
        keepAlive.activeEvents = List.of();
        keepAlive.extraData = List.of();
        assertNotNull(keepAlive.activeEvents);
        assertNotNull(keepAlive.extraData);
        assertEquals(0, ((List<?>) keepAlive.activeEvents).size());
        assertEquals(0, ((List<?>) keepAlive.extraData).size());
    }
} 