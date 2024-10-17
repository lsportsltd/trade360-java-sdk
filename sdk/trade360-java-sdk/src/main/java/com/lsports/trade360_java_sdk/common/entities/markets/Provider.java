package com.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code Provider} class represents a provider of market data.
 */
public class Provider {

    /**
     * The ID of the provider.
     */
    public int id;

    /**
     * The name of the provider.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The last update time of the provider in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The provider fixture ID.
     * This can be {@code null} if not set.
     */
    @Nullable public String providerFixtureId;

    /**
     * The provider league ID.
     * This can be {@code null} if not set.
     */
    @Nullable public String providerLeagueId;

    /**
     * The provider market ID.
     * This can be {@code null} if not set.
     */
    @Nullable public String providerMarketId;

    /**
     * The bets associated with the provider.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Bet> bets;
}