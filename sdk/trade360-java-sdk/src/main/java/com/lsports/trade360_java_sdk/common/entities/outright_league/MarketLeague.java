package com.lsports.trade360_java_sdk.common.entities.outright_league;

import com.lsports.trade360_java_sdk.common.entities.markets.Bet;
import jakarta.annotation.Nullable;

public class MarketLeague {

    public int id;

    @Nullable public String name;

    @Nullable public Iterable<Bet> bets;

    @Nullable public String mainLine;
}
