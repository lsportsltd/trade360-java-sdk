package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

/**
 * Represents a market in the subscription API.
 */
public class Market {
    /**
     * The ID of the market.
     */
    public int marketId;

    /**
     * The line of the market.
     * Nullable to handle missing values.
     */
    @Nullable public String line;
}