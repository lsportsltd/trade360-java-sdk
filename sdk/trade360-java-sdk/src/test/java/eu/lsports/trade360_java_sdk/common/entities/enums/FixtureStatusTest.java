package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixtureStatusTest {
    @Test
    void testEnumValues() {
        for (FixtureStatus status : FixtureStatus.values()) {
            assertNotNull(status);
            assertEquals(status, FixtureStatus.valueOf(status.name()));
        }
    }

    @Test
    void testGetValue() {
        assertEquals(0, FixtureStatus.NOT_SET.getValue());
        assertEquals(1, FixtureStatus.NSY.getValue());
        assertEquals(2, FixtureStatus.IN_PROGRESS.getValue());
        assertEquals(3, FixtureStatus.FINISHED.getValue());
        // ... add more if desired
    }
} 