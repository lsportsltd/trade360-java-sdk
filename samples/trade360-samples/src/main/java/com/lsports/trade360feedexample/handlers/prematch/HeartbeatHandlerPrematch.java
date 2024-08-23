package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.HeartbeatUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class HeartbeatHandlerPrematch implements EntityHandler<HeartbeatUpdate> {
    @Override
    public void process(HeartbeatUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return HeartbeatUpdate.entityKey;
    }
}
