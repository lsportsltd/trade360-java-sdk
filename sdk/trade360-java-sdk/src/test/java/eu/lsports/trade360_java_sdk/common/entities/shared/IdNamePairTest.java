package eu.lsports.trade360_java_sdk.common.entities.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IdNamePairTest {
    @Test
    void testInstantiation() {
        IdNamePair pair = new IdNamePair();
        assertNotNull(pair);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        IdNamePair pair = new IdNamePair();
        assertNull(pair.id);
        assertNull(pair.name);

        pair.id = 123;
        pair.name = "Test Name";
        assertEquals(123, pair.id);
        assertEquals("Test Name", pair.name);
    }

    @Test
    void testIdAssignment() {
        IdNamePair pair = new IdNamePair();
        Integer testId = 456;
        
        pair.id = testId;
        
        assertEquals(testId, pair.id);
        assertNull(pair.name);
    }

    @Test
    void testNameAssignment() {
        IdNamePair pair = new IdNamePair();
        String testName = "Test Name Value";
        
        pair.name = testName;
        
        assertEquals(testName, pair.name);
        assertNull(pair.id);
    }

    @Test
    void testBothFieldsAssignment() {
        IdNamePair pair = new IdNamePair();
        Integer testId = 789;
        String testName = "Both Fields Test";
        
        pair.id = testId;
        pair.name = testName;
        
        assertEquals(testId, pair.id);
        assertEquals(testName, pair.name);
    }

    @Test
    void testNullIdAssignment() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = null;
        pair.name = "Some Name";
        
        assertNull(pair.id);
        assertEquals("Some Name", pair.name);
    }

    @Test
    void testNullNameAssignment() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = 999;
        pair.name = null;
        
        assertEquals(999, pair.id);
        assertNull(pair.name);
    }

    @Test
    void testEmptyNameAssignment() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = 0;
        pair.name = "";
        
        assertEquals(0, pair.id);
        assertEquals("", pair.name);
    }

    @Test
    void testZeroIdAssignment() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = 0;
        pair.name = "Zero ID";
        
        assertEquals(0, pair.id);
        assertEquals("Zero ID", pair.name);
    }

    @Test
    void testNegativeIdAssignment() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = -1;
        pair.name = "Negative ID";
        
        assertEquals(-1, pair.id);
        assertEquals("Negative ID", pair.name);
    }

    @Test
    void testFieldModification() {
        IdNamePair pair = new IdNamePair();
        
        pair.id = 100;
        pair.name = "Initial Name";
        assertEquals(100, pair.id);
        assertEquals("Initial Name", pair.name);
        
        pair.id = 200;
        pair.name = "Updated Name";
        assertEquals(200, pair.id);
        assertEquals("Updated Name", pair.name);
        
        pair.id = null;
        pair.name = null;
        assertNull(pair.id);
        assertNull(pair.name);
    }
}


