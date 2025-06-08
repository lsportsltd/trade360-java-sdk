package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeagueBusinessTest {
    @Test
    void testFullFieldAssignment() {
        League league = new League();
        league.id = 42;
        league.name = "Premier League";
        assertEquals(42, league.id);
        assertEquals("Premier League", league.name);
    }

    @Test
    void testNullFields() {
        League league = new League();
        league.name = null;
        assertNull(league.name);
    }

    @Test
    void testDefaultId() {
        League league = new League();
        assertEquals(0, league.id);
    }
} 