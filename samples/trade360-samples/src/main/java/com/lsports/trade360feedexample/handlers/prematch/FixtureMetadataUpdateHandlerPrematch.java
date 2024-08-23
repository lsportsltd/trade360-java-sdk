package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.FixtureMetadataUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class FixtureMetadataUpdateHandlerPrematch implements EntityHandler<FixtureMetadataUpdate> {
    @Override
    public void process(FixtureMetadataUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return FixtureMetadataUpdate.entityKey;
    }
}
