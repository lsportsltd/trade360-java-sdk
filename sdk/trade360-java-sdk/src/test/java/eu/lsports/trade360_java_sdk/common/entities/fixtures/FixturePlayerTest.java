package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.PlayerType;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixturePlayerTest {

    @Test
    void testDefaultValues() {
        FixturePlayer fixturePlayer = new FixturePlayer();

        assertNull(fixturePlayer.playerId);
        assertNull(fixturePlayer.shirtNumber);
        assertNull(fixturePlayer.isCaptain);
        assertNull(fixturePlayer.isStartingLineup);
        assertNull(fixturePlayer.position);
        assertNull(fixturePlayer.state);
        assertNull(fixturePlayer.player);
    }

    @Test
    void testFieldAssignment() {
        FixturePlayer fixturePlayer = new FixturePlayer();

        fixturePlayer.playerId = 10;
        fixturePlayer.shirtNumber = "7";
        fixturePlayer.isCaptain = true;
        fixturePlayer.isStartingLineup = true;
        fixturePlayer.position = new IdNamePair(1, "Forward");
        fixturePlayer.state = new IdNamePair(1, "Active");

        FixturePlayerInfo playerInfo = new FixturePlayerInfo();
        playerInfo.id = 10;
        playerInfo.name = "Test Player";
        fixturePlayer.player = playerInfo;

        assertEquals(10, fixturePlayer.playerId);
        assertEquals("7", fixturePlayer.shirtNumber);
        assertTrue(fixturePlayer.isCaptain);
        assertTrue(fixturePlayer.isStartingLineup);
        assertNotNull(fixturePlayer.position);
        assertEquals("Forward", fixturePlayer.position.name());
        assertNotNull(fixturePlayer.state);
        assertEquals("Active", fixturePlayer.state.name());
        assertNotNull(fixturePlayer.player);
        assertEquals("Test Player", fixturePlayer.player.name);
    }

    @Test
    void testCaptainAndStartingLineupFlags() {
        FixturePlayer fixturePlayer = new FixturePlayer();

        fixturePlayer.isCaptain = false;
        fixturePlayer.isStartingLineup = false;

        assertFalse(fixturePlayer.isCaptain);
        assertFalse(fixturePlayer.isStartingLineup);

        fixturePlayer.isCaptain = true;
        fixturePlayer.isStartingLineup = true;

        assertTrue(fixturePlayer.isCaptain);
        assertTrue(fixturePlayer.isStartingLineup);
    }

    @Test
    void testPlayerInfoWithType() {
        FixturePlayer fixturePlayer = new FixturePlayer();
        FixturePlayerInfo playerInfo = new FixturePlayerInfo();

        playerInfo.id = 99;
        playerInfo.name = "Coach Name";
        playerInfo.type = PlayerType.COACH;

        fixturePlayer.player = playerInfo;

        assertEquals(PlayerType.COACH, fixturePlayer.player.type);
    }

    @Test
    void testNullableFieldsCanBeSetToNull() {
        FixturePlayer fixturePlayer = new FixturePlayer();

        fixturePlayer.playerId = 10;
        fixturePlayer.playerId = null;
        assertNull(fixturePlayer.playerId);

        fixturePlayer.isCaptain = true;
        fixturePlayer.isCaptain = null;
        assertNull(fixturePlayer.isCaptain);
    }
}

