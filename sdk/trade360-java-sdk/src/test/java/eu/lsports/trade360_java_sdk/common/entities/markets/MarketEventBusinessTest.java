package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MarketEventBusinessTest {
    @Test
    void testFullFieldAssignmentAndContract() {
        MarketEvent event = new MarketEvent();
        event.fixtureId = 1234;
        List<Market> markets = new ArrayList<>();
        Market m1 = new Market();
        m1.id = 1;
        m1.name = "Match Winner";
        markets.add(m1);
        event.markets = markets;

        assertEquals(1234, event.fixtureId);
        assertNotNull(event.markets);
        assertEquals(1, ((List<Market>) event.markets).size());
        assertEquals("Match Winner", ((List<Market>) event.markets).get(0).name);
    }

    @Test
    void testEdgeCasesAndNullMarkets() {
        MarketEvent event = new MarketEvent();
        event.fixtureId = 0;
        event.markets = null;
        assertEquals(0, event.fixtureId);
        assertNull(event.markets);
    }

    @Test
    void testEmptyMarketsList() {
        MarketEvent event = new MarketEvent();
        event.fixtureId = 555;
        event.markets = new ArrayList<>();
        assertNotNull(event.markets);
        assertEquals(0, ((List<Market>) event.markets).size());
    }
} 