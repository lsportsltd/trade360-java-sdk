package eu.lsports.trade360_java_sdk.common.entities.shared;

import eu.lsports.trade360_java_sdk.common.entities.enums.SubscriptionStatus;

/**
 * The {@code Subscription} class represents a subscription.
 */
public class Subscription {

    /**
     * The type of the subscription.
     */
    public int type;

    /**
     * The status of the subscription.
     */
    public SubscriptionStatus status;
}