package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a collection response for competition subscriptions.
 */
public class CompetitionSubscriptionCollectionResponse {
    /**
     * The competition subscriptions.
     *
     * @see CompetitionSubscriptionResponse
     */
    @Nullable public Iterable<CompetitionSubscriptionResponse> subscription;
}