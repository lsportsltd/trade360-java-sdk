package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.*;
import jakarta.annotation.Nullable;

public class OutrightLeagueMarketUpdate {
    @JsonIgnore
    public final static int entityKey = 40;
    @Nullable
    public Iterable<OutrightCompetition<MarketEvent>> competitions;
}
