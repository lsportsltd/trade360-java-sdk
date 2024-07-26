package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SubscriptionStatus {

    NOTSET (0),
    SUBSCRIBED (1),
    PENDING (2),
    UNSUBSCRIBED (3),
    DELETED (4);

    private int value;

    SubscriptionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
