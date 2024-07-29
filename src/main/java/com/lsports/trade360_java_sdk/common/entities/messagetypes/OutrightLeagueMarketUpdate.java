package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightLeagueMarketUpdate {

    public final int entityKey = 40;

    public Iterable<OutrightCompetition<MarketEvent>> competitions;
}
