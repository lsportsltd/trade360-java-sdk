package com.lsports.trade360_java_sdk.common.entities.enums;

public enum FixtureStatus {
    NotSet (0),
    NSY (1),
    InProgress (2),
    Finished (3),
    Cancelled (4),
    Postponed (5),
    Interrupted (6),
    Abandoned (7),
    LostCoverage (8),
    AboutToStart (9);

    private int value;

    FixtureStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
