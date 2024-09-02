package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightFixtureUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;

public class OutrightFixtureUpdateHandlerPrematch implements EntityHandler<OutrightFixtureUpdate> {

    @Override
    public void process(OutrightFixtureUpdate entity, Map<String, String> messageProperties) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightFixtureUpdate.entityKey;
    }
}
