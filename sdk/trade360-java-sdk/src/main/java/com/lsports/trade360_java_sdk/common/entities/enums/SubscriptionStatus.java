package com.lsports.trade360_java_sdk.common.entities.enums;

/**
 * The {@code SubscriptionStatus} enum represents the various statuses of a subscription.
 */
public enum SubscriptionStatus {

    /**
     * Status indicating that the subscription status is not set.
     */
    NOT_SET(0),

    /**
     * Status indicating that the subscription is subscribed.
     */
    SUBSCRIBED(1),

    /**
     * Status indicating that the subscription is pending.
     */
    PENDING(2),

    /**
     * Status indicating that the subscription is unsubscribed.
     */
    UNSUBSCRIBED(3),

    /**
     * Status indicating that the subscription is deleted.
     */
    DELETED(4);

    private int value;

    SubscriptionStatus(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the subscription status.
     *
     * @return the integer value representing the subscription status
     */
    public int getValue() {
        return this.value;
    }
}
