package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Statistic statistic = new Statistic();
        assertNull(statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);

        statistic.type = 1;
        assertEquals(1, statistic.type);
    }
} 