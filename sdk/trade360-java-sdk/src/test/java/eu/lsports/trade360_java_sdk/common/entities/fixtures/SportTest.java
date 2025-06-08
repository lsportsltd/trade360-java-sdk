package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Sport sport = new Sport();
        assertEquals(0, sport.id);
        assertNull(sport.name);

        sport.id = 3;
        sport.name = "Soccer";

        assertEquals(3, sport.id);
        assertEquals("Soccer", sport.name);
    }
} 