package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.enums.ClockStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    @Test
    void testClockDefaultConstructor() {
        Clock clock = new Clock();

        assertNotNull(clock);
        assertNull(clock.status);
        assertEquals(0, clock.seconds);
    }

    @Test
    void testClockStatusAssignment() {
        Clock clock = new Clock();
        ClockStatus testStatus = ClockStatus.RUNNING;

        clock.status = testStatus;

        assertEquals(testStatus, clock.status);
        assertEquals(0, clock.seconds);
    }

    @Test
    void testClockSecondsAssignment() {
        Clock clock = new Clock();
        int testSeconds = 1800;

        clock.seconds = testSeconds;

        assertEquals(testSeconds, clock.seconds);
        assertNull(clock.status);
    }

    @Test
    void testClockAllFieldsAssignment() {
        Clock clock = new Clock();
        ClockStatus testStatus = ClockStatus.PAUSED;
        int testSeconds = 2700;

        clock.status = testStatus;
        clock.seconds = testSeconds;

        assertEquals(testStatus, clock.status);
        assertEquals(testSeconds, clock.seconds);
    }

    @Test
    void testClockNullAssignments() {
        Clock clock = new Clock();

        clock.status = null;

        assertNull(clock.status);
    }

    @Test
    void testClockIntegerEdgeCases() {
        Clock clock = new Clock();

        clock.seconds = 0;
        assertEquals(0, clock.seconds);

        clock.seconds = -1;
        assertEquals(-1, clock.seconds);

        clock.seconds = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, clock.seconds);

        clock.seconds = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, clock.seconds);
    }

    @Test
    void testClockReassignment() {
        Clock clock = new Clock();

        clock.status = ClockStatus.STOPPED;
        clock.seconds = 0;

        assertEquals(ClockStatus.STOPPED, clock.status);
        assertEquals(0, clock.seconds);

        clock.status = ClockStatus.RUNNING;
        clock.seconds = 1800;

        assertEquals(ClockStatus.RUNNING, clock.status);
        assertEquals(1800, clock.seconds);
    }

    @Test
    void testMultipleClockInstances() {
        Clock clock1 = new Clock();
        Clock clock2 = new Clock();

        clock1.status = ClockStatus.RUNNING;
        clock1.seconds = 900;

        clock2.status = ClockStatus.PAUSED;
        clock2.seconds = 1800;

        assertEquals(ClockStatus.RUNNING, clock1.status);
        assertEquals(ClockStatus.PAUSED, clock2.status);
        assertNotEquals(clock1.status, clock2.status);
        assertNotEquals(clock1.seconds, clock2.seconds);
    }

    @Test
    void testClockFieldIndependence() {
        Clock clock = new Clock();

        clock.status = ClockStatus.RUNNING;
        assertEquals(0, clock.seconds);

        clock.seconds = 2700;
        assertEquals(ClockStatus.RUNNING, clock.status);
    }

    @Test
    void testClockConsistency() {
        Clock clock1 = new Clock();
        Clock clock2 = new Clock();

        ClockStatus testStatus = ClockStatus.PAUSED;
        int testSeconds = 1800;

        clock1.status = testStatus;
        clock1.seconds = testSeconds;

        clock2.status = testStatus;
        clock2.seconds = testSeconds;

        assertEquals(clock1.status, clock2.status);
        assertEquals(clock1.seconds, clock2.seconds);
    }

    @Test
    void testClockAllEnumValues() {
        Clock clock = new Clock();

        for (ClockStatus status : ClockStatus.values()) {
            clock.status = status;
            assertEquals(status, clock.status);
        }
    }
}