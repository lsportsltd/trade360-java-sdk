package com.lsports.trade360_java_sdk.common.entities.messagetypes;

import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.Entity;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class MarketUpdate  {

    public final static int entityKey = 3;

    public Iterable<MarketEvent> events;
}
