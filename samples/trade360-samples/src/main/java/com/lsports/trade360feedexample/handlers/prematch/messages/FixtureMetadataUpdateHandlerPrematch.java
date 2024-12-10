package com.lsports.trade360feedexample.handlers.prematch.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.FixtureMetadataUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.util.Map;

public class FixtureMetadataUpdateHandlerPrematch implements EntityHandler<FixtureMetadataUpdate> {

    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void process(FixtureMetadataUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return FixtureMetadataUpdate.entityKey;
    }
}
