package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixtureEventComprehensiveTest {

    @Test
    void testFixtureEventDefaultConstructor() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        assertNotNull(fixtureEvent);
        assertEquals(0, fixtureEvent.fixtureId);
        assertNull(fixtureEvent.fixture);
    }

    @Test
    void testFixtureEventFixtureIdAssignment() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        fixtureEvent.fixtureId = 12345;
        
        assertEquals(12345, fixtureEvent.fixtureId);
        assertNull(fixtureEvent.fixture);
    }

    @Test
    void testFixtureEventFixtureAssignment() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        Fixture testFixture = new Fixture();
        
        fixtureEvent.fixture = testFixture;
        
        assertEquals(testFixture, fixtureEvent.fixture);
        assertEquals(0, fixtureEvent.fixtureId);
    }

    @Test
    void testFixtureEventAllFieldsAssignment() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        int testFixtureId = 67890;
        Fixture testFixture = new Fixture();
        
        fixtureEvent.fixtureId = testFixtureId;
        fixtureEvent.fixture = testFixture;
        
        assertEquals(testFixtureId, fixtureEvent.fixtureId);
        assertEquals(testFixture, fixtureEvent.fixture);
    }

    @Test
    void testFixtureEventNullAssignments() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        fixtureEvent.fixture = null;
        
        assertNull(fixtureEvent.fixture);
        assertEquals(0, fixtureEvent.fixtureId);
    }

    @Test
    void testFixtureEventReassignment() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        fixtureEvent.fixtureId = 111;
        fixtureEvent.fixture = new Fixture();
        
        assertEquals(111, fixtureEvent.fixtureId);
        assertNotNull(fixtureEvent.fixture);
        
        fixtureEvent.fixtureId = 222;
        fixtureEvent.fixture = new Fixture();
        
        assertEquals(222, fixtureEvent.fixtureId);
        assertNotNull(fixtureEvent.fixture);
    }

    @Test
    void testMultipleFixtureEventInstances() {
        FixtureEvent fixtureEvent1 = new FixtureEvent();
        FixtureEvent fixtureEvent2 = new FixtureEvent();
        
        fixtureEvent1.fixtureId = 100;
        fixtureEvent1.fixture = new Fixture();
        
        fixtureEvent2.fixtureId = 200;
        fixtureEvent2.fixture = new Fixture();
        
        assertEquals(100, fixtureEvent1.fixtureId);
        assertEquals(200, fixtureEvent2.fixtureId);
        assertNotEquals(fixtureEvent1.fixtureId, fixtureEvent2.fixtureId);
        assertNotSame(fixtureEvent1.fixture, fixtureEvent2.fixture);
    }

    @Test
    void testFixtureEventFieldIndependence() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        fixtureEvent.fixtureId = 123;
        assertNull(fixtureEvent.fixture);
        
        fixtureEvent.fixture = new Fixture();
        assertEquals(123, fixtureEvent.fixtureId);
    }

    @Test
    void testFixtureEventConsistency() {
        FixtureEvent fixtureEvent1 = new FixtureEvent();
        FixtureEvent fixtureEvent2 = new FixtureEvent();
        
        int testFixtureId = 999;
        Fixture testFixture = new Fixture();
        
        fixtureEvent1.fixtureId = testFixtureId;
        fixtureEvent1.fixture = testFixture;
        
        fixtureEvent2.fixtureId = testFixtureId;
        fixtureEvent2.fixture = testFixture;
        
        assertEquals(fixtureEvent1.fixtureId, fixtureEvent2.fixtureId);
        assertSame(fixtureEvent1.fixture, fixtureEvent2.fixture);
    }

    @Test
    void testFixtureEventWithDifferentFixtureIds() {
        FixtureEvent fixtureEvent = new FixtureEvent();
        
        fixtureEvent.fixtureId = 0;
        assertEquals(0, fixtureEvent.fixtureId);
        
        fixtureEvent.fixtureId = -1;
        assertEquals(-1, fixtureEvent.fixtureId);
        
        fixtureEvent.fixtureId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, fixtureEvent.fixtureId);
        
        fixtureEvent.fixtureId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, fixtureEvent.fixtureId);
    }
}
