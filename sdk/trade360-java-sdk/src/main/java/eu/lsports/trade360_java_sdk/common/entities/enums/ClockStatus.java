package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code ClockStatus} enum represents the various statuses of a clock.
 */
public enum ClockStatus {
    /**
     * Status indicating the clock is stopped.
     */
    STOPPED(0),

    /**
     * Status indicating the clock is running.
     */
    RUNNING(1),

    /**
     * Status indicating the clock is paused.
     */
    PAUSED(2);

    private int value;

    ClockStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the clock status
     *
     * @return the integer value representing the clock status
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
