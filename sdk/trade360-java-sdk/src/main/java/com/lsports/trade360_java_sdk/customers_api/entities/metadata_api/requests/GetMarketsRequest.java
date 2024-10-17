package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import jakarta.annotation.Nullable;

/**
 * The {@code GetMarketsRequest} record represents a request to retrieve markets based on various criteria.
 *
 * @param sportIds the IDs of the sports to filter by
 * @param locationIds the IDs of the locations to filter by
 * @param leaguesIds the IDs of the leagues to filter by
 * @param marketsIds the IDs of the markets to filter by
 * @param isSettleable whether the market is settleable
 * @param marketType the type of the market
 * @param languageId the ID of the language to filter by
 * @see MarketType
 */
public final record GetMarketsRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leaguesIds,
    @Nullable Iterable<Integer> marketsIds,
    @Nullable Boolean isSettleable,
    MarketType marketType,
    @Nullable Integer languageId) {
}