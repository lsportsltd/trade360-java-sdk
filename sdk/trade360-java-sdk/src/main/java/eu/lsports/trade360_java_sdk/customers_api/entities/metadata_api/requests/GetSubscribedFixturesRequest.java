package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSubscribedFixturesRequest} record represents a request to retrieve subscribed fixtures based on various criteria.
 *
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param leagueIds the IDs of the leagues to filter by
 */
public final record GetSubscribedFixturesRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leagueIds) {
}