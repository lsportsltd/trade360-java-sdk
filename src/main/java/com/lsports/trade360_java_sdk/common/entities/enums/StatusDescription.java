package com.lsports.trade360_java_sdk.common.entities.enums;

public enum StatusDescription {
    NONE (0),
    HT (1),
    OTHT (2),
    HOMERETIRED (3),
    AWAYRETIRED (4),
    LOSTCOVERAGE (5),
    MEDICALTIMEOUT (6),
    TIMEOUTHOMETEAM (7),
    TIMEOUTAWAYTEAM (8),
    TIMEOUT (9),
    HOMEWALKOVER (10),
    AWAYWALKOVER (11);

    private int value;

    StatusDescription(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
