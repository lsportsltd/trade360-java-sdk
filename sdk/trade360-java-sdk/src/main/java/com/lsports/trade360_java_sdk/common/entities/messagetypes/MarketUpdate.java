package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;

public class MarketUpdate  {
    @JsonIgnore
    public final static int entityKey = 3;

    @Nullable
    public Iterable<MarketEvent> events;
}
