package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;

import jakarta.annotation.Nullable;

public final record GetLeaguesRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    SubscriptionState subscriptionStatus,
    @Nullable Integer languageId) {
}
