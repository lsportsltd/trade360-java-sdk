package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightFixtureMarketUpdate {

    @JsonIgnore
    public final static  int entityKey = 3;

    public Iterable<OutrightCompetition<MarketEvent>> competitions;
}
