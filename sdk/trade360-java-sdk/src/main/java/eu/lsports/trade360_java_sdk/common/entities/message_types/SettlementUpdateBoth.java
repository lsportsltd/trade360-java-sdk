package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEventBoth;
import jakarta.annotation.Nullable;

/**
 * The {@code SettlementUpdateBoth} class represents an update to the settlements of markets for both customer types.
 */
public class SettlementUpdateBoth {

    /**
     * The entity key for the settlement update.
     */
    @JsonIgnore
    public final static int entityKey = 35;

    /**
     * The market events associated with the settlement update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<MarketEventBoth> events;
}