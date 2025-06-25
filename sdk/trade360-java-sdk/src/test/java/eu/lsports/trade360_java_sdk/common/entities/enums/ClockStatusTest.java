package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClockStatusTest {
    @Test
    void testEnumValues() {
        for (ClockStatus status : ClockStatus.values()) {
            assertNotNull(status);
            assertEquals(status, ClockStatus.valueOf(status.name()));
        }
    }

    @Test
    void testGetValue() {
        assertEquals(0, ClockStatus.STOPPED.getValue());
        assertEquals(1, ClockStatus.RUNNING.getValue());
        assertEquals(2, ClockStatus.PAUSED.getValue());
    }

    @Test
    void testEnumCount() {
        ClockStatus[] values = ClockStatus.values();
        assertEquals(3, values.length);
    }

    @Test
    void testEnumNames() {
        assertEquals("STOPPED", ClockStatus.STOPPED.name());
        assertEquals("RUNNING", ClockStatus.RUNNING.name());
        assertEquals("PAUSED", ClockStatus.PAUSED.name());
    }

    @Test
    void testEnumOrdinals() {
        assertEquals(0, ClockStatus.STOPPED.ordinal());
        assertEquals(1, ClockStatus.RUNNING.ordinal());
        assertEquals(2, ClockStatus.PAUSED.ordinal());
    }

    @Test
    void testValueOf() {
        assertEquals(ClockStatus.STOPPED, ClockStatus.valueOf("STOPPED"));
        assertEquals(ClockStatus.RUNNING, ClockStatus.valueOf("RUNNING"));
        assertEquals(ClockStatus.PAUSED, ClockStatus.valueOf("PAUSED"));
    }

    @Test
    void testValueOfInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> ClockStatus.valueOf("INVALID"));
    }

    @Test
    void testToString() {
        assertEquals("STOPPED", ClockStatus.STOPPED.toString());
        assertEquals("RUNNING", ClockStatus.RUNNING.toString());
        assertEquals("PAUSED", ClockStatus.PAUSED.toString());
    }
}