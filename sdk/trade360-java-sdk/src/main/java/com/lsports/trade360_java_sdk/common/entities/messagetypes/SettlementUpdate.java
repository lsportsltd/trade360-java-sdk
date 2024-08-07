package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;

public class SettlementUpdate {

    public final int entityKey = 35;

    public Iterable<MarketEvent> events;
}
