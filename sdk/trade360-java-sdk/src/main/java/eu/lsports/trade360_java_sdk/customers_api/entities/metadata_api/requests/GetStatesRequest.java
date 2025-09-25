package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

/**
 * The {@code GetStatesRequest} record represents a request to retrieve Countries based on various criteria.
 *
 * @param filter object containing the relevant request filters
 * @see GetStatesRequest.CountriesFilter
 */
public final record GetStatesRequest(CountriesFilter filter) {

    /**
     * The {@code CountriesFilter} record represents a request filters in order retrieve Countries based on various criteria.
     *
     * @param countries The IDs of the countries to filter by
     */
    public final record CountriesFilter(
            @Nullable Iterable<Integer> countries){
    }
}

