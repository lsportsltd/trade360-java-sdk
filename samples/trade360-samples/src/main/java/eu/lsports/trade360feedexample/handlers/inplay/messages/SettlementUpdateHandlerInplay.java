package eu.lsports.trade360feedexample.handlers.inplay.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.SettlementUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SettlementUpdateHandlerInplay implements EntityHandler<SettlementUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(SettlementUpdate entity, Map<String, String> messageProperties) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return SettlementUpdate.entityKey;
    }
}
