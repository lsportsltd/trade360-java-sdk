package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SubscriptionFilterEnum {
    ALL(0),
    NOT_SUBSCRIBED(1),
    SUBSCRIBED(2);

    private final int value;

    private SubscriptionFilterEnum(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}