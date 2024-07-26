package com.lsports.trade360_java_sdk.common.entities.enums;

public enum FixtureStatus {
    NOTSET (0),
    NSY (1),
    INPROGRESS (2),
    FINISHED (3),
    CANCELLED (4),
    POSTPONED (5),
    INTERRUPTED (6),
    ABANDONED (7),
    LOSTCOVERAGE (8),
    ABOUTTOSTART (9);

    private int value;

    FixtureStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
