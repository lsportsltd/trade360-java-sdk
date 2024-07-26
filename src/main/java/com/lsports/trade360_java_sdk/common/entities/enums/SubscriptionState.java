package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SubscriptionState {

    NOTSUBSCRIBED (1),
    SUBSCRIBED (2);

    private int value;

    SubscriptionState(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
