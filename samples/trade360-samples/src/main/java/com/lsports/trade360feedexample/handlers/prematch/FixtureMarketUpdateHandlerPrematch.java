package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.MarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class FixtureMarketUpdateHandlerPrematch implements EntityHandler<MarketUpdate> {

    @Override
    public void process(MarketUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return MarketUpdate.entityKey;
    }
}
