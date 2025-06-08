package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        MarketEvent event = new MarketEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.markets);

        event.fixtureId = 42;
        event.markets = null;
        assertEquals(42, event.fixtureId);
        assertNull(event.markets);
    }
} 