package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {
    @Test
    void testFieldAssignmentAndNullability() {
        League league = new League();
        assertEquals(0, league.id);
        assertNull(league.name);

        league.id = 7;
        league.name = "Premier League";

        assertEquals(7, league.id);
        assertEquals("Premier League", league.name);
    }
} 