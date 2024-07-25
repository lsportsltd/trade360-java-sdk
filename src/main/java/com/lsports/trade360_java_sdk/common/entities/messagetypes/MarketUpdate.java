package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;

public class MarketUpdate {

    public final int EntityKey = 3;

    public Iterable<MarketEvent> Events;
}
