package com.lsports.trade360feedexample.handlers.inplay.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.SettlementUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;

public class SettlementUpdateHandlerInplay implements EntityHandler<SettlementUpdate> {

    @Override
    public void process(SettlementUpdate entity, Map<String, String> messageProperties) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return SettlementUpdate.entityKey;
    }
}
