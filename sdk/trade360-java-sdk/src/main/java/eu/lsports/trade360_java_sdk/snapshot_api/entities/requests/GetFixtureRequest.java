package eu.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * Represents a request to get a snapshot of data.
 *
 * @param timestamp The timestamp of the snapshot in UTC
 * @param fromDate The start date for the snapshot in UTC
 * @param toDate The end date for the snapshot in UTC
 * @param sports The IDs of the sports
 * @param locations The IDs of the locations
 * @param leagues The IDs of the leagues
 * @param fixtures The IDs of the fixtures
 */
public final record GetFixtureRequest(
    @Nullable LocalDateTime timestamp,
    @Nullable LocalDateTime fromDate,
    @Nullable LocalDateTime toDate,
    @Nullable Iterable<Integer> sports,
    @Nullable Iterable<Integer> locations,
    @Nullable Iterable<Integer> leagues,
    @Nullable Iterable<Integer> fixtures) {
}