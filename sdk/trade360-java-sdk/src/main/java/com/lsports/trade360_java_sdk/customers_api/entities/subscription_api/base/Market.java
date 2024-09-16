package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

public class Market {
    public int marketId;
    @Nullable public String line; // Nullable to handle missing values
}
