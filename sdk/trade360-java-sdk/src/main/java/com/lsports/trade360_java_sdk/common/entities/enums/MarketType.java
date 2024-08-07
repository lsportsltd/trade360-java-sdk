package com.lsports.trade360_java_sdk.common.entities.enums;

public enum MarketType {
    ALL(0),
    STANDARD(1),
    OUTRIGHT(2);

    private int value;

    MarketType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}