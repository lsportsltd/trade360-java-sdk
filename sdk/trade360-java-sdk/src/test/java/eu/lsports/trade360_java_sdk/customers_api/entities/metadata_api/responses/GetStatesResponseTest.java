package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

class GetStatesResponseTest {

    @Test
    void testConstructorWithStates() {
        StateMetadata state1 = new StateMetadata(1, "California", null);
        StateMetadata state2 = new StateMetadata(2, "Texas", null);
        Iterable<StateMetadata> states = Arrays.asList(state1, state2);
        
        GetStatesResponse response = new GetStatesResponse();
        response.data = states;
        
        assertNotNull(response);
        assertEquals(states, response.data);
    }

    @Test
    void testConstructorWithNullStates() {
        GetStatesResponse response = new GetStatesResponse();
        response.data = null;
        
        assertNotNull(response);
        assertNull(response.data);
    }

    @Test
    void testConstructorWithEmptyStates() {
        Iterable<StateMetadata> emptyStates = Collections.emptyList();
        
        GetStatesResponse response = new GetStatesResponse();
        response.data = emptyStates;
        
        assertNotNull(response);
        assertEquals(emptyStates, response.data);
    }

    @Test
    void testConstructorWithSingleState() {
        StateMetadata state = new StateMetadata(100, "Single State", null);
        Iterable<StateMetadata> states = Arrays.asList(state);
        
        GetStatesResponse response = new GetStatesResponse();
        response.data = states;
        
        assertNotNull(response);
        assertEquals(states, response.data);
        assertEquals(1, ((java.util.List<StateMetadata>) response.data).size());
    }

    @Test
    void testDataFieldAssignment() {
        StateMetadata state1 = new StateMetadata(1, "Florida", null);
        StateMetadata state2 = new StateMetadata(1, "Florida", null);
        
        GetStatesResponse response1 = new GetStatesResponse();
        response1.data = Arrays.asList(state1);
        
        GetStatesResponse response2 = new GetStatesResponse();
        response2.data = Arrays.asList(state2);
        
        assertNotNull(response1.data);
        assertNotNull(response2.data);
    }

    @Test
    void testDataFieldInequality() {
        StateMetadata state1 = new StateMetadata(1, "Florida", null);
        StateMetadata state2 = new StateMetadata(2, "Georgia", null);
        
        GetStatesResponse response1 = new GetStatesResponse();
        response1.data = Arrays.asList(state1);
        
        GetStatesResponse response2 = new GetStatesResponse();
        response2.data = Arrays.asList(state2);
        
        assertNotEquals(response1.data, response2.data);
    }

    @Test
    void testToString() {
        StateMetadata state = new StateMetadata(1, "Test State", null);
        GetStatesResponse response = new GetStatesResponse();
        response.data = Arrays.asList(state);
        
        String toString = response.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetStatesResponse"));
    }

    @Test
    void testNullDataEquality() {
        GetStatesResponse response1 = new GetStatesResponse();
        response1.data = null;
        
        GetStatesResponse response2 = new GetStatesResponse();
        response2.data = null;
        
        assertEquals(response1.data, response2.data);
    }

    @Test
    void testMixedNullDataInequality() {
        StateMetadata state = new StateMetadata(1, "State", null);
        
        GetStatesResponse response1 = new GetStatesResponse();
        response1.data = Arrays.asList(state);
        
        GetStatesResponse response2 = new GetStatesResponse();
        response2.data = null;
        
        assertNotEquals(response1.data, response2.data);
    }

    @Test
    void testMultipleStates() {
        StateMetadata state1 = new StateMetadata(1, "New York", null);
        StateMetadata state2 = new StateMetadata(2, "Illinois", null);
        StateMetadata state3 = new StateMetadata(3, "Nevada", null);
        StateMetadata state4 = new StateMetadata(4, "Oregon", null);
        Iterable<StateMetadata> states = Arrays.asList(state1, state2, state3, state4);
        
        GetStatesResponse response = new GetStatesResponse();
        response.data = states;
        
        assertNotNull(response);
        assertEquals(states, response.data);
        assertEquals(4, ((java.util.List<StateMetadata>) response.data).size());
    }

    @Test
    void testStatesAccessibility() {
        StateMetadata state1 = new StateMetadata(10, "Washington", null);
        StateMetadata state2 = new StateMetadata(20, "Colorado", null);
        Iterable<StateMetadata> states = Arrays.asList(state1, state2);
        
        GetStatesResponse response = new GetStatesResponse();
        response.data = states;
        
        assertNotNull(response.data);
        java.util.List<StateMetadata> statesList = (java.util.List<StateMetadata>) response.data;
        assertEquals(10, statesList.get(0).stateId());
        assertEquals("Washington", statesList.get(0).name());
        assertEquals(20, statesList.get(1).stateId());
        assertEquals("Colorado", statesList.get(1).name());
    }
}