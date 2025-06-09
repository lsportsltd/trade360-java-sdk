package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeriodCorrectTest {

    @Test
    void testPeriodDefaultConstructor() {
        Period period = new Period();
        
        assertNotNull(period);
        assertEquals(0, period.type);
        assertEquals(0, period.sequenceNumber);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodTypeAssignment() {
        Period period = new Period();
        int testType = 1;
        
        period.type = testType;
        
        assertEquals(testType, period.type);
        assertEquals(0, period.sequenceNumber);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodSequenceNumberAssignment() {
        Period period = new Period();
        int testSequenceNumber = 2;
        
        period.sequenceNumber = testSequenceNumber;
        
        assertEquals(testSequenceNumber, period.sequenceNumber);
        assertEquals(0, period.type);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodIsFinishedAssignment() {
        Period period = new Period();
        boolean testIsFinished = true;
        
        period.isFinished = testIsFinished;
        
        assertEquals(testIsFinished, period.isFinished);
        assertEquals(0, period.type);
        assertEquals(0, period.sequenceNumber);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodIsConfirmedAssignment() {
        Period period = new Period();
        boolean testIsConfirmed = true;
        
        period.isConfirmed = testIsConfirmed;
        
        assertEquals(testIsConfirmed, period.isConfirmed);
        assertEquals(0, period.type);
        assertEquals(0, period.sequenceNumber);
        assertFalse(period.isFinished);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodAllFieldsAssignment() {
        Period period = new Period();
        int testType = 1;
        int testSequenceNumber = 2;
        boolean testIsFinished = true;
        boolean testIsConfirmed = false;
        
        period.type = testType;
        period.sequenceNumber = testSequenceNumber;
        period.isFinished = testIsFinished;
        period.isConfirmed = testIsConfirmed;
        
        assertEquals(testType, period.type);
        assertEquals(testSequenceNumber, period.sequenceNumber);
        assertEquals(testIsFinished, period.isFinished);
        assertEquals(testIsConfirmed, period.isConfirmed);
    }

    @Test
    void testPeriodNullAssignments() {
        Period period = new Period();
        
        period.results = null;
        period.subPeriods = null;
        period.incidents = null;
        
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }

    @Test
    void testPeriodBooleanEdgeCases() {
        Period period = new Period();
        
        period.isFinished = true;
        assertTrue(period.isFinished);
        
        period.isFinished = false;
        assertFalse(period.isFinished);
        
        period.isConfirmed = true;
        assertTrue(period.isConfirmed);
        
        period.isConfirmed = false;
        assertFalse(period.isConfirmed);
    }

    @Test
    void testPeriodIntegerEdgeCases() {
        Period period = new Period();
        
        period.type = 0;
        assertEquals(0, period.type);
        
        period.type = -1;
        assertEquals(-1, period.type);
        
        period.type = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, period.type);
        
        period.sequenceNumber = 0;
        assertEquals(0, period.sequenceNumber);
        
        period.sequenceNumber = -1;
        assertEquals(-1, period.sequenceNumber);
        
        period.sequenceNumber = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, period.sequenceNumber);
    }

    @Test
    void testPeriodReassignment() {
        Period period = new Period();
        
        period.type = 1;
        period.sequenceNumber = 1;
        period.isFinished = true;
        period.isConfirmed = true;
        
        assertEquals(1, period.type);
        assertEquals(1, period.sequenceNumber);
        assertTrue(period.isFinished);
        assertTrue(period.isConfirmed);
        
        period.type = 2;
        period.sequenceNumber = 2;
        period.isFinished = false;
        period.isConfirmed = false;
        
        assertEquals(2, period.type);
        assertEquals(2, period.sequenceNumber);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
    }

    @Test
    void testMultiplePeriodInstances() {
        Period period1 = new Period();
        Period period2 = new Period();
        
        period1.type = 1;
        period1.sequenceNumber = 1;
        period1.isFinished = true;
        
        period2.type = 2;
        period2.sequenceNumber = 2;
        period2.isFinished = false;
        
        assertEquals(1, period1.type);
        assertEquals(2, period2.type);
        assertNotEquals(period1.type, period2.type);
        assertNotEquals(period1.sequenceNumber, period2.sequenceNumber);
        assertNotEquals(period1.isFinished, period2.isFinished);
    }

    @Test
    void testPeriodFieldIndependence() {
        Period period = new Period();
        
        period.type = 1;
        assertEquals(0, period.sequenceNumber);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
        
        period.sequenceNumber = 2;
        assertEquals(1, period.type);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
        
        period.isFinished = true;
        assertEquals(1, period.type);
        assertEquals(2, period.sequenceNumber);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.subPeriods);
        assertNull(period.incidents);
    }
}
