package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationBusinessTest {
    @Test
    void testFullFieldAssignment() {
        Location location = new Location();
        location.id = 101;
        location.name = "London";
        assertEquals(101, location.id);
        assertEquals("London", location.name);
    }

    @Test
    void testNullName() {
        Location location = new Location();
        location.name = null;
        assertNull(location.name);
    }

    @Test
    void testDefaultId() {
        Location location = new Location();
        assertEquals(0, location.id);
    }
} 