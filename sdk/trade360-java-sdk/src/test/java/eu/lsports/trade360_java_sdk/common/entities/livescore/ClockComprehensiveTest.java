package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockComprehensiveTest {

    @Test
    void testClockDefaultConstructor() {
        Clock clock = new Clock();
        
        assertNotNull(clock);
        assertNull(clock.matchTime);
        assertNull(clock.stoppage);
    }

    @Test
    void testClockMatchTimeAssignment() {
        Clock clock = new Clock();
        String testMatchTime = "45:00";
        
        clock.matchTime = testMatchTime;
        
        assertEquals(testMatchTime, clock.matchTime);
        assertNull(clock.stoppage);
    }

    @Test
    void testClockStoppageAssignment() {
        Clock clock = new Clock();
        String testStoppage = "3:00";
        
        clock.stoppage = testStoppage;
        
        assertEquals(testStoppage, clock.stoppage);
        assertNull(clock.matchTime);
    }

    @Test
    void testClockAllFieldsAssignment() {
        Clock clock = new Clock();
        String testMatchTime = "90:00";
        String testStoppage = "5:00";
        
        clock.matchTime = testMatchTime;
        clock.stoppage = testStoppage;
        
        assertEquals(testMatchTime, clock.matchTime);
        assertEquals(testStoppage, clock.stoppage);
    }

    @Test
    void testClockNullAssignments() {
        Clock clock = new Clock();
        
        clock.matchTime = null;
        clock.stoppage = null;
        
        assertNull(clock.matchTime);
        assertNull(clock.stoppage);
    }

    @Test
    void testClockEmptyStringAssignments() {
        Clock clock = new Clock();
        
        clock.matchTime = "";
        clock.stoppage = "";
        
        assertEquals("", clock.matchTime);
        assertEquals("", clock.stoppage);
    }

    @Test
    void testClockTimeFormats() {
        Clock clock = new Clock();
        
        clock.matchTime = "0:00";
        assertEquals("0:00", clock.matchTime);
        
        clock.matchTime = "45:30";
        assertEquals("45:30", clock.matchTime);
        
        clock.matchTime = "90:00";
        assertEquals("90:00", clock.matchTime);
        
        clock.stoppage = "1:30";
        assertEquals("1:30", clock.stoppage);
        
        clock.stoppage = "10:00";
        assertEquals("10:00", clock.stoppage);
    }

    @Test
    void testClockReassignment() {
        Clock clock = new Clock();
        
        clock.matchTime = "30:00";
        clock.stoppage = "2:00";
        
        assertEquals("30:00", clock.matchTime);
        assertEquals("2:00", clock.stoppage);
        
        clock.matchTime = "75:00";
        clock.stoppage = "4:00";
        
        assertEquals("75:00", clock.matchTime);
        assertEquals("4:00", clock.stoppage);
    }

    @Test
    void testMultipleClockInstances() {
        Clock clock1 = new Clock();
        Clock clock2 = new Clock();
        
        clock1.matchTime = "45:00";
        clock1.stoppage = "3:00";
        
        clock2.matchTime = "90:00";
        clock2.stoppage = "5:00";
        
        assertEquals("45:00", clock1.matchTime);
        assertEquals("90:00", clock2.matchTime);
        assertNotEquals(clock1.matchTime, clock2.matchTime);
        assertNotEquals(clock1.stoppage, clock2.stoppage);
    }

    @Test
    void testClockFieldIndependence() {
        Clock clock = new Clock();
        
        clock.matchTime = "60:00";
        assertNull(clock.stoppage);
        
        clock.stoppage = "2:30";
        assertEquals("60:00", clock.matchTime);
    }

    @Test
    void testClockStringImmutability() {
        Clock clock = new Clock();
        String originalMatchTime = "45:00";
        String originalStoppage = "3:00";
        
        clock.matchTime = originalMatchTime;
        clock.stoppage = originalStoppage;
        
        String retrievedMatchTime = clock.matchTime;
        String retrievedStoppage = clock.stoppage;
        
        assertEquals(originalMatchTime, retrievedMatchTime);
        assertEquals(originalStoppage, retrievedStoppage);
        assertSame(originalMatchTime, retrievedMatchTime);
        assertSame(originalStoppage, retrievedStoppage);
    }

    @Test
    void testClockWithSpecialFormats() {
        Clock clock = new Clock();
        
        clock.matchTime = "120:00";
        assertEquals("120:00", clock.matchTime);
        
        clock.stoppage = "15:30";
        assertEquals("15:30", clock.stoppage);
        
        clock.matchTime = "0:30";
        assertEquals("0:30", clock.matchTime);
        
        clock.stoppage = "0:45";
        assertEquals("0:45", clock.stoppage);
    }

    @Test
    void testClockWithWhitespace() {
        Clock clock = new Clock();
        
        clock.matchTime = "  45:00  ";
        assertEquals("  45:00  ", clock.matchTime);
        
        clock.stoppage = "  3:00  ";
        assertEquals("  3:00  ", clock.stoppage);
    }

    @Test
    void testClockWithInvalidFormats() {
        Clock clock = new Clock();
        
        clock.matchTime = "invalid time";
        assertEquals("invalid time", clock.matchTime);
        
        clock.stoppage = "not a time";
        assertEquals("not a time", clock.stoppage);
        
        clock.matchTime = "45";
        assertEquals("45", clock.matchTime);
        
        clock.stoppage = "3";
        assertEquals("3", clock.stoppage);
    }

    @Test
    void testClockConsistency() {
        Clock clock1 = new Clock();
        Clock clock2 = new Clock();
        
        String testTime = "45:00";
        String testStoppage = "3:00";
        
        clock1.matchTime = testTime;
        clock1.stoppage = testStoppage;
        
        clock2.matchTime = testTime;
        clock2.stoppage = testStoppage;
        
        assertEquals(clock1.matchTime, clock2.matchTime);
        assertEquals(clock1.stoppage, clock2.stoppage);
    }
}
