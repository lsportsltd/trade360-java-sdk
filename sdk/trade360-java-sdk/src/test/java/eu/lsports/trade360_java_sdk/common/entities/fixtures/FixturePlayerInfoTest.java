package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.PlayerType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FixturePlayerInfoTest {

    @Test
    void testDefaultValues() {
        FixturePlayerInfo playerInfo = new FixturePlayerInfo();

        assertEquals(0, playerInfo.id);
        assertNull(playerInfo.name);
        assertNull(playerInfo.teamId);
        assertNull(playerInfo.nationalityId);
        assertNull(playerInfo.birthDate);
        assertNull(playerInfo.type);
        assertNull(playerInfo.nationalTeamId);
    }

    @Test
    void testFieldAssignment() {
        FixturePlayerInfo playerInfo = new FixturePlayerInfo();
        LocalDateTime birthDate = LocalDateTime.of(1990, 5, 15, 0, 0);

        playerInfo.id = 123;
        playerInfo.name = "John Doe";
        playerInfo.teamId = 456;
        playerInfo.nationalityId = 789;
        playerInfo.birthDate = birthDate;
        playerInfo.type = PlayerType.PLAYER;
        playerInfo.nationalTeamId = 101;

        assertEquals(123, playerInfo.id);
        assertEquals("John Doe", playerInfo.name);
        assertEquals(456, playerInfo.teamId);
        assertEquals(789, playerInfo.nationalityId);
        assertEquals(birthDate, playerInfo.birthDate);
        assertEquals(PlayerType.PLAYER, playerInfo.type);
        assertEquals(101, playerInfo.nationalTeamId);
    }

    @Test
    void testPlayerTypeAssignment() {
        FixturePlayerInfo playerInfo = new FixturePlayerInfo();

        playerInfo.type = PlayerType.COACH;
        assertEquals(PlayerType.COACH, playerInfo.type);

        playerInfo.type = PlayerType.OTHER;
        assertEquals(PlayerType.OTHER, playerInfo.type);

        playerInfo.type = PlayerType.PLAYER;
        assertEquals(PlayerType.PLAYER, playerInfo.type);
    }

    @Test
    void testNullableFieldsCanBeSetToNull() {
        FixturePlayerInfo playerInfo = new FixturePlayerInfo();

        playerInfo.name = "Test";
        playerInfo.name = null;
        assertNull(playerInfo.name);

        playerInfo.teamId = 100;
        playerInfo.teamId = null;
        assertNull(playerInfo.teamId);
    }
}

