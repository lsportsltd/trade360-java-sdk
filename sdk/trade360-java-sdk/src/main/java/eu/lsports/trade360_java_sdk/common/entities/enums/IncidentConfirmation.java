package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code IncidentConfirmation} enum represents the various incident confirmation statuses.
 */
public enum IncidentConfirmation {
    /**
     * Confirmed incident status indicator
     */
    CONFIRMED(0),

    /**
     * TBD incident status indicator
     */
    TBD(1),

    /**
     * Cancelled incident status indicator
     */
    CANCELLED(2);


    private int value;

    IncidentConfirmation(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the incident confirmation status
     *
     * @return the integer value representing the incident confirmation status
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}