package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing cities.
 */
public class GetCitiesResponse {
    /**
     * The collection of cities.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<CityMetadata> data;
}
