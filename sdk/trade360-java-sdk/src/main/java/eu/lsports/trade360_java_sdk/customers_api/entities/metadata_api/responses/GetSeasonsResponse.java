package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing seasons.
 */
public class GetSeasonsResponse {
    /**
     * The collection of seasons.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<SeasonMetadata> seasons;
}


