package com.lsports.trade360_java_sdk.common.entities.enums;

public enum SubscriptionStatus {
    NotSet (0),
    Subscribed (1),
    Pending (2),
    Unsubscribed (3),
    Deleted (4);

    private int value;

    SubscriptionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
