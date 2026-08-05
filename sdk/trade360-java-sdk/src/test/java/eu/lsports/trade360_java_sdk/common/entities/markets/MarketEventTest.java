package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketEventTest {
    @Test
    void testFieldAssignmentAndNullability() {
        MarketEvent event = new MarketEvent();
        assertEquals(0, event.fixtureId);
        assertNull(event.fixtureName);
        assertNull(event.markets);

        event.fixtureId = 42;
        event.fixtureName = "Premier League 2023/2024 Outright Winner";
        event.markets = null;
        assertEquals(42, event.fixtureId);
        assertEquals("Premier League 2023/2024 Outright Winner", event.fixtureName);
        assertNull(event.markets);
    }
} 