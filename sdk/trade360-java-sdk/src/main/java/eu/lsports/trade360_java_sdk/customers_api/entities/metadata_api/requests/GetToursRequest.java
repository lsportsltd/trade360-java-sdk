package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetToursRequest} record represents a request to retrieve Tours based on various criteria.
 *
 * @param tourId optional filter by tour ID
 * @param sportId optional filter by sport ID
 */
public final record GetToursRequest(@Nullable Integer tourId, @Nullable Integer sportId) {
    /**
     * Creates a new {@code GetToursRequest} with no filters.
     */
    public GetToursRequest() {
        this(null, null);
    }
}


