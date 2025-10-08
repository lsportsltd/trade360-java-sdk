package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code VenueAssignment} enum represents the various types of venue assignments.
 */
public enum VenueAssignment {
    /**
     * Assignment indicating home venue.
     */
    HOME(0),

    /**
     * Assignment indicating away venue.
     */
    AWAY(1),

    /**
     * Assignment indicating neutral venue.
     */
    NEUTRAL(2);

    private final int value;

    VenueAssignment(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the venue assignment.
     *
     * @return the integer value representing the venue assignment
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
