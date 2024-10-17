package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import jakarta.annotation.Nullable;

/**
 * The {@code GetLeaguesRequest} record represents a request to retrieve leagues based on various criteria.
 *
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param subscriptionStatus the subscription status to filter by
 * @param languageId the ID of the language to filter by
 * @see SubscriptionState
 */
public final record GetLeaguesRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    SubscriptionState subscriptionStatus,
    @Nullable Integer languageId) {
}