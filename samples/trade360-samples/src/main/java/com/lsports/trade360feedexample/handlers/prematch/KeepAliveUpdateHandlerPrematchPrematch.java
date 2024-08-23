package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.KeepAliveUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class KeepAliveUpdateHandlerPrematchPrematch implements EntityHandler<KeepAliveUpdate> {
    @Override
    public void process(KeepAliveUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {

        return KeepAliveUpdate.entityKey;
    }
}
