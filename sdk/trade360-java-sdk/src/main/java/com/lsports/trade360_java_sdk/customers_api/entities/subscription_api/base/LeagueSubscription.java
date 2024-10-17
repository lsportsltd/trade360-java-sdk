package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

/**
 * Represents a subscription to a specific league.
 *
 * @param sportId the ID of the sport
 * @param locationId the ID of the location
 * @param leagueId the ID of the league
 */
public record LeagueSubscription(int sportId, int locationId, int leagueId) {
}