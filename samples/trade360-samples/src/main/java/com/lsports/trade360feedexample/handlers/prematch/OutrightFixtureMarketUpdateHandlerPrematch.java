package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightFixtureMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightFixtureMarketUpdateHandlerPrematch implements EntityHandling<OutrightFixtureMarketUpdate> {
    @Override
    public void process(OutrightFixtureMarketUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightFixtureMarketUpdate.entityKey;
    }
}
