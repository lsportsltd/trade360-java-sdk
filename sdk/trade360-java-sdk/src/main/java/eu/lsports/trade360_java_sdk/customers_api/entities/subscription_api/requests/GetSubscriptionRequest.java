package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import jakarta.annotation.Nullable;

/**
 * Represents a request to get subscriptions.
 *
 * @param sportIds The IDs of the sports
 * @param locationIds The IDs of the locations
 * @param leagueIds The IDs of the leagues
 */
public record GetSubscriptionRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leagueIds) {
}