package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright.*;

public class OutrightSettlementsUpdate {

    @JsonIgnore
    public final static int entityKey = 42;

    public Iterable<OutrightCompetition<MarketEvent>> competitions;
}
