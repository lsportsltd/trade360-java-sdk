package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

/**
 * The {@code MarketEvent} class represents an event related to markets in a fixture.
 */
public class MarketEvent {

    /**
     * The ID of the fixture associated with the market event.
     */
    public int fixtureId;

    /**
     * The name of the fixture associated with the market event.
     * Present on OutrightLeagueMarketUpdate (type 40) and
     * OutrightLeagueSettlementUpdate (type 43) when provided by the feed;
     * omitted otherwise. This can be {@code null} if not set.
     */
    @Nullable public String fixtureName;

    /**
     * The markets associated with the market event.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Market> markets;
}