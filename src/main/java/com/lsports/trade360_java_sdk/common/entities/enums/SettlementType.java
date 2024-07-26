package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SettlementType {
    CANCELLED (-1),
    NOTSETTLED (0),
    LOSER (1),
    WINNER (2),
    REFUND (3),
    HALFLOST (4),
    HALFWON (5);

    private int value;

    SettlementType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
