package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdNamePairTest {
    @Test
    void testRecordInstantiationAndAccessors() {
        IdNamePair pair = new IdNamePair(123, "Test Name");
        assertNotNull(pair);
        assertEquals(123, pair.id());
        assertEquals("Test Name", pair.name());
    }

    @Test
    void testNullValues() {
        IdNamePair pair = new IdNamePair(null, null);
        assertNull(pair.id());
        assertNull(pair.name());
    }

    @Test
    void testEquality() {
        IdNamePair pair1 = new IdNamePair(1, "A");
        IdNamePair pair2 = new IdNamePair(1, "A");
        IdNamePair pair3 = new IdNamePair(2, "B");

        assertEquals(pair1, pair2);
        assertEquals(pair1.hashCode(), pair2.hashCode());
        assertNotEquals(pair1, pair3);
        assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }

    @Test
    void testToString() {
        IdNamePair pair = new IdNamePair(1, "Test");
        String str = pair.toString();
        assertTrue(str.contains("id=1"));
        assertTrue(str.contains("name=Test"));
    }

    @Test
    void testZeroIdAssignment() {
        IdNamePair pair = new IdNamePair(0, "Zero ID");
        
        assertEquals(0, pair.id());
        assertEquals("Zero ID", pair.name());
    }
    
    @Test
    void testNegativeIdAssignment() {
        IdNamePair pair = new IdNamePair(-1, "Negative ID");
        
        assertEquals(-1, pair.id());
        assertEquals("Negative ID", pair.name());
    }

    @Test
    void testEmptyNameAssignment() {
        IdNamePair pair = new IdNamePair(0, "");
        
        assertEquals(0, pair.id());
        assertEquals("", pair.name());
    }
}


