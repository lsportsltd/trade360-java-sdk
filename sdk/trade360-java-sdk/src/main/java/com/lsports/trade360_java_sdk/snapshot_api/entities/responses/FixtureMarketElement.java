package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.markets.Bet;

import jakarta.annotation.Nullable;

/**
 * Represents a market element in a fixture.
 *
 * @param id The ID of the market
 * @param name The name of the market
 * @param bets The bets associated with the market
 * @see Bet
 */
public final class FixtureMarketElement {
    public int id;
    public String name;
    @Nullable public Iterable<Bet> bets;
}