package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MarketLeagueTest {
    @Test
    void testFieldAssignmentAndNullability() {
        MarketLeague league = new MarketLeague();
        assertEquals(0, league.id);
        assertNull(league.name);
        assertNull(league.bets);
        assertNull(league.mainLine);

        league.id = 5;
        league.name = "LeagueName";
        league.bets = Arrays.asList(new Bet());
        league.mainLine = "MainLine";

        assertEquals(5, league.id);
        assertEquals("LeagueName", league.name);
        assertNotNull(league.bets);
        assertEquals("MainLine", league.mainLine);
    }

    @Test
    void testInstantiation() {
        MarketLeague league = new MarketLeague();
        assertNotNull(league);
    }
} 