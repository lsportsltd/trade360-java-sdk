package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSportsResponse} record represents a response containing a list of sports.
 *
 * @param sports the list of sports
 * @see SportMetadata
 */
public final record GetSportsResponse(@Nullable Iterable<SportMetadata> sports) {
}