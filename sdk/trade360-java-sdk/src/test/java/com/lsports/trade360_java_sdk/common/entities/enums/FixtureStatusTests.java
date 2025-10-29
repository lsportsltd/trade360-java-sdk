package com.lsports.trade360_java_sdk.common.entities.enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixtureStatusTests {

    @Test
    public void getValue_forNotSet_returns0() {
        // Act
        int value = FixtureStatus.NOT_SET.getValue();

        // Assert
        assertEquals(0, value);
    }

    @Test
    public void getValue_forNSY_returns1() {
        // Act
        int value = FixtureStatus.NSY.getValue();

        // Assert
        assertEquals(1, value);
    }

    @Test
    public void getValue_forInProgress_returns2() {
        // Act
        int value = FixtureStatus.IN_PROGRESS.getValue();

        // Assert
        assertEquals(2, value);
    }

    @Test
    public void getValue_forFinished_returns3() {
        // Act
        int value = FixtureStatus.FINISHED.getValue();

        // Assert
        assertEquals(3, value);
    }

    @Test
    public void getValue_forCancelled_returns4() {
        // Act
        int value = FixtureStatus.CANCELLED.getValue();

        // Assert
        assertEquals(4, value);
    }

    @Test
    public void getValue_forPostponed_returns5() {
        // Act
        int value = FixtureStatus.POSTPONED.getValue();

        // Assert
        assertEquals(5, value);
    }

    @Test
    public void getValue_forInterrupted_returns6() {
        // Act
        int value = FixtureStatus.INTERRUPTED.getValue();

        // Assert
        assertEquals(6, value);
    }

    @Test
    public void getValue_forAbandoned_returns7() {
        // Act
        int value = FixtureStatus.ABANDONED.getValue();

        // Assert
        assertEquals(7, value);
    }

    @Test
    public void getValue_forLostCoverage_returns8() {
        // Act
        int value = FixtureStatus.LOST_COVERAGE.getValue();

        // Assert
        assertEquals(8, value);
    }

    @Test
    public void getValue_forAboutToStart_returns9() {
        // Act
        int value = FixtureStatus.ABOUT_TO_START.getValue();

        // Assert
        assertEquals(9, value);
    }

    @Test
    public void values_whenCalled_returnsAllStatuses() {
        // Act
        FixtureStatus[] values = FixtureStatus.values();

        // Assert
        assertEquals(10, values.length);
        assertArrayEquals(new FixtureStatus[]{
            FixtureStatus.NOT_SET,
            FixtureStatus.NSY,
            FixtureStatus.IN_PROGRESS,
            FixtureStatus.FINISHED,
            FixtureStatus.CANCELLED,
            FixtureStatus.POSTPONED,
            FixtureStatus.INTERRUPTED,
            FixtureStatus.ABANDONED,
            FixtureStatus.LOST_COVERAGE,
            FixtureStatus.ABOUT_TO_START
        }, values);
    }

    @Test
    public void valueOf_withValidName_returnsCorrectStatus() {
        // Act
        FixtureStatus status = FixtureStatus.valueOf("IN_PROGRESS");

        // Assert
        assertEquals(FixtureStatus.IN_PROGRESS, status);
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_withInvalidName_throwsException() {
        // Act
        FixtureStatus.valueOf("INVALID_STATUS");
    }

    @Test
    public void enumComparison_withSameValue_returnsTrue() {
        // Act
        boolean result = FixtureStatus.FINISHED == FixtureStatus.FINISHED;

        // Assert
        assertTrue(result);
    }

    @Test
    public void enumComparison_withDifferentValue_returnsFalse() {
        // Act
        boolean result = FixtureStatus.FINISHED == FixtureStatus.CANCELLED;

        // Assert
        assertFalse(result);
    }
}

