package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code ProviderMarket} class represents a provider market in a betting context.
 */
public class ProviderMarket {

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
    @Nullable public Iterable<ProviderMarketBet> bets;

    /**
     * The last update time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public LocalDateTime lastUpdate;


}