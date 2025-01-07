package eu.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

/**
 * The {@code MarketEventBoth} class represents an event related to markets in a fixture for both customer types
 */
public class MarketEventBoth {

    /**
     * The ID of the fixture associated with the market event.
     */
    public int fixtureId;

    /**
     * The markets associated with the market event.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<MarketBoth> markets;

}