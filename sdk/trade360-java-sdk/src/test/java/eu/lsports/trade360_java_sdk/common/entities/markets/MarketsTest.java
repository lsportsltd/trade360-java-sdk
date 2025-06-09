package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketsTest {

    @Test
    void testFieldAssignments() {
        Markets markets = new Markets();
        
        markets.setId(123);
        assertEquals(123, markets.getId());
        
        markets.setName("Test Market");
        assertEquals("Test Market", markets.getName());
        
        markets.setType(1);
        assertEquals(1, markets.getType());
        
        markets.setActive(true);
        assertTrue(markets.getActive());
        
        markets.setFixtureId(456);
        assertEquals(456, markets.getFixtureId());
        
        markets.setLeagueId(789);
        assertEquals(789, markets.getLeagueId());
    }

    @Test
    void testNullValues() {
        Markets markets = new Markets();
        
        assertNull(markets.getName());
        assertNull(markets.getActive());
    }

    @Test
    void testDefaultValues() {
        Markets markets = new Markets();
        
        assertEquals(0, markets.getId());
        assertEquals(0, markets.getType());
        assertEquals(0, markets.getFixtureId());
        assertEquals(0, markets.getLeagueId());
    }

    @Test
    void testBooleanHandling() {
        Markets markets = new Markets();
        
        markets.setActive(false);
        assertFalse(markets.getActive());
        
        markets.setActive(true);
        assertTrue(markets.getActive());
        
        markets.setActive(null);
        assertNull(markets.getActive());
    }
}
