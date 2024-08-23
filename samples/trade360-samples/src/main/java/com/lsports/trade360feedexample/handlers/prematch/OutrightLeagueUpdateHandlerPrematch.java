package com.lsports.trade360feedexample.handlers.prematch;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightLeagueUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

public class OutrightLeagueUpdateHandlerPrematch implements EntityHandler<OutrightLeagueUpdate> {
    @Override
    public void process(OutrightLeagueUpdate entity) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightLeagueUpdate.entityKey;
    }
}
