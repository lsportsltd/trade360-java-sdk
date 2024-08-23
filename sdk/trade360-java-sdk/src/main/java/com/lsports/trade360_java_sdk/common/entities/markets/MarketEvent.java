package com.lsports.trade360_java_sdk.common.entities.markets;

import jakarta.annotation.Nullable;

public class MarketEvent {

    public int fixtureId;
    
    @Nullable public Iterable<Market> markets;
}
