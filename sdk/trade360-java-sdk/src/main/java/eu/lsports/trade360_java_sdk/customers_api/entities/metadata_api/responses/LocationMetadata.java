package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code LocationMetadata} record represents metadata for a location.
 *
 * @param id the ID of the location
 * @param name the name of the location
 */
public final record LocationMetadata(int id, @Nullable String name) {
}