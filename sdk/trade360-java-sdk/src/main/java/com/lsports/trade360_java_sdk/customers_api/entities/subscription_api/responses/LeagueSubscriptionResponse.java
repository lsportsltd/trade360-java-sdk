package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a response for a league subscription.
 */
public class LeagueSubscriptionResponse {
    /**
     * The ID of the league.
     */
    @Nullable
    public int leagueId;

    /**
     * The ID of the sport.
     */
    @Nullable
    public int sportId;

    /**
     * The ID of the location.
     */
    @Nullable
    public int locationId;

    /**
     * Indicates whether the subscription was successful.
     */
    public Boolean success;

    /**
     * Indicates whether the subscription was successful.
     */
    @Nullable
    public String message;
}