package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code MarketMetadata} record represents metadata for a market.
 *
 * @param id the ID of the market
 * @param name the name of the market
 * @param isSettleable whether the market is settleable
 */
public final record MarketMetadata(int id, @Nullable String name, Boolean isSettleable) {
}