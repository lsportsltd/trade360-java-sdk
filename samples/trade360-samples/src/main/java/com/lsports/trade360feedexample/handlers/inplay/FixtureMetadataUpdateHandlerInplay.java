package com.lsports.trade360feedexample.handlers.inplay;

import com.lsports.trade360_java_sdk.common.entities.message_types.FixtureMetadataUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class FixtureMetadataUpdateHandlerInplay  implements EntityHandler<FixtureMetadataUpdate> {
    @Override
    public void process(FixtureMetadataUpdate entity) {
        System.out.println("Received: " + entity.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return FixtureMetadataUpdate.entityKey;
    }
}
