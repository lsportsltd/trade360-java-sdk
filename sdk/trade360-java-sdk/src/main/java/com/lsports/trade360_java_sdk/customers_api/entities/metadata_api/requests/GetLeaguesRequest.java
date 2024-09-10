package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import jakarta.annotation.Nullable;

public final record GetLeaguesRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    SubscriptionFilterEnum subscriptionStatus,
    @Nullable Integer languageId) {

    public GetLeaguesRequest() {
        this(
            null,
            null,
            SubscriptionFilterEnum.ALL,
            null);
    }
}
