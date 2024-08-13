package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightLeagueUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightLeagueUpdateHandlerPrematch implements EntityHandling<OutrightLeagueUpdate> {
    @Override
    public void Process(OutrightLeagueUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return OutrightLeagueUpdate.entityKey;
    }
}
