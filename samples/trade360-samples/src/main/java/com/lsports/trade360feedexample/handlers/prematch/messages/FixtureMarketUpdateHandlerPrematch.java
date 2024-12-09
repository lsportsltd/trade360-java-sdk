package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.MarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class FixtureMarketUpdateHandlerPrematch implements EntityHandler<MarketUpdate> {
    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void process(MarketUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return MarketUpdate.entityKey;
    }
}
