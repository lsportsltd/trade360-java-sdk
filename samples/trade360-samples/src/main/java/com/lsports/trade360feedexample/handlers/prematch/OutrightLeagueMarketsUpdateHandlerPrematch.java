package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightLeagueMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class OutrightLeagueMarketsUpdateHandlerPrematch implements EntityHandler<OutrightLeagueMarketUpdate> {
    @Override
    public void process(OutrightLeagueMarketUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightLeagueMarketUpdate.entityKey;
    }
}
