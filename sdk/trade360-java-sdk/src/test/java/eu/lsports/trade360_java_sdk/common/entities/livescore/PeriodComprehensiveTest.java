package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodComprehensiveTest {

    @Test
    void testPeriodDefaultConstructor() {
        Period period = new Period();
        
        assertNotNull(period);
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodTypeAssignment() {
        Period period = new Period();
        Integer testType = 1;
        
        period.type = testType;
        
        assertEquals(testType, period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodNumberAssignment() {
        Period period = new Period();
        Integer testNumber = 2;
        
        period.number = testNumber;
        
        assertEquals(testNumber, period.number);
        assertNull(period.type);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodIsFinishedAssignment() {
        Period period = new Period();
        Boolean testIsFinished = true;
        
        period.isFinished = testIsFinished;
        
        assertEquals(testIsFinished, period.isFinished);
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodIsConfirmedAssignment() {
        Period period = new Period();
        Boolean testIsConfirmed = false;
        
        period.isConfirmed = testIsConfirmed;
        
        assertEquals(testIsConfirmed, period.isConfirmed);
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodStartTimeAssignment() {
        Period period = new Period();
        String testStartTime = "2023-12-25T15:30:00";
        
        period.startTime = testStartTime;
        
        assertEquals(testStartTime, period.startTime);
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodEndTimeAssignment() {
        Period period = new Period();
        String testEndTime = "2023-12-25T17:30:00";
        
        period.endTime = testEndTime;
        
        assertEquals(testEndTime, period.endTime);
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodAllFieldsAssignment() {
        Period period = new Period();
        Integer testType = 1;
        Integer testNumber = 2;
        Boolean testIsFinished = true;
        Boolean testIsConfirmed = false;
        String testStartTime = "2023-12-25T15:30:00";
        String testEndTime = "2023-12-25T17:30:00";
        
        period.type = testType;
        period.number = testNumber;
        period.isFinished = testIsFinished;
        period.isConfirmed = testIsConfirmed;
        period.startTime = testStartTime;
        period.endTime = testEndTime;
        
        assertEquals(testType, period.type);
        assertEquals(testNumber, period.number);
        assertEquals(testIsFinished, period.isFinished);
        assertEquals(testIsConfirmed, period.isConfirmed);
        assertEquals(testStartTime, period.startTime);
        assertEquals(testEndTime, period.endTime);
    }

    @Test
    void testPeriodNullAssignments() {
        Period period = new Period();
        
        period.type = null;
        period.number = null;
        period.isFinished = null;
        period.isConfirmed = null;
        period.startTime = null;
        period.endTime = null;
        period.results = null;
        period.statistics = null;
        period.incidents = null;
        
        assertNull(period.type);
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        assertNull(period.results);
        assertNull(period.statistics);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodBooleanEdgeCases() {
        Period period = new Period();
        
        period.isFinished = true;
        assertEquals(Boolean.TRUE, period.isFinished);
        
        period.isFinished = false;
        assertEquals(Boolean.FALSE, period.isFinished);
        
        period.isConfirmed = true;
        assertEquals(Boolean.TRUE, period.isConfirmed);
        
        period.isConfirmed = false;
        assertEquals(Boolean.FALSE, period.isConfirmed);
    }

    @Test
    void testPeriodIntegerEdgeCases() {
        Period period = new Period();
        
        period.type = 0;
        assertEquals(Integer.valueOf(0), period.type);
        
        period.type = -1;
        assertEquals(Integer.valueOf(-1), period.type);
        
        period.type = Integer.MAX_VALUE;
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), period.type);
        
        period.number = 0;
        assertEquals(Integer.valueOf(0), period.number);
        
        period.number = -1;
        assertEquals(Integer.valueOf(-1), period.number);
        
        period.number = Integer.MAX_VALUE;
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), period.number);
    }

    @Test
    void testPeriodTimeStringFormats() {
        Period period = new Period();
        
        String isoDateTime = "2023-12-25T15:30:45.123Z";
        period.startTime = isoDateTime;
        assertEquals(isoDateTime, period.startTime);
        
        String simpleDateTime = "2023-12-25T15:30:45";
        period.endTime = simpleDateTime;
        assertEquals(simpleDateTime, period.endTime);
        
        String dateOnly = "2023-12-25";
        period.startTime = dateOnly;
        assertEquals(dateOnly, period.startTime);
    }

    @Test
    void testPeriodEmptyStringAssignments() {
        Period period = new Period();
        
        period.startTime = "";
        period.endTime = "";
        
        assertEquals("", period.startTime);
        assertEquals("", period.endTime);
    }

    @Test
    void testPeriodSpecialCharacterStrings() {
        Period period = new Period();
        
        String specialStartTime = "2023-12-25T15:30:45+02:00";
        String specialEndTime = "2023-12-25T17:30:45-05:00";
        
        period.startTime = specialStartTime;
        period.endTime = specialEndTime;
        
        assertEquals(specialStartTime, period.startTime);
        assertEquals(specialEndTime, period.endTime);
    }

    @Test
    void testPeriodReassignment() {
        Period period = new Period();
        
        period.type = 1;
        period.number = 1;
        period.isFinished = true;
        period.isConfirmed = true;
        period.startTime = "2023-12-25T15:30:00";
        period.endTime = "2023-12-25T17:30:00";
        
        assertEquals(Integer.valueOf(1), period.type);
        assertEquals(Integer.valueOf(1), period.number);
        assertEquals(Boolean.TRUE, period.isFinished);
        assertEquals(Boolean.TRUE, period.isConfirmed);
        assertEquals("2023-12-25T15:30:00", period.startTime);
        assertEquals("2023-12-25T17:30:00", period.endTime);
        
        period.type = 2;
        period.number = 2;
        period.isFinished = false;
        period.isConfirmed = false;
        period.startTime = "2023-12-26T15:30:00";
        period.endTime = "2023-12-26T17:30:00";
        
        assertEquals(Integer.valueOf(2), period.type);
        assertEquals(Integer.valueOf(2), period.number);
        assertEquals(Boolean.FALSE, period.isFinished);
        assertEquals(Boolean.FALSE, period.isConfirmed);
        assertEquals("2023-12-26T15:30:00", period.startTime);
        assertEquals("2023-12-26T17:30:00", period.endTime);
    }

    @Test
    void testMultiplePeriodInstances() {
        Period period1 = new Period();
        Period period2 = new Period();
        
        period1.type = 1;
        period1.number = 1;
        period1.isFinished = true;
        period1.startTime = "2023-12-25T15:30:00";
        
        period2.type = 2;
        period2.number = 2;
        period2.isFinished = false;
        period2.startTime = "2023-12-25T17:30:00";
        
        assertEquals(Integer.valueOf(1), period1.type);
        assertEquals(Integer.valueOf(2), period2.type);
        assertNotEquals(period1.type, period2.type);
        assertNotEquals(period1.number, period2.number);
        assertNotEquals(period1.isFinished, period2.isFinished);
        assertNotEquals(period1.startTime, period2.startTime);
    }

    @Test
    void testPeriodFieldIndependence() {
        Period period = new Period();
        
        period.type = 1;
        assertNull(period.number);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        
        period.number = 2;
        assertEquals(Integer.valueOf(1), period.type);
        assertNull(period.isFinished);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
        
        period.isFinished = true;
        assertEquals(Integer.valueOf(1), period.type);
        assertEquals(Integer.valueOf(2), period.number);
        assertNull(period.isConfirmed);
        assertNull(period.startTime);
        assertNull(period.endTime);
    }

    @Test
    void testPeriodStringImmutability() {
        Period period = new Period();
        String originalStartTime = "2023-12-25T15:30:00";
        String originalEndTime = "2023-12-25T17:30:00";
        
        period.startTime = originalStartTime;
        period.endTime = originalEndTime;
        
        String retrievedStartTime = period.startTime;
        String retrievedEndTime = period.endTime;
        
        assertEquals(originalStartTime, retrievedStartTime);
        assertEquals(originalEndTime, retrievedEndTime);
        assertSame(originalStartTime, retrievedStartTime);
        assertSame(originalEndTime, retrievedEndTime);
    }

    @Test
    void testPeriodWithWhitespaceStrings() {
        Period period = new Period();
        
        period.startTime = "  2023-12-25T15:30:00  ";
        period.endTime = "  2023-12-25T17:30:00  ";
        
        assertEquals("  2023-12-25T15:30:00  ", period.startTime);
        assertEquals("  2023-12-25T17:30:00  ", period.endTime);
    }

    @Test
    void testPeriodWithUnicodeStrings() {
        Period period = new Period();
        
        period.startTime = "2023-12-25T15:30:00 ñáéíóú";
        period.endTime = "2023-12-25T17:30:00 中文";
        
        assertEquals("2023-12-25T15:30:00 ñáéíóú", period.startTime);
        assertEquals("2023-12-25T17:30:00 中文", period.endTime);
    }
}
