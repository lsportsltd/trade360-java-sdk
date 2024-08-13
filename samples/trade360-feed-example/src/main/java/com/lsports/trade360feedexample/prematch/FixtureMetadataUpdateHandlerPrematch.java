package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.FixtureMetadataUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class FixtureMetadataUpdateHandlerPrematch implements EntityHandling<FixtureMetadataUpdate> {
    @Override
    public void Process(FixtureMetadataUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return FixtureMetadataUpdate.entityKey;
    }
}
