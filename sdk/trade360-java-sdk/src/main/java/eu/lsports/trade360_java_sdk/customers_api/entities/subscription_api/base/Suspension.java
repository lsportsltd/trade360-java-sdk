package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * Represents a suspension in the subscription API.
 *
 * @param succeeded Indicates whether the suspension was successful
 * @param sportId The ID of the sport
 * @param locationId The ID of the location, nullable to handle missing values
 * @param competitionId The ID of the competition
 * @param fixtureId The ID of the fixture, nullable to handle missing values
 * @param creationDate The creation date of the suspension in UTC
 * @param markets The markets associated with the suspension
 */
public record Suspension(
    Boolean succeeded,
    int sportId,
    @Nullable Integer locationId,
    int competitionId,
    @Nullable Integer fixtureId,
    LocalDateTime creationDate,
    @Nullable Iterable<Market> markets) {
}