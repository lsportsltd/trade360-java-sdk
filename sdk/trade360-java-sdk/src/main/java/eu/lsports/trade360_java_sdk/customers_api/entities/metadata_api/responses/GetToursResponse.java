package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing tours.
 */
public class GetToursResponse {
    /**
     * The collection of tours.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<TourMetadata> tours;
}


