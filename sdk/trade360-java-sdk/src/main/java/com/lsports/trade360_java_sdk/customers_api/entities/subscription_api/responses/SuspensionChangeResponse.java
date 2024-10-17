package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.SuspendedMarket;
import jakarta.annotation.Nullable;

/**
 * Represents the response for a suspension change.
 */
public class SuspensionChangeResponse {

    /**
     * Indicates whether the suspension change was successful.
     */
    public Boolean succeeded;

    /**
     * The reason for the suspension change, if any.
     */
    @Nullable public String reason;

    /**
     * The ID of the fixture, if applicable.
     */
    @Nullable public Integer fixtureId;

    /**
     * The markets associated with the suspension change.
     *
     * @see SuspendedMarket
     */
    @Nullable public Iterable<SuspendedMarket> markets;
}