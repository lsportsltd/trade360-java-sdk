package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.CompetitionSubscription;
import jakarta.annotation.Nullable;

public record CompetitionSubscriptionRequest(@Nullable Iterable<CompetitionSubscription> subscriptions) {
}
