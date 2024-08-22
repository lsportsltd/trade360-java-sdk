package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightSettlementsUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightSettlementsUpdateHandlerPrematch implements EntityHandling<OutrightSettlementsUpdate> {
    @Override
    public void process(OutrightSettlementsUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightSettlementsUpdate.entityKey;
    }
}
