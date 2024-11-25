package com.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueFixtureEvent} class represents a fixture event in an outright league.
 */
public class OutrightLeagueFixtureEvent {

    /**
     * The ID of the fixture associated with the market event.
     */
    public int fixtureId;

    /**
     * The markets associated with the market event.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<MarketLeague> markets;
}