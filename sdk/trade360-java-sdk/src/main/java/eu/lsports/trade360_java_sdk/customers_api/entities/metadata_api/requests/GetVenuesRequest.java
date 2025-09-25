package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetVenuesRequest} record represents a request to retrieve Venues based on various criteria.
 *
 * @param filter object containing the relevant request filters
 * @see GetVenuesRequest.VenuesFilter
 */
public final record GetVenuesRequest(VenuesFilter filter) {
    /**
     * The {@code VenuesFilter} record represents a request filters in order retrieve Venues based on various criteria.
     *
     * @param sports The IDs of the sports to filter venues by
     * @param locations The IDs of the locations to filter venues by
     * @param cities The IDs of the cities to filter venues by
     * @param states The IDs of the states to filter venues by
     * @param countries The IDs of the countries to filter venues by
     */
    public final record VenuesFilter(
            @Nullable Iterable<Integer> sports,
            @Nullable Iterable<Integer> locations,
            @Nullable Iterable<Integer> cities,
            @Nullable Iterable<Integer> states,
            @Nullable Iterable<Integer> countries){
    }
}

