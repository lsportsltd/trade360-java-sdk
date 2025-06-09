package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameValuePairExpandedTest {

    @Test
    void testFieldAssignments() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "TestName";
        pair.value = "TestValue";
        
        assertEquals("TestName", pair.name);
        assertEquals("TestValue", pair.value);
    }

    @Test
    void testNullValues() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = null;
        pair.value = null;
        
        assertNull(pair.name);
        assertNull(pair.value);
    }

    @Test
    void testEmptyValues() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "";
        pair.value = "";
        
        assertEquals("", pair.name);
        assertEquals("", pair.value);
    }

    @Test
    void testSpecialCharacters() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "Name with spaces & symbols!";
        pair.value = "Value with unicode: ñáéíóú";
        
        assertEquals("Name with spaces & symbols!", pair.name);
        assertEquals("Value with unicode: ñáéíóú", pair.value);
    }

    @Test
    void testLongValues() {
        NameValuePair pair = new NameValuePair();
        
        String longName = "A".repeat(1000);
        String longValue = "B".repeat(2000);
        
        pair.name = longName;
        pair.value = longValue;
        
        assertEquals(longName, pair.name);
        assertEquals(longValue, pair.value);
    }

    @Test
    void testNumericStringValues() {
        NameValuePair pair = new NameValuePair();
        
        pair.name = "123";
        pair.value = "456.789";
        
        assertEquals("123", pair.name);
        assertEquals("456.789", pair.value);
    }
}
