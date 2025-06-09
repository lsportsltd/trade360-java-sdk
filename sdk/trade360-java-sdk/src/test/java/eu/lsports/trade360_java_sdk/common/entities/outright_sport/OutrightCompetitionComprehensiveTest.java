package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OutrightCompetitionComprehensiveTest {

    @Test
    void testOutrightCompetitionDefaultConstructor() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        assertNotNull(outrightCompetition);
        assertEquals(0, outrightCompetition.id);
        assertNull(outrightCompetition.name);
        assertNull(outrightCompetition.events);
    }

    @Test
    void testOutrightCompetitionIdAssignment() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.id = 12345;
        
        assertEquals(12345, outrightCompetition.id);
    }

    @Test
    void testOutrightCompetitionNameAssignment() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        String testName = "Test Competition";
        
        outrightCompetition.name = testName;
        
        assertEquals(testName, outrightCompetition.name);
    }

    @Test
    void testOutrightCompetitionEventsAssignment() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        OutrightFixtureEvent event1 = new OutrightFixtureEvent();
        OutrightFixtureEvent event2 = new OutrightFixtureEvent();
        Iterable<OutrightFixtureEvent> testEvents = Arrays.asList(event1, event2);
        
        outrightCompetition.events = testEvents;
        
        assertEquals(testEvents, outrightCompetition.events);
    }

    @Test
    void testOutrightCompetitionAllFieldsAssignment() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        int testId = 67890;
        String testName = "Complete Competition";
        Iterable<OutrightFixtureEvent> testEvents = Collections.singletonList(new OutrightFixtureEvent());
        
        outrightCompetition.id = testId;
        outrightCompetition.name = testName;
        outrightCompetition.events = testEvents;
        
        assertEquals(testId, outrightCompetition.id);
        assertEquals(testName, outrightCompetition.name);
        assertEquals(testEvents, outrightCompetition.events);
    }

    @Test
    void testOutrightCompetitionNullAssignments() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.name = null;
        outrightCompetition.events = null;
        
        assertNull(outrightCompetition.name);
        assertNull(outrightCompetition.events);
        assertEquals(0, outrightCompetition.id);
    }

    @Test
    void testOutrightCompetitionReassignment() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.id = 111;
        outrightCompetition.name = "First Name";
        outrightCompetition.events = Collections.singletonList(new OutrightFixtureEvent());
        
        assertEquals(111, outrightCompetition.id);
        assertEquals("First Name", outrightCompetition.name);
        assertNotNull(outrightCompetition.events);
        
        outrightCompetition.id = 222;
        outrightCompetition.name = "Second Name";
        outrightCompetition.events = Arrays.asList(new OutrightFixtureEvent(), new OutrightFixtureEvent());
        
        assertEquals(222, outrightCompetition.id);
        assertEquals("Second Name", outrightCompetition.name);
        assertNotNull(outrightCompetition.events);
    }

    @Test
    void testMultipleOutrightCompetitionInstances() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition1 = new OutrightCompetition<>();
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition2 = new OutrightCompetition<>();
        
        outrightCompetition1.id = 100;
        outrightCompetition1.name = "Competition One";
        outrightCompetition1.events = Collections.singletonList(new OutrightFixtureEvent());
        
        outrightCompetition2.id = 200;
        outrightCompetition2.name = "Competition Two";
        outrightCompetition2.events = Collections.singletonList(new OutrightFixtureEvent());
        
        assertEquals(100, outrightCompetition1.id);
        assertEquals("Competition One", outrightCompetition1.name);
        assertEquals(200, outrightCompetition2.id);
        assertEquals("Competition Two", outrightCompetition2.name);
        
        assertNotEquals(outrightCompetition1.id, outrightCompetition2.id);
        assertNotEquals(outrightCompetition1.name, outrightCompetition2.name);
        assertNotSame(outrightCompetition1.events, outrightCompetition2.events);
    }

    @Test
    void testOutrightCompetitionFieldIndependence() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.id = 123;
        assertNull(outrightCompetition.name);
        assertNull(outrightCompetition.events);
        
        outrightCompetition.name = "Test Name";
        assertEquals(123, outrightCompetition.id);
        assertNull(outrightCompetition.events);
        
        outrightCompetition.events = Collections.singletonList(new OutrightFixtureEvent());
        assertEquals(123, outrightCompetition.id);
        assertEquals("Test Name", outrightCompetition.name);
    }

    @Test
    void testOutrightCompetitionConsistency() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition1 = new OutrightCompetition<>();
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition2 = new OutrightCompetition<>();
        
        int testId = 999;
        String testName = "Consistent Competition";
        Iterable<OutrightFixtureEvent> testEvents = Collections.singletonList(new OutrightFixtureEvent());
        
        outrightCompetition1.id = testId;
        outrightCompetition1.name = testName;
        outrightCompetition1.events = testEvents;
        
        outrightCompetition2.id = testId;
        outrightCompetition2.name = testName;
        outrightCompetition2.events = testEvents;
        
        assertEquals(outrightCompetition1.id, outrightCompetition2.id);
        assertEquals(outrightCompetition1.name, outrightCompetition2.name);
        assertSame(outrightCompetition1.events, outrightCompetition2.events);
    }

    @Test
    void testOutrightCompetitionEmptyEvents() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.events = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), outrightCompetition.events);
        assertNotNull(outrightCompetition.events);
    }

    @Test
    void testOutrightCompetitionWithDifferentIds() {
        OutrightCompetition<OutrightFixtureEvent> outrightCompetition = new OutrightCompetition<>();
        
        outrightCompetition.id = 0;
        assertEquals(0, outrightCompetition.id);
        
        outrightCompetition.id = -1;
        assertEquals(-1, outrightCompetition.id);
        
        outrightCompetition.id = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, outrightCompetition.id);
        
        outrightCompetition.id = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, outrightCompetition.id);
    }
}
