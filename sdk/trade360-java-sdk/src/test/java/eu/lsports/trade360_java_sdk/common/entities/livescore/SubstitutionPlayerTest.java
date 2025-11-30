package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubstitutionPlayerTest {
    @Test
    void testFieldAssignmentAndNullability() {
        SubstitutionPlayer player = new SubstitutionPlayer();
        assertEquals(0, player.id);
        assertNull(player.name);
    }
}

