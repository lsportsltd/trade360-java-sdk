package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing states.
 */
public class GetStatesResponse {
    /**
     * The collection of states.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<StateMetadata> data;
}
