package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;

public class SettlementUpdate {

    @JsonIgnore
    public final static int entityKey = 35;

    public Iterable<MarketEvent> events;
}
