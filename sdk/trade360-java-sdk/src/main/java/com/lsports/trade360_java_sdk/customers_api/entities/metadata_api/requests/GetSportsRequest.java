package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSportsRequest} record represents a request to retrieve sports based on various criteria.
 *
 * @param languageId the ID of the language to filter by
 */
public final record GetSportsRequest(@Nullable Integer languageId) {

    /**
     * Constructs a new {@code GetSportsRequest} with no specified language ID.
     */
    public GetSportsRequest() {
        this(null);
    }
}