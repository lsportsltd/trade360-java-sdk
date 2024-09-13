package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionState {

    ALL(0),
    NOT_SUBSCRIBED (1),
    SUBSCRIBED (2);

    private final int value;

    private SubscriptionState(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }
}
