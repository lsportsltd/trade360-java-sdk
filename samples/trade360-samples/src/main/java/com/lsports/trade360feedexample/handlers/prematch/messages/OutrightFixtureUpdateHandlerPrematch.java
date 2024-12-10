package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.OutrightFixtureUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutrightFixtureUpdateHandlerPrematch implements EntityHandler<OutrightFixtureUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(OutrightFixtureUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightFixtureUpdate.entityKey;
    }
}
