package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VenueAssignmentTest {

    @Test
    void testGetValue() {
        assertEquals(0, VenueAssignment.HOME.getValue());
        assertEquals(1, VenueAssignment.AWAY.getValue());
        assertEquals(2, VenueAssignment.NEUTRAL.getValue());
    }

    @Test
    void testValueOfInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> VenueAssignment.valueOf("INVALID"));
    }

    @Test
    void testValueUniqueness() {
        VenueAssignment[] values = VenueAssignment.values();
        
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotEquals(values[i].getValue(), values[j].getValue(),
                    "Enum values should be unique: " + values[i] + " and " + values[j]);
            }
        }
    }
}


