package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SettlementType {
    Cancelled (-1),
    NotSettled (0),
    Loser (1),
    Winner (2),
    Refund (3),
    HalfLost (4),
    HalfWon (5);

    private int value;

    SettlementType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
