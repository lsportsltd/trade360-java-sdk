package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueTest {

    @Test
    void testFieldAssignments() {
        OutrightLeague outrightLeague = new OutrightLeague();
        
        outrightLeague.id = 12345;
        assertEquals(12345, outrightLeague.id);
        
        outrightLeague.name = "Premier League";
        assertEquals("Premier League", outrightLeague.name);
        
        outrightLeague.sportId = 6;
        assertEquals(6, outrightLeague.sportId);
        
        outrightLeague.locationId = 456;
        assertEquals(456, outrightLeague.locationId);
        
        outrightLeague.isActive = true;
        assertTrue(outrightLeague.isActive);
    }

    @Test
    void testNullValues() {
        OutrightLeague outrightLeague = new OutrightLeague();
        
        outrightLeague.id = null;
        assertNull(outrightLeague.id);
        
        outrightLeague.name = null;
        assertNull(outrightLeague.name);
        
        outrightLeague.sportId = null;
        assertNull(outrightLeague.sportId);
        
        outrightLeague.locationId = null;
        assertNull(outrightLeague.locationId);
        
        outrightLeague.isActive = null;
        assertNull(outrightLeague.isActive);
    }

    @Test
    void testInstantiation() {
        OutrightLeague outrightLeague = new OutrightLeague();
        assertNotNull(outrightLeague);
    }

    @Test
    void testBooleanValues() {
        OutrightLeague outrightLeague = new OutrightLeague();
        
        outrightLeague.isActive = false;
        assertFalse(outrightLeague.isActive);
        
        outrightLeague.isActive = true;
        assertTrue(outrightLeague.isActive);
    }

    @Test
    void testCompleteOutrightLeague() {
        OutrightLeague outrightLeague = new OutrightLeague();
        
        outrightLeague.id = 999;
        outrightLeague.name = "Champions League";
        outrightLeague.sportId = 6;
        outrightLeague.locationId = 789;
        outrightLeague.isActive = true;
        
        assertEquals(999, outrightLeague.id);
        assertEquals("Champions League", outrightLeague.name);
        assertEquals(6, outrightLeague.sportId);
        assertEquals(789, outrightLeague.locationId);
        assertTrue(outrightLeague.isActive);
    }
}
