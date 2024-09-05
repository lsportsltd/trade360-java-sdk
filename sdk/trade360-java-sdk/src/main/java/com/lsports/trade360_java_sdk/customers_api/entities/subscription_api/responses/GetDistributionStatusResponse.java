package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import jakarta.annotation.Nullable;

public class GetDistributionStatusResponse {
    public Boolean isDistributionOn;
    @Nullable public Iterable<String>  consumers;
    public int numberMessagesInQueue;
    public double messagesPerSecond;
}
