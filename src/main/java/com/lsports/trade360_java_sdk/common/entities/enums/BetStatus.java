package com.lsports.trade360_java_sdk.common.entities.enums;

public enum BetStatus {
    NOTSET(1),
    OPEN(2),
    SUSPENDED(3),
    SETTLED(4);

    private int value;

    BetStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}