package com.lsports.trade360feedexample.handlers.inplay;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.MarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;


public class FixtureMarketUpdateHandlerInplay implements EntityHandling<MarketUpdate> {

    @Override
    public void process(MarketUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return MarketUpdate.entityKey;
    }

}