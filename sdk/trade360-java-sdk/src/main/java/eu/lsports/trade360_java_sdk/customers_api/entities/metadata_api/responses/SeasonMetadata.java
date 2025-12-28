package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code SeasonMetadata} record represents metadata for a season.
 *
 * @param seasonId the ID of the season
 * @param seasonName the name of the season
 */
public final record SeasonMetadata(int seasonId, @Nullable String seasonName) {
}


