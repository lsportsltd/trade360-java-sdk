package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import com.lsports.trade360_java_sdk.common.entities.enums.MarketType;

import jakarta.annotation.Nullable;

public final record GetMarketsRequest(
    @Nullable Iterable<Integer> sportIds,
    @Nullable Iterable<Integer> locationIds,
    @Nullable Iterable<Integer> leaguesIds,
    @Nullable Iterable<Integer> marketsIds,
    @Nullable Boolean isSettleable,
    MarketType marketType,
    @Nullable Integer languageId) {
}