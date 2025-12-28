package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTypeTest {

    @Test
    void testPlayerTypeValues() {
        assertEquals(1, PlayerType.PLAYER.getValue());
        assertEquals(2, PlayerType.OTHER.getValue());
        assertEquals(3, PlayerType.COACH.getValue());
    }

    @Test
    void testPlayerTypeEnumCount() {
        assertEquals(3, PlayerType.values().length);
    }

    @Test
    void testPlayerTypeValueOf() {
        assertEquals(PlayerType.PLAYER, PlayerType.valueOf("PLAYER"));
        assertEquals(PlayerType.OTHER, PlayerType.valueOf("OTHER"));
        assertEquals(PlayerType.COACH, PlayerType.valueOf("COACH"));
    }
}

