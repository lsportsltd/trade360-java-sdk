package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StatisticFieldTest {

    @Test
    void testStatisticFieldAssignment() {
        Statistic statistic = new Statistic();
        
        Integer type = 10;
        Iterable<Result> results = Arrays.asList(new Result(), new Result());
        Iterable<Incident> incidents = Arrays.asList(new Incident(), new Incident());
        
        statistic.type = type;
        statistic.results = results;
        statistic.incidents = incidents;
        
        assertEquals(type, statistic.type);
        assertEquals(results, statistic.results);
        assertEquals(incidents, statistic.incidents);
    }

    @Test
    void testStatisticWithNullValues() {
        Statistic statistic = new Statistic();
        
        statistic.type = null;
        statistic.results = null;
        statistic.incidents = null;
        
        assertNull(statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }

    @Test
    void testStatisticDefaultConstructor() {
        Statistic statistic = new Statistic();
        
        assertNotNull(statistic);
        assertNull(statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }
}
