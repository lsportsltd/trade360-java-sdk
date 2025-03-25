package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.markets.Bet;

import jakarta.annotation.Nullable;

/**
 * Represents a market element within a fixture.
 */
public class FixtureMarketElement {
    /** The unique identifier of the market. */
    public int id;

    /** The name or description of the market. */
    public String name;

    /** The collection of bets associated with this market. */
    @Nullable public Iterable<Bet> bets;
}