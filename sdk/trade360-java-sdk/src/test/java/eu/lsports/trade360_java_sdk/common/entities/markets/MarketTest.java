package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    @Test
    void testFieldAssignment() {
        Market market = new Market();
        market.id = 10;
        market.name = "Winner";
        Bet bet = new Bet();
        bet.providerBetId = "bet1";
        market.bets = List.of(bet);
        market.mainLine = "main";
        assertEquals(10, market.id);
        assertEquals("Winner", market.name);
        assertNotNull(market.bets);
        assertEquals("main", market.mainLine);
    }
} 