package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code BetStatus} enum represents the various statuses a bet can have.
 */
public enum BetStatus {
    /**
     * Status indicating that the bet status is not set.
     */
    NOT_SET(0),

    /**
     * Status indicating that the bet is open.
     */
    OPEN(1),

    /**
     * Status indicating that the bet is suspended.
     */
    SUSPENDED(2),

    /**
     * Status indicating that the bet is settled.
     */
    SETTLED(3);

    private int value;

    BetStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the status.
     *
     * @return the integer value representing the status
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}