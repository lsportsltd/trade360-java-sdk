package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Player player = new Player();
        assertEquals(0, player.id);
        assertNull(player.name);
    }
}
