package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.livescore.LivescoreEvent;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LivescoreUpdateComprehensiveTest {

    @Test
    void testLivescoreUpdateDefaultConstructor() {
        LivescoreUpdate livescoreUpdate = new LivescoreUpdate();
        
        assertNotNull(livescoreUpdate);
        assertNull(livescoreUpdate.events);
        assertEquals(2, LivescoreUpdate.entityKey);
    }

    @Test
    void testLivescoreUpdateEventsAssignment() {
        LivescoreUpdate livescoreUpdate = new LivescoreUpdate();
        LivescoreEvent event1 = new LivescoreEvent();
        LivescoreEvent event2 = new LivescoreEvent();
        Iterable<LivescoreEvent> testEvents = Arrays.asList(event1, event2);
        
        livescoreUpdate.events = testEvents;
        
        assertEquals(testEvents, livescoreUpdate.events);
    }

    @Test
    void testLivescoreUpdateNullAssignments() {
        LivescoreUpdate livescoreUpdate = new LivescoreUpdate();
        
        livescoreUpdate.events = null;
        
        assertNull(livescoreUpdate.events);
    }

    @Test
    void testLivescoreUpdateReassignment() {
        LivescoreUpdate livescoreUpdate = new LivescoreUpdate();
        
        livescoreUpdate.events = Collections.singletonList(new LivescoreEvent());
        assertNotNull(livescoreUpdate.events);
        
        livescoreUpdate.events = Arrays.asList(new LivescoreEvent(), new LivescoreEvent());
        assertNotNull(livescoreUpdate.events);
    }

    @Test
    void testMultipleLivescoreUpdateInstances() {
        LivescoreUpdate livescoreUpdate1 = new LivescoreUpdate();
        LivescoreUpdate livescoreUpdate2 = new LivescoreUpdate();
        
        livescoreUpdate1.events = Collections.singletonList(new LivescoreEvent());
        livescoreUpdate2.events = Collections.singletonList(new LivescoreEvent());
        
        assertNotSame(livescoreUpdate1.events, livescoreUpdate2.events);
    }

    @Test
    void testLivescoreUpdateConsistency() {
        LivescoreUpdate livescoreUpdate1 = new LivescoreUpdate();
        LivescoreUpdate livescoreUpdate2 = new LivescoreUpdate();
        
        Iterable<LivescoreEvent> testEvents = Collections.singletonList(new LivescoreEvent());
        
        livescoreUpdate1.events = testEvents;
        livescoreUpdate2.events = testEvents;
        
        assertSame(livescoreUpdate1.events, livescoreUpdate2.events);
    }

    @Test
    void testLivescoreUpdateEmptyEvents() {
        LivescoreUpdate livescoreUpdate = new LivescoreUpdate();
        
        livescoreUpdate.events = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), livescoreUpdate.events);
    }

    @Test
    void testLivescoreUpdateEntityKey() {
        assertEquals(2, LivescoreUpdate.entityKey);
    }
}
