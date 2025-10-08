package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code VenueEnvironment} enum represents the various types of venue environments.
 */
public enum VenueEnvironment {
    /**
     * Environment indicating indoors venue.
     */
    INDOORS(0),

    /**
     * Environment indicating outdoors venue.
     */
    OUTDOORS(1);

    private final int value;

    VenueEnvironment(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the venue environment.
     *
     * @return the integer value representing the venue environment
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
