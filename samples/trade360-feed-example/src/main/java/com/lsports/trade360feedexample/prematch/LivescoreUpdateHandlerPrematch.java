package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.LivescoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class LivescoreUpdateHandlerPrematch implements EntityHandling<LivescoreUpdate> {
    @Override
    public void Process(LivescoreUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return LivescoreUpdate.entityKey;
    }
}
