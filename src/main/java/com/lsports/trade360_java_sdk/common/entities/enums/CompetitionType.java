package com.lsports.trade360_java_sdk.common.entities.enums;

public enum CompetitionType {
    NotSet (0),
    Track (1),
    League (3),
    Season (4);

    private int value;

    private CompetitionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
