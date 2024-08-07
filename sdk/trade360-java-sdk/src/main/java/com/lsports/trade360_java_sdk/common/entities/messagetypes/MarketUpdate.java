package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MarketUpdate {

    //public final int entityKey = 3;

    public Iterable<MarketEvent> events;
}
