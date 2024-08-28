package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.LivescoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;

public class LivescoreUpdateHandlerPrematch implements EntityHandler<LivescoreUpdate> {


    @Override
    public void process(LivescoreUpdate entity, Map<String, String> messageProperties) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return LivescoreUpdate.entityKey;
    }
}
