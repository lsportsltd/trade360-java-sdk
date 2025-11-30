package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubstitutionPlayersTest {
    @Test
    void testFieldAssignmentAndNullability() {
        SubstitutionPlayers players = new SubstitutionPlayers();
        assertNull(players.item1);
        assertNull(players.item2);
    }
}

