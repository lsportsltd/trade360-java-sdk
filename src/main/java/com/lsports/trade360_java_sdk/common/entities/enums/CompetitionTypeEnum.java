package com.lsports.trade360_java_sdk.common.entities.enums;

enum CompetitionTypeEnum {
    NotSet (0),
    Track (1),
    League (3),
    Season (4);

    private int value;

    private CompetitionTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
