package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    @Test
    void testInstantiation() {
        Market market = new Market();
        assertNotNull(market);
    }
} 