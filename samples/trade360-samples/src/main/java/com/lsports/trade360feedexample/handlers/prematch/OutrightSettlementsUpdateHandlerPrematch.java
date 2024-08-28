package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightSettlementsUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;

public class OutrightSettlementsUpdateHandlerPrematch implements EntityHandler<OutrightSettlementsUpdate> {

    @Override
    public void process(OutrightSettlementsUpdate entity, Map<String, String> messageProperties) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightSettlementsUpdate.entityKey;
    }
}
