package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

/**
 * Represents a request to get the schedule of fixtures.
 *
 * @param sportIds The IDs of the sports
 * @param locationIds The IDs of the locations
 * @param leagueIds The IDs of the leagues
 */
public record GetFixtureScheduleRequest(
    Iterable<Integer> sportIds,
    Iterable<Integer> locationIds,
    Iterable<Integer> leagueIds) {
}