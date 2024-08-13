package com.lsports.trade360feedexample.inplay;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.HeartbeatUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class HeartbeatHandlerInplay implements EntityHandling<HeartbeatUpdate> {
    @Override
    public void Process(HeartbeatUpdate entity) {
        System.out.println( "Received: " + entity.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return 0;
    }
}
