package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code CompetitionType} enum represents the various types of competitions.
 */
public enum CompetitionType {
    /**
     * Type indicating that the competition type is not set.
     */
    NOT_SET(0),

    /**
     * Type indicating a track competition.
     */
    TRACK(1),

    /**
     * Type indicating a league competition.
     */
    LEAGUE(3),

    /**
     * Type indicating a season competition.
     */
    SEASON(4);

    private int value;

    private CompetitionType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the competition type.
     *
     * @return the integer value representing the competition type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
