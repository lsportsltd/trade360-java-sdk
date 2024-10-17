package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

/**
 * Represents a suspended market in the subscription API.
 */
public class SuspendedMarket {
    /**
     * The ID of the market.
     */
    public int marketId;

    /**
     * The line of the market.
     */
    @Nullable public String line;
}