package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing venues.
 */
public class GetVenuesResponse {
    /**
     * The collection of venues.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<VenueMetadata> data;
}
