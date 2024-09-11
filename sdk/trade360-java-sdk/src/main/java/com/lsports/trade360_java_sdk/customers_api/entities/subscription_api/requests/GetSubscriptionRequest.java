package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import jakarta.annotation.Nullable;

public record GetSubscriptionRequest(@Nullable Iterable<Integer> sportIds,
                                     @Nullable Iterable<Integer> locationIds,
                                     @Nullable Iterable<Integer> leagueIds) {
}
