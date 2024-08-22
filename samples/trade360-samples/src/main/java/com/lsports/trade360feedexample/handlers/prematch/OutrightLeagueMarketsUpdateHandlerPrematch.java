package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightLeagueMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightLeagueMarketsUpdateHandlerPrematch implements EntityHandling<OutrightLeagueMarketUpdate> {
    @Override
    public void process(OutrightLeagueMarketUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightLeagueMarketUpdate.entityKey;
    }
}
