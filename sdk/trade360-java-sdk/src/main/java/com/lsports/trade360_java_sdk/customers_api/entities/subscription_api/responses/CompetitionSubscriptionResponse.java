package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

/**
 * Represents a response for a competition subscription.
 */
public class CompetitionSubscriptionResponse {
    /**
     * The ID of the competition.
     */
    public int competitionId;

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