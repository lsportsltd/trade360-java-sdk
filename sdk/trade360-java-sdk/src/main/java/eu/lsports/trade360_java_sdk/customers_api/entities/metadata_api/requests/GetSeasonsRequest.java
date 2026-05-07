package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSeasonsRequest} record represents a request to retrieve Seasons based on various criteria.
 *
 * @param seasonId optional filter by season ID
 */
public final record GetSeasonsRequest(@Nullable Integer seasonId) {
    /**
     * Creates a new {@code GetSeasonsRequest} with no filters.
     */
    public GetSeasonsRequest() {
        this(null);
    }
}


