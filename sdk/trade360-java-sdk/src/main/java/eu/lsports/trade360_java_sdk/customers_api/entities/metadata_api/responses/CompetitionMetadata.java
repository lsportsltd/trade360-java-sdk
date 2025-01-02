package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code CompetitionMetadata} record represents metadata for a competition.
 *
 * @param id the ID of the competition
 * @param name the name of the competition
 * @param type the type of the competition
 * @param trackId the track ID associated with the competition
 */
public final record CompetitionMetadata(
    int id,
    @Nullable String name,
    int type,
    int trackId) {
}