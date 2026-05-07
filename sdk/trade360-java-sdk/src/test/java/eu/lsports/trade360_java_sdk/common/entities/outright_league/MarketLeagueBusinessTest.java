package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MarketLeagueBusinessTest {
    @Test
    void testFullFieldAssignment() {
        MarketLeague league = new MarketLeague();
        league.id = 10;
        league.name = "Championship";
        Bet bet1 = new Bet();
        bet1.providerBetId = "bet1";
        bet1.calculatedMargin = 5.0f;
        Bet bet2 = new Bet();
        bet2.providerBetId = "bet2";
        bet2.calculatedMargin = 6.0f;
        league.bets = List.of(bet1, bet2);
        league.mainLine = "mainLineValue";
        assertEquals(10, league.id);
        assertEquals("Championship", league.name);
        assertNotNull(league.bets);
        assertEquals(2, ((List<Bet>) league.bets).size());
        assertEquals("mainLineValue", league.mainLine);
    }

    @Test
    void testNullFields() {
        MarketLeague league = new MarketLeague();
        league.name = null;
        league.bets = null;
        league.mainLine = null;
        assertNull(league.name);
        assertNull(league.bets);
        assertNull(league.mainLine);
    }

    @Test
    void testEmptyBetsList() {
        MarketLeague league = new MarketLeague();
        league.bets = List.of();
        assertNotNull(league.bets);
        assertEquals(0, ((List<Bet>) league.bets).size());
    }
} 