package eu.lsports.trade360feedexample.handlers.prematch.messages;

import eu.lsports.trade360_java_sdk.common.entities.message_types.SettlementUpdate;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandler;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SettlementUpdateHandlerPrematch implements EntityHandler<SettlementUpdate> {
    protected static final Logger logger = LogManager.getLogger();
    @Override
    public void process(SettlementUpdate entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders) {
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
                            logger.info("Bet {} Status={} BetStatusId={} Settlement={}",
                                    bet.id, bet.status, bet.betStatusId, bet.settlement));
                });
            });
        }
    }

    @Override
    public int getEntityKey() {
        return SettlementUpdate.entityKey;
    }
}
