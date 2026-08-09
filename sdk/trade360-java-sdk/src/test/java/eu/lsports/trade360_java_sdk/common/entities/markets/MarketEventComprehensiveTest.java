package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MarketEventComprehensiveTest {

    @Test
    void testMarketEventDefaultConstructor() {
        MarketEvent marketEvent = new MarketEvent();
        
        assertNotNull(marketEvent);
        assertEquals(0, marketEvent.fixtureId);
        assertNull(marketEvent.markets);
    }

    @Test
    void testMarketEventFixtureIdAssignment() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.fixtureId = 12345;
        
        assertEquals(12345, marketEvent.fixtureId);
        assertNull(marketEvent.markets);
    }

    @Test
    void testMarketEventMarketsAssignment() {
        MarketEvent marketEvent = new MarketEvent();
        Market market1 = new Market();
        Market market2 = new Market();
        Iterable<Market> testMarkets = Arrays.asList(market1, market2);
        
        marketEvent.markets = testMarkets;
        
        assertEquals(testMarkets, marketEvent.markets);
        assertEquals(0, marketEvent.fixtureId);
    }

    @Test
    void testMarketEventAllFieldsAssignment() {
        MarketEvent marketEvent = new MarketEvent();
        int testFixtureId = 67890;
        Market market = new Market();
        Iterable<Market> testMarkets = Collections.singletonList(market);
        
        marketEvent.fixtureId = testFixtureId;
        marketEvent.markets = testMarkets;
        
        assertEquals(testFixtureId, marketEvent.fixtureId);
        assertEquals(testMarkets, marketEvent.markets);
    }

    @Test
    void testMarketEventNullAssignments() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.markets = null;
        
        assertNull(marketEvent.markets);
        assertEquals(0, marketEvent.fixtureId);
    }

    @Test
    void testMarketEventReassignment() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.fixtureId = 111;
        marketEvent.markets = Collections.singletonList(new Market());
        
        assertEquals(111, marketEvent.fixtureId);
        assertNotNull(marketEvent.markets);
        
        marketEvent.fixtureId = 222;
        marketEvent.markets = Collections.singletonList(new Market());
        
        assertEquals(222, marketEvent.fixtureId);
        assertNotNull(marketEvent.markets);
    }

    @Test
    void testMultipleMarketEventInstances() {
        MarketEvent marketEvent1 = new MarketEvent();
        MarketEvent marketEvent2 = new MarketEvent();
        
        marketEvent1.fixtureId = 100;
        marketEvent1.markets = Collections.singletonList(new Market());
        
        marketEvent2.fixtureId = 200;
        marketEvent2.markets = Collections.singletonList(new Market());
        
        assertEquals(100, marketEvent1.fixtureId);
        assertEquals(200, marketEvent2.fixtureId);
        assertNotEquals(marketEvent1.fixtureId, marketEvent2.fixtureId);
        assertNotSame(marketEvent1.markets, marketEvent2.markets);
    }

    @Test
    void testMarketEventFieldIndependence() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.fixtureId = 123;
        assertNull(marketEvent.markets);
        
        marketEvent.markets = Collections.singletonList(new Market());
        assertEquals(123, marketEvent.fixtureId);
    }

    @Test
    void testMarketEventConsistency() {
        MarketEvent marketEvent1 = new MarketEvent();
        MarketEvent marketEvent2 = new MarketEvent();
        
        int testFixtureId = 999;
        Iterable<Market> testMarkets = Collections.singletonList(new Market());
        
        marketEvent1.fixtureId = testFixtureId;
        marketEvent1.markets = testMarkets;
        
        marketEvent2.fixtureId = testFixtureId;
        marketEvent2.markets = testMarkets;
        
        assertEquals(marketEvent1.fixtureId, marketEvent2.fixtureId);
        assertSame(marketEvent1.markets, marketEvent2.markets);
    }

    @Test
    void testMarketEventWithDifferentFixtureIds() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.fixtureId = 0;
        assertEquals(0, marketEvent.fixtureId);
        
        marketEvent.fixtureId = -1;
        assertEquals(-1, marketEvent.fixtureId);
        
        marketEvent.fixtureId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, marketEvent.fixtureId);
        
        marketEvent.fixtureId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, marketEvent.fixtureId);
    }

    @Test
    void testMarketEventEmptyMarkets() {
        MarketEvent marketEvent = new MarketEvent();
        
        marketEvent.markets = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), marketEvent.markets);
        assertEquals(0, marketEvent.fixtureId);
    }
}
