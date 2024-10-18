package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code MarketType} enum represents the various types of markets.
 */
public enum MarketType {
    /**
     * Type indicating all types of markets.
     */
    ALL(0),

    /**
     * Type indicating standard markets.
     */
    STANDARD(1),

    /**
     * Type indicating outright markets.
     */
    OUTRIGHT(2);

    private int value;

    MarketType(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the market type.
     *
     * @return the integer value representing the market type
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}