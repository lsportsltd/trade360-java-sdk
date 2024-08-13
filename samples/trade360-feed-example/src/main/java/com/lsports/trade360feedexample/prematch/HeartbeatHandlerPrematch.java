package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.HeartbeatUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class HeartbeatHandlerPrematch implements EntityHandling<HeartbeatUpdate> {
    @Override
    public void Process(HeartbeatUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return HeartbeatUpdate.entityKey;
    }
}
