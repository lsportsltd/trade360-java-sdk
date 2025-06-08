package eu.lsports.trade360_java_sdk.common.entities.keepalive;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class KeepAliveTest {
    @Test
    void testFieldAssignmentAndNullability() {
        KeepAlive keepAlive = new KeepAlive();
        assertNull(keepAlive.activeEvents);
        assertNull(keepAlive.extraData);
        assertNull(keepAlive.providerId);

        keepAlive.activeEvents = Arrays.asList(1, 2, 3);
        NameValuePair nvp = new NameValuePair();
        nvp.name = "foo";
        nvp.value = "bar";
        keepAlive.extraData = Arrays.asList(nvp);
        keepAlive.providerId = 99;

        assertNotNull(keepAlive.activeEvents);
        assertNotNull(keepAlive.extraData);
        assertEquals(99, keepAlive.providerId);
    }
} 