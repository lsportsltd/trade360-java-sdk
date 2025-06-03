package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PeriodTest {
    @Test
    void testFieldAssignment() {
        Period period = new Period();
        period.type = 1;
        period.isFinished = true;
        period.isConfirmed = false;
        Result result = new Result();
        Incident incident = new Incident();
        Period sub = new Period();
        period.results = List.of(result);
        period.incidents = List.of(incident);
        period.subPeriods = List.of(sub);
        period.sequenceNumber = 5;
        assertEquals(1, period.type);
        assertTrue(period.isFinished);
        assertFalse(period.isConfirmed);
        assertNotNull(period.results);
        assertNotNull(period.incidents);
        assertNotNull(period.subPeriods);
        assertEquals(5, period.sequenceNumber);
    }
} 