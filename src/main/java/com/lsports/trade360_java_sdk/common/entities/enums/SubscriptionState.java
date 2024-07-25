package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SubscriptionState {

    NotSubscribed (1),
    Subscribed (2);

    private int value;

    SubscriptionState(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
