package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightSettlementsUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class OutrightSettlementsUpdateHandlerPrematch implements EntityHandler<OutrightSettlementsUpdate> {
    @Override
    public void process(OutrightSettlementsUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightSettlementsUpdate.entityKey;
    }
}
