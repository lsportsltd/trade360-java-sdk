package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VenueEnvironmentTest {

    @Test
    void testGetValue() {
        assertEquals(0, VenueEnvironment.INDOORS.getValue());
        assertEquals(1, VenueEnvironment.OUTDOORS.getValue());
    }

    @Test
    void testValueOfInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> VenueEnvironment.valueOf("INVALID"));
    }

    @Test
    void testValueUniqueness() {
        VenueEnvironment[] values = VenueEnvironment.values();
        
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotEquals(values[i].getValue(), values[j].getValue(),
                    "Enum values should be unique: " + values[i] + " and " + values[j]);
            }
        }
    }
}


