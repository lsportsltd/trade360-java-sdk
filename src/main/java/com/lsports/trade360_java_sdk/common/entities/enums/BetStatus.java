package com.lsports.trade360_java_sdk.common.entities.enums;

enum BetStatus {
    NotSet(1),
    Open(2),
    Suspended(3),
    Settled(4);

    private int value;

    BetStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}