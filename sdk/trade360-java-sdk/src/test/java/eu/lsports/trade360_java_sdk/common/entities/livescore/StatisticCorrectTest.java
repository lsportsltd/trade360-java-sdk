package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticCorrectTest {

    @Test
    void testStatisticDefaultConstructor() {
        Statistic statistic = new Statistic();
        
        assertNotNull(statistic);
        assertNull(statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }

    @Test
    void testStatisticTypeAssignment() {
        Statistic statistic = new Statistic();
        Integer testType = 1;
        
        statistic.type = testType;
        
        assertEquals(testType, statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }

    @Test
    void testStatisticNullAssignments() {
        Statistic statistic = new Statistic();
        
        statistic.type = null;
        statistic.results = null;
        statistic.incidents = null;
        
        assertNull(statistic.type);
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }

    @Test
    void testStatisticTypeEdgeCases() {
        Statistic statistic = new Statistic();
        
        statistic.type = 0;
        assertEquals(Integer.valueOf(0), statistic.type);
        
        statistic.type = -1;
        assertEquals(Integer.valueOf(-1), statistic.type);
        
        statistic.type = Integer.MAX_VALUE;
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), statistic.type);
    }

    @Test
    void testStatisticReassignment() {
        Statistic statistic = new Statistic();
        
        statistic.type = 1;
        assertEquals(Integer.valueOf(1), statistic.type);
        
        statistic.type = 2;
        assertEquals(Integer.valueOf(2), statistic.type);
    }

    @Test
    void testMultipleStatisticInstances() {
        Statistic statistic1 = new Statistic();
        Statistic statistic2 = new Statistic();
        
        statistic1.type = 1;
        statistic2.type = 2;
        
        assertEquals(Integer.valueOf(1), statistic1.type);
        assertEquals(Integer.valueOf(2), statistic2.type);
        assertNotEquals(statistic1.type, statistic2.type);
    }

    @Test
    void testStatisticFieldIndependence() {
        Statistic statistic = new Statistic();
        
        statistic.type = 1;
        assertNull(statistic.results);
        assertNull(statistic.incidents);
    }

    @Test
    void testStatisticConsistency() {
        Statistic statistic1 = new Statistic();
        Statistic statistic2 = new Statistic();
        
        Integer testType = 1;
        
        statistic1.type = testType;
        statistic2.type = testType;
        
        assertEquals(statistic1.type, statistic2.type);
    }
}
