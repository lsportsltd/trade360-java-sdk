package com.lsports.trade360_java_sdk.common.entities.enums;

public enum FixtureStatus {
    NOT_SET (0),
    NSY (1),
    IN_PROGRESS (2),
    FINISHED (3),
    CANCELLED (4),
    POSTPONED (5),
    INTERRUPTED (6),
    ABANDONED (7),
    LOST_COVERAGE (8),
    ABOUT_TO_START (9);

    private int value;

    FixtureStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
