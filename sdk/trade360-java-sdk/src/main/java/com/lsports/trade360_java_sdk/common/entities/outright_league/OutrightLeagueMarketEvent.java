package com.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

public class OutrightLeagueMarketEvent {
    public int fixtureId;

    @Nullable  public Iterable<MarketLeague> markets;
}
