package eu.lsports.trade360_java_sdk.common.entities.livescore;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatisticValueTest {

    @Test
    void testStatisticValueDefaultConstructor() {
        StatisticValue statisticValue = new StatisticValue();

        assertNotNull(statisticValue);
        assertEquals(0, statisticValue.id);
        assertNull(statisticValue.name);
        assertNull(statisticValue.value);
    }

    @Test
    void testStatisticValueIdAssignment() {
        StatisticValue statisticValue = new StatisticValue();
        int testId = 123;

        statisticValue.id = testId;

        assertEquals(testId, statisticValue.id);
        assertNull(statisticValue.name);
        assertNull(statisticValue.value);
    }

    @Test
    void testStatisticValueNameAssignment() {
        StatisticValue statisticValue = new StatisticValue();
        String testName = "Goals";

        statisticValue.name = testName;

        assertEquals(testName, statisticValue.name);
        assertEquals(0, statisticValue.id);
        assertNull(statisticValue.value);
    }

    @Test
    void testStatisticValueValueAssignment() {
        StatisticValue statisticValue = new StatisticValue();
        String testValue = "3";

        statisticValue.value = testValue;

        assertEquals(testValue, statisticValue.value);
        assertEquals(0, statisticValue.id);
        assertNull(statisticValue.name);
    }

    @Test
    void testStatisticValueAllFieldsAssignment() {
        StatisticValue statisticValue = new StatisticValue();
        int testId = 456;
        String testName = "Assists";
        String testValue = "2";

        statisticValue.id = testId;
        statisticValue.name = testName;
        statisticValue.value = testValue;

        assertEquals(testId, statisticValue.id);
        assertEquals(testName, statisticValue.name);
        assertEquals(testValue, statisticValue.value);
    }

    @Test
    void testStatisticValueNullAssignments() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.name = null;
        statisticValue.value = null;

        assertNull(statisticValue.name);
        assertNull(statisticValue.value);
    }

    @Test
    void testStatisticValueIntegerEdgeCases() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.id = 0;
        assertEquals(0, statisticValue.id);

        statisticValue.id = -1;
        assertEquals(-1, statisticValue.id);

        statisticValue.id = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, statisticValue.id);

        statisticValue.id = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, statisticValue.id);
    }

    @Test
    void testStatisticValueStringEdgeCases() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.name = "";
        assertEquals("", statisticValue.name);

        statisticValue.value = "";
        assertEquals("", statisticValue.value);

        statisticValue.name = "Very Long Statistic Name";
        assertEquals("Very Long Statistic Name", statisticValue.name);

        statisticValue.value = "Very Long Statistic Value";
        assertEquals("Very Long Statistic Value", statisticValue.value);
    }

    @Test
    void testStatisticValueReassignment() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.id = 100;
        statisticValue.name = "Shots";
        statisticValue.value = "5";

        assertEquals(100, statisticValue.id);
        assertEquals("Shots", statisticValue.name);
        assertEquals("5", statisticValue.value);

        statisticValue.id = 200;
        statisticValue.name = "Passes";
        statisticValue.value = "50";

        assertEquals(200, statisticValue.id);
        assertEquals("Passes", statisticValue.name);
        assertEquals("50", statisticValue.value);
    }

    @Test
    void testMultipleStatisticValueInstances() {
        StatisticValue stat1 = new StatisticValue();
        StatisticValue stat2 = new StatisticValue();

        stat1.id = 1;
        stat1.name = "Goals";
        stat1.value = "2";

        stat2.id = 2;
        stat2.name = "Assists";
        stat2.value = "3";

        assertEquals(1, stat1.id);
        assertEquals(2, stat2.id);
        assertNotEquals(stat1.id, stat2.id);
        assertNotEquals(stat1.name, stat2.name);
        assertNotEquals(stat1.value, stat2.value);
    }

    @Test
    void testStatisticValueFieldIndependence() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.id = 999;
        assertNull(statisticValue.name);
        assertNull(statisticValue.value);

        statisticValue.name = "Test Name";
        assertEquals(999, statisticValue.id);
        assertNull(statisticValue.value);

        statisticValue.value = "Test Value";
        assertEquals(999, statisticValue.id);
        assertEquals("Test Name", statisticValue.name);
    }

    @Test
    void testStatisticValueStringImmutability() {
        StatisticValue statisticValue = new StatisticValue();
        String originalName = "Original Name";
        String originalValue = "Original Value";

        statisticValue.name = originalName;
        statisticValue.value = originalValue;

        String retrievedName = statisticValue.name;
        String retrievedValue = statisticValue.value;

        assertEquals(originalName, retrievedName);
        assertEquals(originalValue, retrievedValue);
        assertSame(originalName, retrievedName);
        assertSame(originalValue, retrievedValue);
    }

    @Test
    void testStatisticValueWithSpecialCharacters() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.name = "Statistic with special chars: !@#$%^&*()";
        assertEquals("Statistic with special chars: !@#$%^&*()", statisticValue.name);

        statisticValue.value = "Unicode: ñáéíóú 中文";
        assertEquals("Unicode: ñáéíóú 中文", statisticValue.value);
    }

    @Test
    void testStatisticValueWithWhitespace() {
        StatisticValue statisticValue = new StatisticValue();

        statisticValue.name = "  Statistic Name  ";
        assertEquals("  Statistic Name  ", statisticValue.name);

        statisticValue.value = "  Statistic Value  ";
        assertEquals("  Statistic Value  ", statisticValue.value);

        statisticValue.name = "\tTabbed\tName\t";
        assertEquals("\tTabbed\tName\t", statisticValue.name);
    }

    @Test
    void testStatisticValueConsistency() {
        StatisticValue stat1 = new StatisticValue();
        StatisticValue stat2 = new StatisticValue();

        int testId = 123;
        String testName = "Consistency Test";
        String testValue = "Test Value";

        stat1.id = testId;
        stat1.name = testName;
        stat1.value = testValue;

        stat2.id = testId;
        stat2.name = testName;
        stat2.value = testValue;

        assertEquals(stat1.id, stat2.id);
        assertEquals(stat1.name, stat2.name);
        assertEquals(stat1.value, stat2.value);
    }
}