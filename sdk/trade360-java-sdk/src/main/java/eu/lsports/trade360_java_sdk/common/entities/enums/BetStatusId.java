package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code BetStatusId} enum represents the various statuses a bet can have.
 */
public enum BetStatusId {
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
    SETTLED(3),

    /**
     * Status indicating that the bet is closed.
     */
    CLOSED(4);

    private int value;

    BetStatusId(int value) {
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
