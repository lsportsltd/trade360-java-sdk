package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response containing participants.
 */
public class GetParticipantsResponse {
    /**
     * The collection of participants.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<ParticipantMetadata> data;

    /**
     * The total number of items matching the filter across all pages.
     */
    public int totalItems;
}

