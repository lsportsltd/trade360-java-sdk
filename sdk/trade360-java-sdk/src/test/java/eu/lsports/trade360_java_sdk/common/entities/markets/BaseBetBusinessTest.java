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
        bet.probability = 0.55;
        bet.participantId = 7;
        bet.playerId = 12345;
        bet.playerName = "Player X";
        bet.order = 3;

        assertEquals(42L, bet.id);
        assertEquals("Over 2.5", bet.name);
        assertEquals("2.5", bet.line);
        assertEquals(BetStatus.OPEN, bet.status);
        assertEquals(SettlementType.WINNER, bet.settlement);
        assertEquals(0.55, bet.probability);
        assertEquals(7, bet.participantId);
        assertEquals(12345, bet.playerId);
        assertEquals("Player X", bet.playerName);
        assertEquals(3, bet.order);
    }

    @Test
    void testEdgeCasesAndDefaults() {
        TestBaseBet bet = new TestBaseBet();
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
    
    @Test
    void testPlayerSpecificBetScenario() {
        // Simulate a player-specific bet (e.g., "Player to score anytime")
        TestBaseBet bet = new TestBaseBet();
        bet.id = 100L;
        bet.name = "Player to Score Anytime";
        bet.playerId = 77777;
        bet.playerName = "Cristiano Ronaldo";
        bet.participantId = 100; // Team ID
        bet.order = 1; // First in display order
        bet.price = "2.50";
        bet.status = BetStatus.OPEN;
        
        assertEquals(77777, bet.playerId);
        assertEquals("Cristiano Ronaldo", bet.playerName);
        assertEquals(1, bet.order);
        assertEquals(100, bet.participantId);
    }
    
    @Test
    void testMultiplePlayerBetsWithOrdering() {
        // Simulate multiple player bets with different display orders
        TestBaseBet bet1 = new TestBaseBet();
        bet1.playerId = 11111;
        bet1.playerName = "Player 1";
        bet1.order = 1;
        
        TestBaseBet bet2 = new TestBaseBet();
        bet2.playerId = 22222;
        bet2.playerName = "Player 2";
        bet2.order = 2;
        
        TestBaseBet bet3 = new TestBaseBet();
        bet3.playerId = 33333;
        bet3.playerName = "Player 3";
        bet3.order = 3;
        
        assertTrue(bet1.order < bet2.order);
        assertTrue(bet2.order < bet3.order);
        assertNotEquals(bet1.playerId, bet2.playerId);
        assertNotEquals(bet2.playerId, bet3.playerId);
    }
    
    @Test
    void testTeamBetWithNoPlayer() {
        // Simulate a team-level bet (not player-specific)
        TestBaseBet bet = new TestBaseBet();
        bet.id = 200L;
        bet.name = "Team to Win";
        bet.participantId = 50;
        bet.playerId = 0; // No player associated
        bet.playerName = null;
        bet.order = 1;
        
        assertEquals(0, bet.playerId);
        assertNull(bet.playerName);
        assertEquals(50, bet.participantId);
    }
    
    @Test
    void testOrderDefaultValue() {
        TestBaseBet bet = new TestBaseBet();
        
        // Verify default order is 0
        assertEquals(0, bet.order);
    }
    
    @Test
    void testPlayerIdDefaultValue() {
        TestBaseBet bet = new TestBaseBet();
        
        // Verify default playerId is 0
        assertEquals(0, bet.playerId);
    }
    
    @Test
    void testSamePlayerDifferentBetTypes() {
        // Simulate different bet types for the same player
        TestBaseBet bet1 = new TestBaseBet();
        bet1.playerId = 99999;
        bet1.playerName = "Star Player";
        bet1.name = "To Score First";
        bet1.order = 1;
        
        TestBaseBet bet2 = new TestBaseBet();
        bet2.playerId = 99999; // Same player
        bet2.playerName = "Star Player";
        bet2.name = "To Score Anytime";
        bet2.order = 2;
        
        assertEquals(bet1.playerId, bet2.playerId);
        assertEquals(bet1.playerName, bet2.playerName);
        assertNotEquals(bet1.order, bet2.order);
        assertNotEquals(bet1.name, bet2.name);
    }
} 
