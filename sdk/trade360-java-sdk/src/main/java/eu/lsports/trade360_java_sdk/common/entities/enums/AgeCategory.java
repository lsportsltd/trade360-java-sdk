package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code AgeCategory} enum represents the age categories for participants.
 */
public enum AgeCategory {
    /**
     * Age category indicating regular participants.
     */
    REGULAR(0),

    /**
     * Age category indicating youth participants.
     */
    YOUTH(1),

    /**
     * Age category indicating reserves.
     */
    RESERVES(2);

    private int value;

    AgeCategory(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the age category.
     *
     * @return the integer value representing the age category
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}

