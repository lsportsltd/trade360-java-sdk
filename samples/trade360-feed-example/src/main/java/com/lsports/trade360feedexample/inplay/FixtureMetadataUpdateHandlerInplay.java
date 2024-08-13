package com.lsports.trade360feedexample.inplay;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.FixtureMetadataUpdate;
import com.lsports.trade360_java_sdk.common.entities.messagetypes.LivescoreUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class FixtureMetadataUpdateHandlerInplay  implements EntityHandling<FixtureMetadataUpdate> {
    @Override
    public void Process(FixtureMetadataUpdate entity) {
        System.out.println( "Received: " + entity.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return LivescoreUpdate.entityKey;
    }
}
