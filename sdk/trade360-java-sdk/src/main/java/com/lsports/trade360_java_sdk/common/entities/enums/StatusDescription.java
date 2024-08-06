package com.lsports.trade360_java_sdk.common.entities.enums;

public enum StatusDescription {
    NONE (0),
    HT (1),
    OTHT (2),
    HOME_RETIRED (3),
    AWAY_RETIRED (4),
    LOST_COVERAGE (5),
    MEDICAL_TIMEOUT (6),
    TIMEOUT_HOME_TEAM (7),
    TIMEOUT_AWAY_TEAM (8),
    TIMEOUT (9),
    HOME_WALKOVER (10),
    AWAY_WALKOVER (11);

    private int value;

    StatusDescription(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
