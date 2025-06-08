package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameValuePairBusinessTest {
    @Test
    void testNameAndValueAssignment() {
        NameValuePair pair = new NameValuePair();
        pair.name = "key";
        pair.value = "value";
        assertEquals("key", pair.name);
        assertEquals("value", pair.value);
    }

    @Test
    void testNullNameAndValue() {
        NameValuePair pair = new NameValuePair();
        pair.name = null;
        pair.value = null;
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    void testEmptyNameAndValue() {
        NameValuePair pair = new NameValuePair();
        pair.name = "";
        pair.value = "";
        assertEquals("", pair.name);
        assertEquals("", pair.value);
    }
} 