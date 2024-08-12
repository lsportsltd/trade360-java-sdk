package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.markets.Bet;

import jakarta.annotation.Nullable;

public final class FixtureMarketElement {
    public int id;
    public String name;
    public @Nullable Iterable<Bet> bets;
}
