package com.lsports.trade360_java_sdk.common.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The {@code SubscriptionState} enum represents the various states of a subscription.
 */
public enum SubscriptionState {
    /**
     * State indicating subscriptions of all states.
     */
    ALL(0),

    /**
     * State indicating subscriptions which are not subscribed.
     */
    NOT_SUBSCRIBED(1),

    /**
     * State indicating subscriptions which are subscribed.
     */
    SUBSCRIBED(2);

    private final int value;

    private SubscriptionState(int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing the subscription state.
     *
     * @return the integer value representing the subscription state
     */
    @JsonValue
    public int getValue() {
        return this.value;
    }
}
