package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightLeagueMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightLeagueMarketsUpdateHandlerPrematch implements EntityHandling<OutrightLeagueMarketUpdate> {
    @Override
    public void Process(OutrightLeagueMarketUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return OutrightLeagueMarketUpdate.entityKey;
    }
}
