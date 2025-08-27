package eu.lsports.trade360feedexample.handlers.prematch.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.KeepAliveUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KeepAliveUpdateHandlerPrematch implements EntityHandler<KeepAliveUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(KeepAliveUpdate entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {

        return KeepAliveUpdate.entityKey;
    }
}
