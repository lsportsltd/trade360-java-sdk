package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetCitiesRequest} record represents a request to retrieve Cities based on various criteria.
 *
 * @param filter object containing the relevant request filters
 * @see GetCitiesRequest.CitiesFilter
 */
public final record GetCitiesRequest(CitiesFilter filter) {

    /**
     * The {@code CitiesFilter} record represents a request filters in order retrieve Cities based on various criteria.
     *
     * @param states The IDs of the states to filter cities by
     * @param countries The IDs of the countries to filter cities by
     */
    public final record CitiesFilter(
            @Nullable Iterable<Integer> states,
            @Nullable Iterable<Integer> countries){
    }
}

