package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code DangerIndicatorType} enum represents the various types of danger indicators.
 */
public enum DangerIndicatorType {
    /**
     * Type of general danger indicator
     */
    GENERAL(1),

    /**
     * Type of cards danger indicator
     */
    CARDS(2),

    /**
     * Type of cards corners indicator
     */
    CORNERS(3);

    private int value;

    DangerIndicatorType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the danger type
     *
     * @return the integer value representing the danger type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}