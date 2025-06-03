package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {
    @Test
    void testFieldAssignment() {
        Statistic statistic = new Statistic();
        statistic.type = 7;
        Result result = new Result();
        Incident incident = new Incident();
        statistic.results = List.of(result);
        statistic.incidents = List.of(incident);
        assertEquals(7, statistic.type);
        assertNotNull(statistic.results);
        assertNotNull(statistic.incidents);
    }
} 