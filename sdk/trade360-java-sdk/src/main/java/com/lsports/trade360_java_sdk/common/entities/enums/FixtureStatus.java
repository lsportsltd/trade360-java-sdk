package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code FixtureStatus} enum represents the various statuses a fixture can have.
 */
public enum FixtureStatus {
    /**
     * Status indicating that the fixture status is not set.
     */
    NOT_SET(0),

    /**
     * Status indicating that the fixture is not yet started.
     */
    NSY(1),

    /**
     * Status indicating that the fixture is in progress.
     */
    IN_PROGRESS(2),

    /**
     * Status indicating that the fixture is finished.
     */
    FINISHED(3),

    /**
     * Status indicating that the fixture is cancelled.
     */
    CANCELLED(4),

    /**
     * Status indicating that the fixture is postponed.
     */
    POSTPONED(5),

    /**
     * Status indicating that the fixture is interrupted.
     */
    INTERRUPTED(6),

    /**
     * Status indicating that the fixture is abandoned.
     */
    ABANDONED(7),

    /**
     * Status indicating that the fixture has lost coverage.
     */
    LOST_COVERAGE(8),

    /**
     * Status indicating that the fixture is about to start.
     */
    ABOUT_TO_START(9);

    private int value;

    FixtureStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the fixture status.
     *
     * @return the integer value representing the fixture status
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
