package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameValuePairTest {
    @Test
    void testInstantiation() {
        NameValuePair pair = new NameValuePair();
        assertNotNull(pair);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        NameValuePair pair = new NameValuePair();
        assertNull(pair.name);
        assertNull(pair.value);

        pair.name = "key";
        pair.value = "value";
        assertEquals("key", pair.name);
        assertEquals("value", pair.value);
    }
} 