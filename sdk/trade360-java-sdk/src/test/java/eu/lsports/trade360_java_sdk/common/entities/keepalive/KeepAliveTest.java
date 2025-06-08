package eu.lsports.trade360_java_sdk.common.entities.keepalive;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import static org.junit.jupiter.api.Assertions.*;

class KeepAliveTest {
    @Test
    void testFieldAssignmentAndNullability() {
        KeepAlive ka = new KeepAlive();
        assertNull(ka.activeEvents);
        assertNull(ka.extraData);
        assertNull(ka.providerId);
        List<Integer> events = List.of(1, 2, 3);
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        List<NameValuePair> extra = List.of(nvp);
        Integer providerId = 42;
        ka.activeEvents = events;
        ka.extraData = extra;
        ka.providerId = providerId;
        assertEquals(events, ka.activeEvents);
        assertEquals(extra, ka.extraData);
        assertEquals(providerId, ka.providerId);
    }
} 