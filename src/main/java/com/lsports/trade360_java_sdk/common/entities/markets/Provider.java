package com.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;

public class Provider {
    
    public int Id;

    public String Name;

    public LocalDateTime LastUpdate;

    public String ProviderFixtureId;

    public String ProviderLeagueId;

    public String ProviderMarketId;

    public Iterable<Bet> Bets;
}
