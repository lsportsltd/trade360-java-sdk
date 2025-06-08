package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    @Test
    void testConstructorAndAccessors() {
        Market market = new Market(42, "mainLine");
        assertEquals(42, market.marketId());
        assertEquals("mainLine", market.line());
    }

    @Test
    void testNullLine() {
        Market market = new Market(7, null);
        assertEquals(7, market.marketId());
        assertNull(market.line());
    }

    @Test
    void testEqualsAndHashCode() {
        Market m1 = new Market(1, "A");
        Market m2 = new Market(1, "A");
        Market m3 = new Market(2, "B");
        assertEquals(m1, m2);
        assertNotEquals(m1, m3);
        assertEquals(m1.hashCode(), m2.hashCode());
        assertNotEquals(m1.hashCode(), m3.hashCode());
    }

    @Test
    void testToString() {
        Market market = new Market(5, "L");
        String str = market.toString();
        assertTrue(str.contains("5"));
        assertTrue(str.contains("L"));
    }
} 