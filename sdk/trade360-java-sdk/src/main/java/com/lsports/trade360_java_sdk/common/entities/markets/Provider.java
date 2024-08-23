package com.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class Provider {
    
    public int id;

    @Nullable  public String name;

    public LocalDateTime lastUpdate;

    @Nullable public String providerfixtureId;

    @Nullable public String providerLeagueId;

    @Nullable public String providerMarketId;

    @Nullable public Iterable<Bet> bets;
}
