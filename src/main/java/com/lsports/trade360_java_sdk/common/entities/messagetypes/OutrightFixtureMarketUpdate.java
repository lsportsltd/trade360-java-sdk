package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightFixtureMarketUpdate {

    public final int EntityKey = 3;

    public Iterable<OutrightCompetition<MarketEvent>> Competitions;
}
