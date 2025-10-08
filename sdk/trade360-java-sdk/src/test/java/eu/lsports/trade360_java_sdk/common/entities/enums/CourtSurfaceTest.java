package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourtSurfaceTest {

    @Test
    void testGetValue() {
        assertEquals(0, CourtSurface.GRASS.getValue());
        assertEquals(1, CourtSurface.HARD.getValue());
        assertEquals(2, CourtSurface.CLAY.getValue());
        assertEquals(3, CourtSurface.ARTIFICIAL_GRASS.getValue());
    }

    @Test
    void testValueOfInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> CourtSurface.valueOf("INVALID"));
    }

    @Test
    void testValueUniqueness() {
        CourtSurface[] values = CourtSurface.values();
        
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                assertNotEquals(values[i].getValue(), values[j].getValue(),
                    "Enum values should be unique: " + values[i] + " and " + values[j]);
            }
        }
    }
}


