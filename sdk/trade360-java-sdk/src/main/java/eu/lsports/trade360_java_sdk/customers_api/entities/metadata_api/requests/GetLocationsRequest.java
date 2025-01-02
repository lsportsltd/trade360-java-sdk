package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetLocationsRequest} record represents a request to retrieve locations based on various criteria.
 *
 * @param languageId the ID of the language to filter by
 */
public final record GetLocationsRequest(@Nullable Integer languageId) {

    /**
     * Constructs a new {@code GetLocationsRequest} with no specified language ID.
     */
    public GetLocationsRequest() {
        this(null);
    }
}