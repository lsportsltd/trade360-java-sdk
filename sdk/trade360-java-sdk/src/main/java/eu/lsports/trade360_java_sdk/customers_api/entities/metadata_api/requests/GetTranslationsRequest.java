package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetTranslationsRequest} record represents a request to retrieve translations based on various criteria.
 *
 * @param languages the IDs of the languages to filter by
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param leagueIds the IDs of the leagues to filter by
 * @param marketIds the IDs of the markets to filter by
 * @param participantIds the IDs of the participants to filter by
 */
public final record GetTranslationsRequest(
    Iterable<Integer> languages,
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leagueIds,
    @Nullable Iterable<Integer> marketIds,
    @Nullable Iterable<Integer> participantIds) {
}