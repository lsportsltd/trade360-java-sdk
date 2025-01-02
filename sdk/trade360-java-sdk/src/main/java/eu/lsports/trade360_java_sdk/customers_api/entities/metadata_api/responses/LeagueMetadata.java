package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code LeagueMetadata} record represents metadata for a league.
 *
 * @param id the ID of the league
 * @param name the name of the league
 * @param season the season of the league
 * @param sportId the ID of the sport associated with the league
 * @param locationId the ID of the location associated with the league
 */
public final record LeagueMetadata(
    int id,
    @Nullable String name,
    @Nullable String season,
    int sportId,
    int locationId) {
}