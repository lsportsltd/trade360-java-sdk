package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.KeepAliveUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class KeepAliveUpdateHandlerPrematchPrematch implements EntityHandling<KeepAliveUpdate> {
    @Override
    public void process(KeepAliveUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return KeepAliveUpdate.entityKey;
    }
}
