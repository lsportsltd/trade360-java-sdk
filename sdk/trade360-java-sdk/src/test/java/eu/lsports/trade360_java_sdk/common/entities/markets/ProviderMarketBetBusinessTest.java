package eu.lsports.trade360_java_sdk.common.entities.markets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProviderMarketBetBusinessTest {
    @Test
    void testInstantiationAndInheritance() {
        ProviderMarketBet bet = new ProviderMarketBet();
        assertNotNull(bet);
        assertTrue(bet instanceof BaseBet);
    }

    @Test
    void testFieldAssignmentAndContract() {
        ProviderMarketBet bet = new ProviderMarketBet();
        bet.id = 101;
        bet.name = "Provider Special";
        bet.line = "3.5";
        bet.isChanged = 0;
        bet.probability = 0.75;
        bet.participantId = 99;
        bet.playerName = "Provider Player";
        assertEquals(101, bet.id);
        assertEquals("Provider Special", bet.name);
        assertEquals("3.5", bet.line);
        assertEquals(0, bet.isChanged);
        assertEquals(0.75, bet.probability);
        assertEquals(99, bet.participantId);
        assertEquals("Provider Player", bet.playerName);
    }

    @Test
    void testEdgeCases() {
        ProviderMarketBet bet = new ProviderMarketBet();
        bet.line = null;
        bet.playerName = null;
        assertNull(bet.line);
        assertNull(bet.playerName);
    }
} 