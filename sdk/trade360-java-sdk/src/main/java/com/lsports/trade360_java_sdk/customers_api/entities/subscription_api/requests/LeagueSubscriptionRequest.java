package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.LeagueSubscription;
import jakarta.annotation.Nullable;

public class LeagueSubscriptionRequest {
    @Nullable public Iterable<LeagueSubscription> subscriptions;
}
