package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import jakarta.annotation.Nullable;

/**
 * Represents a request to subscribe / unsubscribe to specific competitions.
 *
 * @param subscriptions The subscriptions to be added / removed
 * @see CompetitionSubscription
 */
public record CompetitionSubscriptionRequest(@Nullable Iterable<CompetitionSubscription> subscriptions) {
}