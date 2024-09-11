package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import jakarta.annotation.Nullable;

public class GetSubscriptionRequest {
    @Nullable public Iterable<Integer> sportIds;
    @Nullable public Iterable<Integer> locationIds;
    @Nullable public Iterable<Integer> leagueIds;
}
