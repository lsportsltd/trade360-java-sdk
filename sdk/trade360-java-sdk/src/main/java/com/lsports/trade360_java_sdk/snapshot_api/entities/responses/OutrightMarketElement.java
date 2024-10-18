package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.markets.Bet;
import jakarta.annotation.Nullable;

/**
 * Represents an outright market element.
 */
public final class OutrightMarketElement {
    /**
     * The unique identifier of the outright market element.
     */
    public int id;

    /**
     * The name of the outright market element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The collection of bets associated with the outright market element.
     * Can be {@code null}.
     * 
     * @see Bet
     */
    @Nullable public Iterable<Bet> bets;
}