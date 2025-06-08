package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportBusinessTest {
    @Test
    void testFullFieldAssignment() {
        Sport sport = new Sport();
        sport.id = 5;
        sport.name = "Football";
        assertEquals(5, sport.id);
        assertEquals("Football", sport.name);
    }

    @Test
    void testNullName() {
        Sport sport = new Sport();
        sport.name = null;
        assertNull(sport.name);
    }

    @Test
    void testDefaultId() {
        Sport sport = new Sport();
        assertEquals(0, sport.id);
    }
} 