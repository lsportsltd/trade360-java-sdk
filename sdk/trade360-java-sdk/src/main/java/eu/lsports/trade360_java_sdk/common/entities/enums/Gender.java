package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code Gender} enum represents the gender categories for participants.
 */
public enum Gender {
    /**
     * Gender indicating men.
     */
    MEN(1),

    /**
     * Gender indicating women.
     */
    WOMEN(2),

    /**
     * Gender indicating mixed.
     */
    MIX(3);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the gender.
     *
     * @return the integer value representing the gender
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}

