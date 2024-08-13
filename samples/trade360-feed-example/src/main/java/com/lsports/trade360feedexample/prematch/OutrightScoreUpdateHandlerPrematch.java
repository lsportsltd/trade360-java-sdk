package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightScoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightScoreUpdateHandlerPrematch implements EntityHandling<OutrightScoreUpdate> {
    @Override
    public void Process(OutrightScoreUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return OutrightScoreUpdate.entityKey;
    }
}
