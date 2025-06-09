package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureEventComprehensiveTest {

    @Test
    void testOutrightFixtureEventDefaultConstructor() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        assertNotNull(outrightFixtureEvent);
        assertEquals(0, outrightFixtureEvent.fixtureId);
        assertNull(outrightFixtureEvent.outrightFixture);
    }

    @Test
    void testOutrightFixtureEventFixtureIdAssignment() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        outrightFixtureEvent.fixtureId = 12345;
        
        assertEquals(12345, outrightFixtureEvent.fixtureId);
        assertNull(outrightFixtureEvent.outrightFixture);
    }

    @Test
    void testOutrightFixtureEventOutrightFixtureAssignment() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        OutrightFixture testOutrightFixture = new OutrightFixture();
        
        outrightFixtureEvent.outrightFixture = testOutrightFixture;
        
        assertEquals(testOutrightFixture, outrightFixtureEvent.outrightFixture);
        assertEquals(0, outrightFixtureEvent.fixtureId);
    }

    @Test
    void testOutrightFixtureEventAllFieldsAssignment() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        int testFixtureId = 67890;
        OutrightFixture testOutrightFixture = new OutrightFixture();
        
        outrightFixtureEvent.fixtureId = testFixtureId;
        outrightFixtureEvent.outrightFixture = testOutrightFixture;
        
        assertEquals(testFixtureId, outrightFixtureEvent.fixtureId);
        assertEquals(testOutrightFixture, outrightFixtureEvent.outrightFixture);
    }

    @Test
    void testOutrightFixtureEventNullAssignments() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        outrightFixtureEvent.outrightFixture = null;
        
        assertNull(outrightFixtureEvent.outrightFixture);
        assertEquals(0, outrightFixtureEvent.fixtureId);
    }

    @Test
    void testOutrightFixtureEventReassignment() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        outrightFixtureEvent.fixtureId = 111;
        outrightFixtureEvent.outrightFixture = new OutrightFixture();
        
        assertEquals(111, outrightFixtureEvent.fixtureId);
        assertNotNull(outrightFixtureEvent.outrightFixture);
        
        outrightFixtureEvent.fixtureId = 222;
        outrightFixtureEvent.outrightFixture = new OutrightFixture();
        
        assertEquals(222, outrightFixtureEvent.fixtureId);
        assertNotNull(outrightFixtureEvent.outrightFixture);
    }

    @Test
    void testMultipleOutrightFixtureEventInstances() {
        OutrightFixtureEvent outrightFixtureEvent1 = new OutrightFixtureEvent();
        OutrightFixtureEvent outrightFixtureEvent2 = new OutrightFixtureEvent();
        
        outrightFixtureEvent1.fixtureId = 100;
        outrightFixtureEvent1.outrightFixture = new OutrightFixture();
        
        outrightFixtureEvent2.fixtureId = 200;
        outrightFixtureEvent2.outrightFixture = new OutrightFixture();
        
        assertEquals(100, outrightFixtureEvent1.fixtureId);
        assertEquals(200, outrightFixtureEvent2.fixtureId);
        assertNotEquals(outrightFixtureEvent1.fixtureId, outrightFixtureEvent2.fixtureId);
        assertNotSame(outrightFixtureEvent1.outrightFixture, outrightFixtureEvent2.outrightFixture);
    }

    @Test
    void testOutrightFixtureEventFieldIndependence() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        outrightFixtureEvent.fixtureId = 123;
        assertNull(outrightFixtureEvent.outrightFixture);
        
        outrightFixtureEvent.outrightFixture = new OutrightFixture();
        assertEquals(123, outrightFixtureEvent.fixtureId);
    }

    @Test
    void testOutrightFixtureEventConsistency() {
        OutrightFixtureEvent outrightFixtureEvent1 = new OutrightFixtureEvent();
        OutrightFixtureEvent outrightFixtureEvent2 = new OutrightFixtureEvent();
        
        int testFixtureId = 999;
        OutrightFixture testOutrightFixture = new OutrightFixture();
        
        outrightFixtureEvent1.fixtureId = testFixtureId;
        outrightFixtureEvent1.outrightFixture = testOutrightFixture;
        
        outrightFixtureEvent2.fixtureId = testFixtureId;
        outrightFixtureEvent2.outrightFixture = testOutrightFixture;
        
        assertEquals(outrightFixtureEvent1.fixtureId, outrightFixtureEvent2.fixtureId);
        assertSame(outrightFixtureEvent1.outrightFixture, outrightFixtureEvent2.outrightFixture);
    }

    @Test
    void testOutrightFixtureEventWithDifferentFixtureIds() {
        OutrightFixtureEvent outrightFixtureEvent = new OutrightFixtureEvent();
        
        outrightFixtureEvent.fixtureId = 0;
        assertEquals(0, outrightFixtureEvent.fixtureId);
        
        outrightFixtureEvent.fixtureId = -1;
        assertEquals(-1, outrightFixtureEvent.fixtureId);
        
        outrightFixtureEvent.fixtureId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, outrightFixtureEvent.fixtureId);
        
        outrightFixtureEvent.fixtureId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, outrightFixtureEvent.fixtureId);
    }
}
