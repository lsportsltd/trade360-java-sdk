package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSubscribedFixturesMetadataRequest} record represents a request to retrieve metadata for subscribed fixtures based on date range criteria.
 *
 * @param fromDate the start date to filter by
 * @param toDate the end date to filter by
 * @see LocalDate
 *  * @param sportIds the IDs of the sports to filter by
 *  * @param locationIds the IDs of the locations to filter by
 *  * @param leagueIds the IDs of the leagues to filter by
 */
public final record GetSubscribedFixturesMetadataRequest(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate fromDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate toDate,
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Integer languageId)

{
}