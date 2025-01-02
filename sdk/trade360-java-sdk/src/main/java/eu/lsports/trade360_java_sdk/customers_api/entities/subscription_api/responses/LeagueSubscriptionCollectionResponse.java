package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a collection response for league subscriptions.
 */
public class LeagueSubscriptionCollectionResponse {
    /**
     * The league subscriptions.
     *
     * @see LeagueSubscriptionResponse
     */
    @Nullable public Iterable<LeagueSubscriptionResponse> subscription;
}