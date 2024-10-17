package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.FixtureSubscription;
import jakarta.annotation.Nullable;

/**
 * Represents a collection response for fixture subscriptions.
 */
public class FixtureSubscriptionCollectionResponse {
    /**
     * The fixture subscriptions.
     *
     * @see FixtureSubscription
     */
    @Nullable public Iterable<FixtureSubscription> fixtures;
}