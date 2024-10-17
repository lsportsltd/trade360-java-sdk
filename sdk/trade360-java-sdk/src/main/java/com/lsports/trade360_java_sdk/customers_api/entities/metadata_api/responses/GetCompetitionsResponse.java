package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetCompetitionsResponse} record represents a response containing a list of competitions.
 *
 * @param competitions the list of competitions
 * @see CompetitionMetadata
 */
public final record GetCompetitionsResponse(
    @Nullable Iterable<CompetitionMetadata> competitions) {
}