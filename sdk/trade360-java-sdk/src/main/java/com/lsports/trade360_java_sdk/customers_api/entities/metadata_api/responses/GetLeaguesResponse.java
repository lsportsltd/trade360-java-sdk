package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetLeaguesResponse} record represents a response containing a list of leagues.
 *
 * @param leagues the list of leagues
 * @see LeagueMetadata
 */
public final record GetLeaguesResponse(@Nullable Iterable<LeagueMetadata> leagues) {
}