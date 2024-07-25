package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;

public class OutrightSettlementsUpdate {

    public final int EntityKey = 42;

    public Iterable<OutrightCompetition<MarketEvent>> Competitions;
}
