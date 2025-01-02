package eu.lsports.trade360feedexample.handlers.prematch.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.OutrightScoreUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutrightScoreUpdateHandlerPrematch implements EntityHandler<OutrightScoreUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(OutrightScoreUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightScoreUpdate.entityKey;
    }
}
