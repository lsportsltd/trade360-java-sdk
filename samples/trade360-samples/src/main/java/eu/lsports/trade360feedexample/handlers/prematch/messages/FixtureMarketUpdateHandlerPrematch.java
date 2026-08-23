package eu.lsports.trade360feedexample.handlers.prematch.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.MarketUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class FixtureMarketUpdateHandlerPrematch implements EntityHandler<MarketUpdate> {
    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void process(MarketUpdate entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders) {
        logger.info("Received: " + this.getClass().getSimpleName());
        if (entity.events != null) {
            entity.events.forEach(marketEvent -> {
                if (marketEvent.markets == null) {
                    return;
                }
                marketEvent.markets.forEach(market -> {
                    if (market.bets == null) {
                        return;
                    }
                    market.bets.forEach(bet ->
                            logger.info("Bet {} Status={} BetStatusId={}", bet.id, bet.status, bet.betStatusId));
                });
            });
        }
    }

    @Override
    public int getEntityKey() {
        return MarketUpdate.entityKey;
    }
}
