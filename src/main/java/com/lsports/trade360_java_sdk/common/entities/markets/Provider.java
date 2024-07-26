package com.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;

public class Provider {
    
    public int id;

    public String name;

    public LocalDateTime lastUpdate;

    public String providerfixtureId;

    public String providerLeagueId;

    public String providerMarketId;

    public Iterable<Bet> bets;
}
