package eu.lsports.trade360feedexample.handlers.inplay.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.OutrightLeagueMarketUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class OutrightLeagueMarketsUpdateHandlerInplay implements EntityHandler<OutrightLeagueMarketUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(OutrightLeagueMarketUpdate entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders) {
        logger.info("Received: " + this.getClass().getSimpleName());
    }

    @Override
    public int getEntityKey() {
        return OutrightLeagueMarketUpdate.entityKey;
    }
}
