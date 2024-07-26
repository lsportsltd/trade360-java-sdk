package com.lsports.trade360_java_sdk.common.entities.enums;

public enum CompetitionType {
    NOTSET (0),
    TRACK (1),
    LEAGUE (3),
    SEASON (4);

    private int value;

    private CompetitionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
