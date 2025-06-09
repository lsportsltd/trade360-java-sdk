package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Period period = new Period();
        assertEquals(0, period.type);
        assertFalse(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNull(period.results);
        assertNull(period.incidents);
        assertNull(period.subPeriods);
        assertEquals(0, period.sequenceNumber);
    }
} 