package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

/**
 * Represents a response for a league subscription.
 */
public class LeagueSubscriptionResponse {
    /**
     * The ID of the league.
     */
    public int leagueId;

    /**
     * The ID of the sport.
     */
    public int sportId;

    /**
     * The ID of the location.
     */
    public int locationId;

    /**
     * Indicates whether the subscription was successful.
     */
    public Boolean success;
}