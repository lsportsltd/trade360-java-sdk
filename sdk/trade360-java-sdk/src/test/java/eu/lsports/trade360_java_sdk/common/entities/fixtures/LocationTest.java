package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Location location = new Location();
        assertEquals(0, location.id);
        assertNull(location.name);

        location.id = 5;
        location.name = "London";

        assertEquals(5, location.id);
        assertEquals("London", location.name);
    }
} 