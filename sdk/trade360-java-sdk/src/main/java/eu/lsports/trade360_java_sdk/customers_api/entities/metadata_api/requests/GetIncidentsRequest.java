package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code GetIncidentsRequest} record represents a request to retrieve Incidents based on various criteria.
 *
 * @param filter object containing the relevant request filters
 * @see IncidentsFilter
 */
public final record GetIncidentsRequest(IncidentsFilter filter) {

    /**
     * The {@code IncidentsFilter} record represents a request filters in order retrieve Incidents based on various criteria.
     *
     * @param ids the IDs of the incident to filter by
     * @param sports the IDs of the sports to filter by
     * @param searchText a textual search term of the incident name to filter by
     * @param from an incident creation date to filter by
     */
    public final record IncidentsFilter (
            @Nullable Iterable<Integer> ids,
            @Nullable Iterable<Integer> sports,
            @Nullable String searchText,
            @Nullable LocalDateTime from){
    }
}