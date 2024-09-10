package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.SuspendedMarket;
import jakarta.annotation.Nullable;

public class SuspensionChangeResponse {

    public Boolean succeeded;
    @Nullable public String reason;
    @Nullable public Integer fixtureId;
    @Nullable public Iterable<SuspendedMarket> markets;
}
