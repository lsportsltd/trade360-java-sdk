package com.lsports.trade360_java_sdk.common.entities.enums;

/**
 * The {@code BetStatus} enum represents the various statuses a bet can have.
 */
public enum BetStatus {
    /**
     * Status indicating that the bet status is not set.
     */
    NOT_SET(1),

    /**
     * Status indicating that the bet is open.
     */
    OPEN(2),

    /**
     * Status indicating that the bet is suspended.
     */
    SUSPENDED(3),

    /**
     * Status indicating that the bet is settled.
     */
    SETTLED(4);

    private int value;

    BetStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the status.
     *
     * @return the integer value representing the status
     */
    public int getValue() {
        return this.value;
    }
}