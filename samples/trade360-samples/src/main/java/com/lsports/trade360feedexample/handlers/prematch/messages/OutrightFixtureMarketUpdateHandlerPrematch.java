package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightFixtureMarketUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutrightFixtureMarketUpdateHandlerPrematch implements EntityHandler<OutrightFixtureMarketUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(OutrightFixtureMarketUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightFixtureMarketUpdate.entityKey;
    }
}
