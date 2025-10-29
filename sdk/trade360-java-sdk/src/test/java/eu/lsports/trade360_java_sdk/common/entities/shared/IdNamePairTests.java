package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdNamePairTests {

    @Test
    public void constructor_withValidValues_createsInstance() {
        IdNamePair pair = new IdNamePair(1, "test");
        
        assertEquals(Integer.valueOf(1), pair.id());
        assertEquals("test", pair.name());
    }

    @Test
    public void constructor_withNullId_createsInstance() {
        IdNamePair pair = new IdNamePair(null, "test");
        
        assertNull(pair.id());
        assertEquals("test", pair.name());
    }

    @Test
    public void constructor_withNullName_createsInstance() {
        IdNamePair pair = new IdNamePair(1, null);
        
        assertEquals(Integer.valueOf(1), pair.id());
        assertNull(pair.name());
    }

    @Test
    public void constructor_withBothNull_createsInstance() {
        IdNamePair pair = new IdNamePair(null, null);
        
        assertNull(pair.id());
        assertNull(pair.name());
    }

    @Test
    public void constructor_withZeroId_createsInstance() {
        IdNamePair pair = new IdNamePair(0, "zero");
        
        assertEquals(Integer.valueOf(0), pair.id());
        assertEquals("zero", pair.name());
    }

    @Test
    public void constructor_withNegativeId_createsInstance() {
        IdNamePair pair = new IdNamePair(-1, "negative");
        
        assertEquals(Integer.valueOf(-1), pair.id());
        assertEquals("negative", pair.name());
    }

    @Test
    public void constructor_withLargeId_createsInstance() {
        IdNamePair pair = new IdNamePair(Integer.MAX_VALUE, "max");
        
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), pair.id());
        assertEquals("max", pair.name());
    }

    @Test
    public void constructor_withEmptyName_createsInstance() {
        IdNamePair pair = new IdNamePair(1, "");
        
        assertEquals(Integer.valueOf(1), pair.id());
        assertEquals("", pair.name());
    }

    @Test
    public void constructor_withSpecialCharactersInName_createsInstance() {
        IdNamePair pair = new IdNamePair(1, "name-with-special!@#$");
        
        assertEquals(Integer.valueOf(1), pair.id());
        assertEquals("name-with-special!@#$", pair.name());
    }

    @Test
    public void constructor_withLongName_createsInstance() {
        String longName = "A".repeat(1000);
        IdNamePair pair = new IdNamePair(1, longName);
        
        assertEquals(longName, pair.name());
    }

    @Test
    public void equals_withSameValues_returnsTrue() {
        IdNamePair pair1 = new IdNamePair(1, "test");
        IdNamePair pair2 = new IdNamePair(1, "test");
        
        assertEquals(pair1, pair2);
    }

    @Test
    public void equals_withDifferentIds_returnsFalse() {
        IdNamePair pair1 = new IdNamePair(1, "test");
        IdNamePair pair2 = new IdNamePair(2, "test");
        
        assertNotEquals(pair1, pair2);
    }

    @Test
    public void equals_withDifferentNames_returnsFalse() {
        IdNamePair pair1 = new IdNamePair(1, "test1");
        IdNamePair pair2 = new IdNamePair(1, "test2");
        
        assertNotEquals(pair1, pair2);
    }

    @Test
    public void hashCode_withSameValues_returnsSameHashCode() {
        IdNamePair pair1 = new IdNamePair(1, "test");
        IdNamePair pair2 = new IdNamePair(1, "test");
        
        assertEquals(pair1.hashCode(), pair2.hashCode());
    }

    @Test
    public void toString_returnsRecordString() {
        IdNamePair pair = new IdNamePair(123, "testName");
        
        String result = pair.toString();
        
        assertTrue(result.contains("123"));
        assertTrue(result.contains("testName"));
    }

    @Test
    public void record_isImmutable() {
        IdNamePair pair = new IdNamePair(1, "original");
        
        // Cannot modify - just verify the values remain unchanged
        assertEquals(Integer.valueOf(1), pair.id());
        assertEquals("original", pair.name());
    }

    @Test
    public void constructor_withWhitespaceName_createsInstance() {
        IdNamePair pair = new IdNamePair(1, "   ");
        
        assertEquals("   ", pair.name());
    }

    @Test
    public void constructor_withNewlineInName_createsInstance() {
        IdNamePair pair = new IdNamePair(1, "line1\nline2");
        
        assertEquals("line1\nline2", pair.name());
    }
}

