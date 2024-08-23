package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightFixtureMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class OutrightFixtureMarketUpdateHandlerPrematch implements EntityHandler<OutrightFixtureMarketUpdate> {
    @Override
    public void process(OutrightFixtureMarketUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightFixtureMarketUpdate.entityKey;
    }
}
