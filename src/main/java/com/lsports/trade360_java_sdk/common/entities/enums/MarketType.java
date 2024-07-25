package com.lsports.trade360_java_sdk.common.entities.enums;

public enum MarketType {
    All(0),
    Standard(1),
    Outright(2);

    private int value;

    MarketType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}