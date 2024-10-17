package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents the response for getting subscriptions.
 */
public class GetSubscriptionResponse {
    /**
     * The IDs of the fixtures.
     */
    @Nullable public Iterable<Integer> fixtures;
}