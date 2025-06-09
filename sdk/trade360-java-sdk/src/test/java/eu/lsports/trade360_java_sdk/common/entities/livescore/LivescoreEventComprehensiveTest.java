package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivescoreEventComprehensiveTest {

    @Test
    void testLivescoreEventDefaultConstructor() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        
        assertNotNull(livescoreEvent);
        assertEquals(0, livescoreEvent.fixtureId);
        assertNull(livescoreEvent.livescore);
    }

    @Test
    void testLivescoreEventFixtureIdAssignment() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        int testFixtureId = 12345;
        
        livescoreEvent.fixtureId = testFixtureId;
        
        assertEquals(testFixtureId, livescoreEvent.fixtureId);
        assertNull(livescoreEvent.livescore);
    }

    @Test
    void testLivescoreEventLivescoreAssignment() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        Livescore testLivescore = new Livescore();
        
        livescoreEvent.livescore = testLivescore;
        
        assertEquals(testLivescore, livescoreEvent.livescore);
        assertEquals(0, livescoreEvent.fixtureId);
    }

    @Test
    void testLivescoreEventAllFieldsAssignment() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        int testFixtureId = 67890;
        Livescore testLivescore = new Livescore();
        
        livescoreEvent.fixtureId = testFixtureId;
        livescoreEvent.livescore = testLivescore;
        
        assertEquals(testFixtureId, livescoreEvent.fixtureId);
        assertEquals(testLivescore, livescoreEvent.livescore);
    }

    @Test
    void testLivescoreEventNullAssignments() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        
        livescoreEvent.livescore = null;
        
        assertNull(livescoreEvent.livescore);
    }

    @Test
    void testLivescoreEventReassignment() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        
        livescoreEvent.fixtureId = 111;
        livescoreEvent.livescore = new Livescore();
        
        assertEquals(111, livescoreEvent.fixtureId);
        assertNotNull(livescoreEvent.livescore);
        
        livescoreEvent.fixtureId = 222;
        livescoreEvent.livescore = new Livescore();
        
        assertEquals(222, livescoreEvent.fixtureId);
        assertNotNull(livescoreEvent.livescore);
    }

    @Test
    void testMultipleLivescoreEventInstances() {
        LivescoreEvent livescoreEvent1 = new LivescoreEvent();
        LivescoreEvent livescoreEvent2 = new LivescoreEvent();
        
        livescoreEvent1.fixtureId = 100;
        livescoreEvent1.livescore = new Livescore();
        
        livescoreEvent2.fixtureId = 200;
        livescoreEvent2.livescore = new Livescore();
        
        assertEquals(100, livescoreEvent1.fixtureId);
        assertEquals(200, livescoreEvent2.fixtureId);
        assertNotEquals(livescoreEvent1.fixtureId, livescoreEvent2.fixtureId);
        assertNotSame(livescoreEvent1.livescore, livescoreEvent2.livescore);
    }

    @Test
    void testLivescoreEventFieldIndependence() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        
        livescoreEvent.fixtureId = 123;
        assertNull(livescoreEvent.livescore);
        
        livescoreEvent.livescore = new Livescore();
        assertEquals(123, livescoreEvent.fixtureId);
    }

    @Test
    void testLivescoreEventConsistency() {
        LivescoreEvent livescoreEvent1 = new LivescoreEvent();
        LivescoreEvent livescoreEvent2 = new LivescoreEvent();
        
        int testFixtureId = 999;
        Livescore testLivescore = new Livescore();
        
        livescoreEvent1.fixtureId = testFixtureId;
        livescoreEvent1.livescore = testLivescore;
        
        livescoreEvent2.fixtureId = testFixtureId;
        livescoreEvent2.livescore = testLivescore;
        
        assertEquals(livescoreEvent1.fixtureId, livescoreEvent2.fixtureId);
        assertSame(livescoreEvent1.livescore, livescoreEvent2.livescore);
    }

    @Test
    void testLivescoreEventWithDifferentFixtureIds() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        
        livescoreEvent.fixtureId = 0;
        assertEquals(0, livescoreEvent.fixtureId);
        
        livescoreEvent.fixtureId = -1;
        assertEquals(-1, livescoreEvent.fixtureId);
        
        livescoreEvent.fixtureId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, livescoreEvent.fixtureId);
        
        livescoreEvent.fixtureId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, livescoreEvent.fixtureId);
    }

    @Test
    void testLivescoreEventWithComplexLivescore() {
        LivescoreEvent livescoreEvent = new LivescoreEvent();
        Livescore complexLivescore = new Livescore();
        complexLivescore.scoreboard = new Scoreboard();
        
        livescoreEvent.livescore = complexLivescore;
        
        assertEquals(complexLivescore, livescoreEvent.livescore);
        assertNotNull(livescoreEvent.livescore.scoreboard);
    }
}
