package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code PackageType} enum represents the various types of packages.
 */
public enum PackageType {
    /**
     * Type indicating an in-play package.
     */
    INPLAY(1),

    /**
     * Type indicating a pre-match package.
     */
    PREMATCH(2);

    private int value;

    PackageType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the package type.
     *
     * @return the integer value representing the package type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
