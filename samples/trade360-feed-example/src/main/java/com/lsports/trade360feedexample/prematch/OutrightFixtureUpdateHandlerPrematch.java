package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.OutrightFixtureUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class OutrightFixtureUpdateHandlerPrematch implements EntityHandling<OutrightFixtureUpdate> {
    @Override
    public void Process(OutrightFixtureUpdate entity) {
        System.out.println( "Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int GetEntityKey() {
        return OutrightFixtureUpdate.entityKey;
    }
}
