package com.lsports.trade360feedexample.handlers.inplay.messages;

import com.lsports.trade360_java_sdk.common.entities.message_types.KeepAliveUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeepAliveUpdateHandlerInplay implements EntityHandler<KeepAliveUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(KeepAliveUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return KeepAliveUpdate.entityKey;
    }
}
