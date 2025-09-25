package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code CourtSurface} enum represents the various types of court surfaces.
 */
public enum CourtSurface {
    /**
     * Surface indicating grass court.
     */
    GRASS(0),

    /**
     * Surface indicating hard court.
     */
    HARD(1),

    /**
     * Surface indicating clay court.
     */
    CLAY(2),

    /**
     * Surface indicating artificial grass court.
     */
    ARTIFICIAL_GRASS(3);

    private final int value;

    CourtSurface(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the court surface.
     *
     * @return the integer value representing the court surface
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
