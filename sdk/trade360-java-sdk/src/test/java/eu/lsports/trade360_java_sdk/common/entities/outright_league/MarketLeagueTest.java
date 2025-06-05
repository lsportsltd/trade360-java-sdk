package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MarketLeagueTest {
    @Test
    void testFieldAssignment() {
        MarketLeague league = new MarketLeague();
        league.id = 7;
        league.name = "Premier League";
        Bet bet = new Bet();
        bet.providerBetId = "betX";
        league.bets = List.of(bet);
        league.mainLine = "main";
        assertEquals(7, league.id);
        assertEquals("Premier League", league.name);
        assertNotNull(league.bets);
        assertEquals("main", league.mainLine);
    }

    @Test
    void testInstantiation() {
        MarketLeague league = new MarketLeague();
        assertNotNull(league);
    }
} 