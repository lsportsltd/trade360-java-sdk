package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetSubscribedFixturesResponse} record represents a response containing a list of subscribed fixture IDs.
 *
 * @param fixtures the list of subscribed fixture IDs
 */
public final record GetSubscribedFixturesResponse(
    @Nullable Iterable<Integer> fixtures) {
}