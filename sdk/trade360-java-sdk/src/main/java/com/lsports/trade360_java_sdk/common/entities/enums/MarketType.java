package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MarketType {
    ALL(0),
    STANDARD(1),
    OUTRIGHT(2);

    private int value;

    MarketType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }
}