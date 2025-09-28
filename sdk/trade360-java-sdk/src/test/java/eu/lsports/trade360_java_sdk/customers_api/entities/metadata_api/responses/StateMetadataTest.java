package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateMetadataTest {

    @Test
    void testConstructorWithValidData() {
        StateMetadata state = new StateMetadata(1, "California", null);
        
        assertEquals(1, state.stateId());
        assertEquals("California", state.name());
    }

    @Test
    void testConstructorWithNullName() {
        StateMetadata state = new StateMetadata(2, null, null);
        
        assertEquals(2, state.stateId());
        assertNull(state.name());
    }

    @Test
    void testConstructorWithEmptyName() {
        StateMetadata state = new StateMetadata(3, "", null);
        
        assertEquals(3, state.stateId());
        assertEquals("", state.name());
    }

    @Test
    void testRecordEquality() {
        StateMetadata state1 = new StateMetadata(1, "Texas", null);
        StateMetadata state2 = new StateMetadata(1, "Texas", null);
        
        assertEquals(state1, state2);
        assertEquals(state1.hashCode(), state2.hashCode());
    }

    @Test
    void testRecordInequalityById() {
        StateMetadata state1 = new StateMetadata(1, "Florida", null);
        StateMetadata state2 = new StateMetadata(2, "Florida", null);
        
        assertNotEquals(state1, state2);
    }

    @Test
    void testRecordInequalityByName() {
        StateMetadata state1 = new StateMetadata(1, "Nevada", null);
        StateMetadata state2 = new StateMetadata(1, "Arizona", null);
        
        assertNotEquals(state1, state2);
    }

    @Test
    void testToString() {
        StateMetadata state = new StateMetadata(100, "New York", null);
        
        String toString = state.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("StateMetadata"));
        assertTrue(toString.contains("New York"));
        assertTrue(toString.contains("100"));
    }

    @Test
    void testZeroStateId() {
        StateMetadata state = new StateMetadata(0, "Zero State", null);
        
        assertEquals(0, state.stateId());
        assertEquals("Zero State", state.name());
    }

    @Test
    void testNegativeStateId() {
        StateMetadata state = new StateMetadata(-1, "Negative State", null);
        
        assertEquals(-1, state.stateId());
        assertEquals("Negative State", state.name());
    }

    @Test
    void testLargeStateId() {
        StateMetadata state = new StateMetadata(Integer.MAX_VALUE, "Max State", null);
        
        assertEquals(Integer.MAX_VALUE, state.stateId());
        assertEquals("Max State", state.name());
    }

    @Test
    void testSpecialCharactersInName() {
        StateMetadata state = new StateMetadata(1, "Québec", null);
        
        assertEquals(1, state.stateId());
        assertEquals("Québec", state.name());
    }

    @Test
    void testLongStateName() {
        String longName = "Very Long State Name ".repeat(10);
        StateMetadata state = new StateMetadata(1, longName, null);
        
        assertEquals(1, state.stateId());
        assertEquals(longName, state.name());
    }

    @Test
    void testNullNameEquality() {
        StateMetadata state1 = new StateMetadata(1, null, null);
        StateMetadata state2 = new StateMetadata(1, null, null);
        
        assertEquals(state1, state2);
        assertEquals(state1.hashCode(), state2.hashCode());
    }

    @Test
    void testMixedNullNameInequality() {
        StateMetadata state1 = new StateMetadata(1, "Washington", null);
        StateMetadata state2 = new StateMetadata(1, null, null);
        
        assertNotEquals(state1, state2);
    }

    @Test
    void testWhitespaceInName() {
        StateMetadata state = new StateMetadata(1, "  State with spaces  ", null);
        
        assertEquals(1, state.stateId());
        assertEquals("  State with spaces  ", state.name());
    }

    @Test
    void testCommonStateNames() {
        StateMetadata state1 = new StateMetadata(1, "California", null);
        StateMetadata state2 = new StateMetadata(2, "New York", null);
        StateMetadata state3 = new StateMetadata(3, "Texas", null);
        StateMetadata state4 = new StateMetadata(4, "Florida", null);
        
        assertEquals("California", state1.name());
        assertEquals("New York", state2.name());
        assertEquals("Texas", state3.name());
        assertEquals("Florida", state4.name());
        
        // Verify all have different IDs
        assertNotEquals(state1.stateId(), state2.stateId());
        assertNotEquals(state2.stateId(), state3.stateId());
        assertNotEquals(state3.stateId(), state4.stateId());
    }

    @Test
    void testStateNameWithAbbreviation() {
        StateMetadata state = new StateMetadata(1, "CA", null);
        
        assertEquals(1, state.stateId());
        assertEquals("CA", state.name());
    }
}
