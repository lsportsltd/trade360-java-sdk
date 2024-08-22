package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.MarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class FixtureMarketUpdateHandlerPrematch implements EntityHandling<MarketUpdate> {

    @Override
    public void Process(MarketUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return MarketUpdate.entityKey;
    }
}
