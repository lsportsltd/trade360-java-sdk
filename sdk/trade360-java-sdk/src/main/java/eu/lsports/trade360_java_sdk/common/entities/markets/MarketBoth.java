package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

/**
 * The {@code Market} class represents a market in a betting context for both customers types
 */
public class MarketBoth {

    /**
     * The ID of the market.
     */
    public int id;

    /**
     * The name of the market.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The bets associated with the market.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Bet> bets;

    /**
     * The ProviderMarket associated with the market event.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<ProviderMarket> providerMarkets;

    /**
     * The main line of the market.
     * This can be {@code null} if not set.
     */
    @Nullable public String mainLine;
}