package eu.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Trade360 market-level status (distinct from bet {@link BetStatus}).
 */
public enum MarketStatus {
    NOT_SET(0),
    OPEN(1),
    SUSPENDED(2),
    SETTLED(3);

    private final int value;

    MarketStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
