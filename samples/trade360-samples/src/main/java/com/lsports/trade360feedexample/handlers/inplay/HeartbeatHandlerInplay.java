package com.lsports.trade360feedexample.handlers.inplay;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.HeartbeatUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class HeartbeatHandlerInplay implements EntityHandling<HeartbeatUpdate> {
    @Override
    public void process(HeartbeatUpdate entity) {
        System.out.println( "Received: " + entity.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return HeartbeatUpdate.entityKey;
    }
}
