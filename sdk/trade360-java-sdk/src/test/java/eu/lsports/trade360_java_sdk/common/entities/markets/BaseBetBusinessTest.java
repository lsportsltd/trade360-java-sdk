package eu.lsports.trade360_java_sdk.common.entities.markets;

import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.SettlementType;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class BaseBetBusinessTest {
    static class TestBaseBet extends BaseBet {}

    @Test
    void testFullFieldAssignmentAndContract() {
        TestBaseBet bet = new TestBaseBet();
        bet.id = 42L;
        bet.name = "Over 2.5";
        bet.line = "2.5";
        bet.baseLine = "2.0";
        bet.status = BetStatus.OPEN;
        bet.startPrice = "1.90";
        bet.price = "2.00";
        bet.priceVolume = "1000";
        bet.settlement = SettlementType.WINNER;
        bet.lastUpdate = LocalDateTime.now();
        bet.priceIN = "1.95";
        bet.priceUS = "+100";
        bet.priceUK = "1/1";
        bet.priceMA = "0.95";
        bet.priceHK = "1.00";
        bet.isChanged = 1;
        bet.probability = 0.55;
        bet.participantId = 7;
        bet.playerName = "Player X";

        assertEquals(42L, bet.id);
        assertEquals("Over 2.5", bet.name);
        assertEquals("2.5", bet.line);
        assertEquals(BetStatus.OPEN, bet.status);
        assertEquals(SettlementType.WINNER, bet.settlement);
        assertEquals(0.55, bet.probability);
        assertEquals(7, bet.participantId);
        assertEquals("Player X", bet.playerName);
    }

    @Test
    void testEdgeCasesAndDefaults() {
        TestBaseBet bet = new TestBaseBet();
        assertEquals(-1, bet.isChanged);
        assertNull(bet.line);
        assertNull(bet.baseLine);
        assertNull(bet.startPrice);
        assertNull(bet.price);
        assertNull(bet.priceVolume);
        assertNull(bet.priceIN);
        assertNull(bet.priceUS);
        assertNull(bet.priceUK);
        assertNull(bet.priceMA);
        assertNull(bet.priceHK);
        assertNull(bet.playerName);
    }

    @Test
    void testInvalidProbability() {
        TestBaseBet bet = new TestBaseBet();
        bet.probability = -1.0;
        assertTrue(bet.probability < 0);
        bet.probability = 2.0;
        assertTrue(bet.probability > 1);
    }
} 