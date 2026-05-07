package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Players players = new Players();
        assertNull(players.item1);
        assertNull(players.item2);
    }
}
