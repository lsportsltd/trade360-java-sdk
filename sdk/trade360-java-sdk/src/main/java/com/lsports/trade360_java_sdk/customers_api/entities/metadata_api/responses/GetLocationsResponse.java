package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetLocationsResponse} record represents a response containing a list of locations.
 *
 * @param locations the list of locations
 * @see LocationMetadata
 */
public final record GetLocationsResponse(@Nullable Iterable<LocationMetadata> locations) {
}