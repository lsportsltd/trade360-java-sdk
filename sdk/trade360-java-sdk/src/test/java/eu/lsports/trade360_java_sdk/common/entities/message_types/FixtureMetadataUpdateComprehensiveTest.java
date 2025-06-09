package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FixtureMetadataUpdateComprehensiveTest {

    @Test
    void testFixtureMetadataUpdateDefaultConstructor() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        
        assertNotNull(fixtureMetadataUpdate);
        assertEquals(1, FixtureMetadataUpdate.entityKey);
        assertNull(fixtureMetadataUpdate.events);
    }

    @Test
    void testFixtureMetadataUpdateEntityKeyValue() {
        assertEquals(1, FixtureMetadataUpdate.entityKey);
    }

    @Test
    void testFixtureMetadataUpdateEventsAssignment() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        FixtureEvent testEvent = new FixtureEvent();
        Iterable<FixtureEvent> testEvents = Collections.singletonList(testEvent);
        
        fixtureMetadataUpdate.events = testEvents;
        
        assertEquals(testEvents, fixtureMetadataUpdate.events);
    }

    @Test
    void testFixtureMetadataUpdateNullEventsAssignment() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        
        fixtureMetadataUpdate.events = null;
        
        assertNull(fixtureMetadataUpdate.events);
    }

    @Test
    void testFixtureMetadataUpdateEmptyEventsAssignment() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        Iterable<FixtureEvent> emptyEvents = Collections.emptyList();
        
        fixtureMetadataUpdate.events = emptyEvents;
        
        assertEquals(emptyEvents, fixtureMetadataUpdate.events);
    }

    @Test
    void testFixtureMetadataUpdateMultipleEventsAssignment() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        FixtureEvent event1 = new FixtureEvent();
        FixtureEvent event2 = new FixtureEvent();
        Iterable<FixtureEvent> multipleEvents = Arrays.asList(event1, event2);
        
        fixtureMetadataUpdate.events = multipleEvents;
        
        assertEquals(multipleEvents, fixtureMetadataUpdate.events);
    }

    @Test
    void testFixtureMetadataUpdateEventsReassignment() {
        FixtureMetadataUpdate fixtureMetadataUpdate = new FixtureMetadataUpdate();
        
        Iterable<FixtureEvent> firstEvents = Collections.singletonList(new FixtureEvent());
        fixtureMetadataUpdate.events = firstEvents;
        assertEquals(firstEvents, fixtureMetadataUpdate.events);
        
        Iterable<FixtureEvent> secondEvents = Collections.singletonList(new FixtureEvent());
        fixtureMetadataUpdate.events = secondEvents;
        assertEquals(secondEvents, fixtureMetadataUpdate.events);
    }

    @Test
    void testMultipleFixtureMetadataUpdateInstances() {
        FixtureMetadataUpdate update1 = new FixtureMetadataUpdate();
        FixtureMetadataUpdate update2 = new FixtureMetadataUpdate();
        
        Iterable<FixtureEvent> events1 = Collections.singletonList(new FixtureEvent());
        Iterable<FixtureEvent> events2 = Collections.singletonList(new FixtureEvent());
        
        update1.events = events1;
        update2.events = events2;
        
        assertEquals(events1, update1.events);
        assertEquals(events2, update2.events);
        assertNotSame(update1.events, update2.events);
    }

    @Test
    void testFixtureMetadataUpdateConsistency() {
        FixtureMetadataUpdate update1 = new FixtureMetadataUpdate();
        FixtureMetadataUpdate update2 = new FixtureMetadataUpdate();
        
        Iterable<FixtureEvent> testEvents = Collections.singletonList(new FixtureEvent());
        
        update1.events = testEvents;
        update2.events = testEvents;
        
        assertSame(update1.events, update2.events);
        assertEquals(FixtureMetadataUpdate.entityKey, FixtureMetadataUpdate.entityKey);
    }

    @Test
    void testFixtureMetadataUpdateEntityKeyImmutability() {
        int originalEntityKey = FixtureMetadataUpdate.entityKey;
        assertEquals(1, originalEntityKey);
        assertEquals(1, FixtureMetadataUpdate.entityKey);
    }
}
