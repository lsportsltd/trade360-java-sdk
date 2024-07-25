package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightLeagueMarketUpdate {

    public final int EntityKey = 40;

    public Iterable<OutrightCompetition<MarketEvent>> Competitions;
}
