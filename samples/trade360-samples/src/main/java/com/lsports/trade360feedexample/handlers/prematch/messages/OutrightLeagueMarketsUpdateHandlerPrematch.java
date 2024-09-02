package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightLeagueMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;

public class OutrightLeagueMarketsUpdateHandlerPrematch implements EntityHandler<OutrightLeagueMarketUpdate> {

    @Override
    public void process(OutrightLeagueMarketUpdate entity, Map<String, String> messageProperties) {
        System.out.println("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightLeagueMarketUpdate.entityKey;
    }
}
