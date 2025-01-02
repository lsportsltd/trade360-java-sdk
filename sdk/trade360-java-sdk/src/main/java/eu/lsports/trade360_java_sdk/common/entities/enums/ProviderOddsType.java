package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code ProviderOddsType} enum represents the various types of provider odds.
 */
public enum ProviderOddsType {
    /**
     * Type of trade360 customer
     */
    AVERAGE(1),

    /**
     * Type of OS customer
     */
    PROVIDER_ODDS(2),

    /**
     * both OS and Trade360 customer
     */
    BOTH(3);

    private int value;

    ProviderOddsType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the provider odds type.
     *
     * @return the integer value representing the provider odds type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}