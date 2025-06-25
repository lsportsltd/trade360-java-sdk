package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticTest {

    @Test
    void testPlayerStatisticDefaultConstructor() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        assertNotNull(playerStatistic);
        assertEquals(0, playerStatistic.playerId);
        assertNull(playerStatistic.statistics);
        assertNull(playerStatistic.playerName);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticPlayerIdAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        int testPlayerId = 12345;

        playerStatistic.playerId = testPlayerId;

        assertEquals(testPlayerId, playerStatistic.playerId);
        assertNull(playerStatistic.statistics);
        assertNull(playerStatistic.playerName);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticStatisticsAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        StatisticValue stat1 = new StatisticValue();
        stat1.id = 1;
        stat1.name = "Goals";
        stat1.value = "2";

        playerStatistic.statistics = Arrays.asList(stat1);

        assertNotNull(playerStatistic.statistics);
        assertEquals(0, playerStatistic.playerId);
        assertNull(playerStatistic.playerName);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticPlayerNameAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        String testPlayerName = "John Doe";

        playerStatistic.playerName = testPlayerName;

        assertEquals(testPlayerName, playerStatistic.playerName);
        assertEquals(0, playerStatistic.playerId);
        assertNull(playerStatistic.statistics);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticTeamIdAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        int testTeamId = 67890;

        playerStatistic.teamId = testTeamId;

        assertEquals(testTeamId, playerStatistic.teamId);
        assertEquals(0, playerStatistic.playerId);
        assertNull(playerStatistic.statistics);
        assertNull(playerStatistic.playerName);
        assertFalse(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticHasPlayedAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.hasPlayed = true;

        assertTrue(playerStatistic.hasPlayed);
        assertEquals(0, playerStatistic.playerId);
        assertNull(playerStatistic.statistics);
        assertNull(playerStatistic.playerName);
        assertEquals(0, playerStatistic.teamId);
    }

    @Test
    void testPlayerStatisticAllFieldsAssignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        int testPlayerId = 123;
        String testPlayerName = "Jane Smith";
        int testTeamId = 456;
        boolean testHasPlayed = true;

        StatisticValue stat1 = new StatisticValue();
        stat1.id = 1;
        stat1.name = "Goals";
        stat1.value = "3";

        StatisticValue stat2 = new StatisticValue();
        stat2.id = 2;
        stat2.name = "Assists";
        stat2.value = "2";

        playerStatistic.playerId = testPlayerId;
        playerStatistic.statistics = Arrays.asList(stat1, stat2);
        playerStatistic.playerName = testPlayerName;
        playerStatistic.teamId = testTeamId;
        playerStatistic.hasPlayed = testHasPlayed;

        assertEquals(testPlayerId, playerStatistic.playerId);
        assertNotNull(playerStatistic.statistics);
        assertEquals(testPlayerName, playerStatistic.playerName);
        assertEquals(testTeamId, playerStatistic.teamId);
        assertEquals(testHasPlayed, playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticNullAssignments() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.statistics = null;
        playerStatistic.playerName = null;

        assertNull(playerStatistic.statistics);
        assertNull(playerStatistic.playerName);
    }

    @Test
    void testPlayerStatisticIntegerEdgeCases() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerId = 0;
        assertEquals(0, playerStatistic.playerId);

        playerStatistic.playerId = -1;
        assertEquals(-1, playerStatistic.playerId);

        playerStatistic.playerId = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, playerStatistic.playerId);

        playerStatistic.teamId = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, playerStatistic.teamId);
    }

    @Test
    void testPlayerStatisticStringEdgeCases() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerName = "";
        assertEquals("", playerStatistic.playerName);

        playerStatistic.playerName = "Very Long Player Name With Many Characters";
        assertEquals("Very Long Player Name With Many Characters", playerStatistic.playerName);
    }

    @Test
    void testPlayerStatisticBooleanEdgeCases() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.hasPlayed = false;
        assertFalse(playerStatistic.hasPlayed);

        playerStatistic.hasPlayed = true;
        assertTrue(playerStatistic.hasPlayed);
    }

    @Test
    void testPlayerStatisticEmptyStatistics() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.statistics = new ArrayList<>();

        assertNotNull(playerStatistic.statistics);
        assertFalse(playerStatistic.statistics.iterator().hasNext());
    }

    @Test
    void testPlayerStatisticMultipleStatistics() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        StatisticValue stat1 = new StatisticValue();
        stat1.id = 1;
        stat1.name = "Goals";
        stat1.value = "2";

        StatisticValue stat2 = new StatisticValue();
        stat2.id = 2;
        stat2.name = "Assists";
        stat2.value = "3";

        StatisticValue stat3 = new StatisticValue();
        stat3.id = 3;
        stat3.name = "Shots";
        stat3.value = "5";

        playerStatistic.statistics = Arrays.asList(stat1, stat2, stat3);

        assertNotNull(playerStatistic.statistics);
        int count = 0;
        for (StatisticValue stat : playerStatistic.statistics) {
            assertNotNull(stat);
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    void testPlayerStatisticReassignment() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerId = 100;
        playerStatistic.playerName = "First Player";
        playerStatistic.teamId = 200;
        playerStatistic.hasPlayed = false;

        assertEquals(100, playerStatistic.playerId);
        assertEquals("First Player", playerStatistic.playerName);
        assertEquals(200, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);

        playerStatistic.playerId = 300;
        playerStatistic.playerName = "Second Player";
        playerStatistic.teamId = 400;
        playerStatistic.hasPlayed = true;

        assertEquals(300, playerStatistic.playerId);
        assertEquals("Second Player", playerStatistic.playerName);
        assertEquals(400, playerStatistic.teamId);
        assertTrue(playerStatistic.hasPlayed);
    }

    @Test
    void testMultiplePlayerStatisticInstances() {
        PlayerStatistic player1 = new PlayerStatistic();
        PlayerStatistic player2 = new PlayerStatistic();

        player1.playerId = 1;
        player1.playerName = "Player One";
        player1.teamId = 10;
        player1.hasPlayed = true;

        player2.playerId = 2;
        player2.playerName = "Player Two";
        player2.teamId = 20;
        player2.hasPlayed = false;

        assertEquals(1, player1.playerId);
        assertEquals(2, player2.playerId);
        assertNotEquals(player1.playerId, player2.playerId);
        assertNotEquals(player1.playerName, player2.playerName);
        assertNotEquals(player1.teamId, player2.teamId);
        assertNotEquals(player1.hasPlayed, player2.hasPlayed);
    }

    @Test
    void testPlayerStatisticFieldIndependence() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerId = 999;
        assertNull(playerStatistic.playerName);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);

        playerStatistic.playerName = "Test Player";
        assertEquals(999, playerStatistic.playerId);
        assertEquals(0, playerStatistic.teamId);
        assertFalse(playerStatistic.hasPlayed);

        playerStatistic.teamId = 888;
        assertEquals(999, playerStatistic.playerId);
        assertEquals("Test Player", playerStatistic.playerName);
        assertFalse(playerStatistic.hasPlayed);

        playerStatistic.hasPlayed = true;
        assertEquals(999, playerStatistic.playerId);
        assertEquals("Test Player", playerStatistic.playerName);
        assertEquals(888, playerStatistic.teamId);
    }

    @Test
    void testPlayerStatisticStringImmutability() {
        PlayerStatistic playerStatistic = new PlayerStatistic();
        String originalName = "Original Player";

        playerStatistic.playerName = originalName;

        String retrievedName = playerStatistic.playerName;

        assertEquals(originalName, retrievedName);
        assertSame(originalName, retrievedName);
    }

    @Test
    void testPlayerStatisticWithSpecialCharacters() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerName = "Player with special chars: !@#$%^&*()";
        assertEquals("Player with special chars: !@#$%^&*()", playerStatistic.playerName);

        playerStatistic.playerName = "Unicode: ñáéíóú 中文";
        assertEquals("Unicode: ñáéíóú 中文", playerStatistic.playerName);
    }

    @Test
    void testPlayerStatisticWithWhitespace() {
        PlayerStatistic playerStatistic = new PlayerStatistic();

        playerStatistic.playerName = "  Player Name  ";
        assertEquals("  Player Name  ", playerStatistic.playerName);

        playerStatistic.playerName = "\tTabbed\tPlayer\tName\t";
        assertEquals("\tTabbed\tPlayer\tName\t", playerStatistic.playerName);
    }

    @Test
    void testPlayerStatisticConsistency() {
        PlayerStatistic player1 = new PlayerStatistic();
        PlayerStatistic player2 = new PlayerStatistic();

        int testPlayerId = 123;
        String testPlayerName = "Consistency Test";
        int testTeamId = 456;
        boolean testHasPlayed = true;

        player1.playerId = testPlayerId;
        player1.playerName = testPlayerName;
        player1.teamId = testTeamId;
        player1.hasPlayed = testHasPlayed;

        player2.playerId = testPlayerId;
        player2.playerName = testPlayerName;
        player2.teamId = testTeamId;
        player2.hasPlayed = testHasPlayed;

        assertEquals(player1.playerId, player2.playerId);
        assertEquals(player1.playerName, player2.playerName);
        assertEquals(player1.teamId, player2.teamId);
        assertEquals(player1.hasPlayed, player2.hasPlayed);
    }
}