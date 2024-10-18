package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import jakarta.annotation.Nullable;

/**
 * The {@code GetCompetitionsRequest} record represents a request to retrieve competitions based on various criteria.
 *
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param competitionIds the IDs of the competitions to filter by
 * @param subscriptionStatus the subscription status to filter by
 * @see SubscriptionState
 */
public final record GetCompetitionsRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> competitionIds,
    SubscriptionState subscriptionStatus) {
}