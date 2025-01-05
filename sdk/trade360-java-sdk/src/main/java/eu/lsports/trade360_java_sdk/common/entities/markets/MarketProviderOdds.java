package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

/**
 * The {@code MarketProviderOdds} class represents a market in a betting context for provider odds type
 */
public class MarketProviderOdds {

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