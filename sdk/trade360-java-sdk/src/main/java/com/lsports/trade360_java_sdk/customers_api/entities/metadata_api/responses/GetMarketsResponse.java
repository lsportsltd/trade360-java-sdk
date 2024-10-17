package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import jakarta.annotation.Nullable;

/**
 * The {@code GetMarketsResponse} record represents a response containing a list of markets.
 *
 * @param markets the list of markets
 * @see MarketMetadata
 */
public final record GetMarketsResponse(@Nullable Iterable<MarketMetadata> markets) {
}