package com.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class BetStatusTests {

    @Test
    public void getValue_forNotSet_returns1() {
        // Act
        int value = BetStatus.NOT_SET.getValue();

        // Assert
        assertEquals(1, value);
    }

    @Test
    public void getValue_forOpen_returns2() {
        // Act
        int value = BetStatus.OPEN.getValue();

        // Assert
        assertEquals(2, value);
    }

    @Test
    public void getValue_forSuspended_returns3() {
        // Act
        int value = BetStatus.SUSPENDED.getValue();

        // Assert
        assertEquals(3, value);
    }

    @Test
    public void getValue_forSettled_returns4() {
        // Act
        int value = BetStatus.SETTLED.getValue();

        // Assert
        assertEquals(4, value);
    }

    @Test
    public void values_whenCalled_returnsAllStatuses() {
        // Act
        BetStatus[] values = BetStatus.values();

        // Assert
        assertEquals(4, values.length);
        assertArrayEquals(new BetStatus[]{
            BetStatus.NOT_SET,
            BetStatus.OPEN,
            BetStatus.SUSPENDED,
            BetStatus.SETTLED
        }, values);
    }

    @Test
    public void valueOf_withValidName_returnsCorrectStatus() {
        // Act
        BetStatus status = BetStatus.valueOf("OPEN");

        // Assert
        assertEquals(BetStatus.OPEN, status);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_withInvalidName_throwsException() {
        // Act
        BetStatus.valueOf("INVALID");
    }

    @Test
    public void enumComparison_withSameValue_returnsTrue() {
        // Act
        boolean result = BetStatus.OPEN == BetStatus.OPEN;

        // Assert
        assertTrue(result);
    }

    @Test
    public void enumComparison_withDifferentValue_returnsFalse() {
        // Act
        boolean result = BetStatus.OPEN == BetStatus.SUSPENDED;

        // Assert
        assertFalse(result);
    }
}

