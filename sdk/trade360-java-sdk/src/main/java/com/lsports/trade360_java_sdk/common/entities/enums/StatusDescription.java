package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code StatusDescription} enum represents the various status descriptions.
 */
public enum StatusDescription {
    /**
     * Status indicating none.
     */
    NONE(0),

    /**
     * Status indicating half-time.
     */
    HT(1),

    /**
     * Status indicating overtime half-time.
     */
    OTHT(2),

    /**
     * Status indicating home team retired.
     */
    HOME_RETIRED(3),

    /**
     * Status indicating away team retired.
     */
    AWAY_RETIRED(4),

    /**
     * Status indicating lost coverage.
     */
    LOST_COVERAGE(5),

    /**
     * Status indicating medical timeout.
     */
    MEDICAL_TIMEOUT(6),

    /**
     * Status indicating timeout for home team.
     */
    TIMEOUT_HOME_TEAM(7),

    /**
     * Status indicating timeout for away team.
     */
    TIMEOUT_AWAY_TEAM(8),

    /**
     * Status indicating timeout.
     */
    TIMEOUT(9),

    /**
     * Status indicating home team walkover.
     */
    HOME_WALKOVER(10),

    /**
     * Status indicating away team walkover.
     */
    AWAY_WALKOVER(11);

    private int value;

    StatusDescription(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the status description.
     *
     * @return the integer value representing the status description
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
