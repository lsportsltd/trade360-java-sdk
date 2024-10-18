package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import jakarta.annotation.Nullable;

/**
 * Represents a request to subscribe/unsubscribe to specific leagues.
 *
 * @param subscriptions The subscriptions to be added/removed
 * @see LeagueSubscription
 */
public record LeagueSubscriptionRequest(@Nullable Iterable<LeagueSubscription> subscriptions) {
}