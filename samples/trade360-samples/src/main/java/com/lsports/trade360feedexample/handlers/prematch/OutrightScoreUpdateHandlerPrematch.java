package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightScoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightScoreUpdateHandlerPrematch implements EntityHandling<OutrightScoreUpdate> {
    @Override
    public void process(OutrightScoreUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightScoreUpdate.entityKey;
    }
}
