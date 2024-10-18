package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

/**
 * Represents a subscription to a specific competition.
 *
 * @param sportId the ID of the sport
 * @param locationId the ID of the location
 * @param competitionId the ID of the competition
 */
public record CompetitionSubscription(int sportId, int locationId, int competitionId) {
}