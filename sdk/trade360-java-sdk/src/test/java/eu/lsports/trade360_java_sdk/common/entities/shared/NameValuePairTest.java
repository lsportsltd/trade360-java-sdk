package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameValuePairTest {
    @Test
    void testFieldAssignment() {
        NameValuePair pair = new NameValuePair();
        pair.name = "foo";
        pair.value = "bar";
        assertEquals("foo", pair.name);
        assertEquals("bar", pair.value);
    }
} 