package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MarketUpdateComprehensiveTest {

    @Test
    void testMarketUpdateDefaultConstructor() {
        MarketUpdate marketUpdate = new MarketUpdate();
        
        assertNotNull(marketUpdate);
        assertEquals(3, MarketUpdate.entityKey);
        assertNull(marketUpdate.events);
    }

    @Test
    void testMarketUpdateEntityKeyValue() {
        assertEquals(3, MarketUpdate.entityKey);
    }

    @Test
    void testMarketUpdateEventsAssignment() {
        MarketUpdate marketUpdate = new MarketUpdate();
        MarketEvent testEvent = new MarketEvent();
        Iterable<MarketEvent> testEvents = Collections.singletonList(testEvent);
        
        marketUpdate.events = testEvents;
        
        assertEquals(testEvents, marketUpdate.events);
    }

    @Test
    void testMarketUpdateNullEventsAssignment() {
        MarketUpdate marketUpdate = new MarketUpdate();
        
        marketUpdate.events = null;
        
        assertNull(marketUpdate.events);
    }

    @Test
    void testMarketUpdateEmptyEventsAssignment() {
        MarketUpdate marketUpdate = new MarketUpdate();
        Iterable<MarketEvent> emptyEvents = Collections.emptyList();
        
        marketUpdate.events = emptyEvents;
        
        assertEquals(emptyEvents, marketUpdate.events);
    }

    @Test
    void testMarketUpdateMultipleEventsAssignment() {
        MarketUpdate marketUpdate = new MarketUpdate();
        MarketEvent event1 = new MarketEvent();
        MarketEvent event2 = new MarketEvent();
        Iterable<MarketEvent> multipleEvents = Arrays.asList(event1, event2);
        
        marketUpdate.events = multipleEvents;
        
        assertEquals(multipleEvents, marketUpdate.events);
    }

    @Test
    void testMarketUpdateEventsReassignment() {
        MarketUpdate marketUpdate = new MarketUpdate();
        
        Iterable<MarketEvent> firstEvents = Collections.singletonList(new MarketEvent());
        marketUpdate.events = firstEvents;
        assertEquals(firstEvents, marketUpdate.events);
        
        Iterable<MarketEvent> secondEvents = Collections.singletonList(new MarketEvent());
        marketUpdate.events = secondEvents;
        assertEquals(secondEvents, marketUpdate.events);
    }

    @Test
    void testMultipleMarketUpdateInstances() {
        MarketUpdate update1 = new MarketUpdate();
        MarketUpdate update2 = new MarketUpdate();
        
        Iterable<MarketEvent> events1 = Collections.singletonList(new MarketEvent());
        Iterable<MarketEvent> events2 = Collections.singletonList(new MarketEvent());
        
        update1.events = events1;
        update2.events = events2;
        
        assertEquals(events1, update1.events);
        assertEquals(events2, update2.events);
        assertNotSame(update1.events, update2.events);
    }

    @Test
    void testMarketUpdateConsistency() {
        MarketUpdate update1 = new MarketUpdate();
        MarketUpdate update2 = new MarketUpdate();
        
        Iterable<MarketEvent> testEvents = Collections.singletonList(new MarketEvent());
        
        update1.events = testEvents;
        update2.events = testEvents;
        
        assertSame(update1.events, update2.events);
        assertEquals(MarketUpdate.entityKey, MarketUpdate.entityKey);
    }

    @Test
    void testMarketUpdateEntityKeyImmutability() {
        int originalEntityKey = MarketUpdate.entityKey;
        assertEquals(3, originalEntityKey);
        assertEquals(3, MarketUpdate.entityKey);
    }
}
