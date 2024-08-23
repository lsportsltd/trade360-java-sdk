package com.lsports.trade360feedexample.handlers.inplay;

import com.lsports.trade360_java_sdk.common.entities.message_types.LivescoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class LivescoreUpdateHandlerInplay implements EntityHandler<LivescoreUpdate> {

    @Override
    public void process(LivescoreUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return LivescoreUpdate.entityKey;
    }
}
