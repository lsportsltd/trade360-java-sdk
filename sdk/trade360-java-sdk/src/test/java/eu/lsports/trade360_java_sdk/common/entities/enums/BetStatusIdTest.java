package eu.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BetStatusIdTest {

    @Test
    void testValuesAreOneThroughFour() {
        assertEquals(1, BetStatusId.OPEN.getValue());
        assertEquals(2, BetStatusId.SUSPENDED.getValue());
        assertEquals(3, BetStatusId.SETTLED.getValue());
        assertEquals(4, BetStatusId.CLOSED.getValue());
        assertEquals(4, BetStatusId.values().length);
    }

    @ParameterizedTest
    @CsvSource({
        "1, OPEN",
        "2, SUSPENDED",
        "3, SETTLED",
        "4, CLOSED"
    })
    void testFromValue(int value, BetStatusId expected) {
        assertEquals(expected, BetStatusId.fromValue(value));
    }

    @Test
    void testFromValueRejectsZero() {
        assertThrows(IllegalArgumentException.class, () -> BetStatusId.fromValue(0));
    }
}
