package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.incidents.Incident;
import jakarta.annotation.Nullable;

/**
 * The {@code GetIncidentsResponse} record represents a response containing a list of incidents.
 *
 * @param data the list of incidents
 * @see Incident
 */
public record GetIncidentsResponse(
        @Nullable Iterable<Incident> data) {
}
