package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEventBoth;
import jakarta.annotation.Nullable;

/**
 * The {@code MarketUpdateBoth} class represents a market update message for both customer types.
 */
public class MarketUpdateBoth {

    /**
     * The entity key for the market update.
     */
    @JsonIgnore
    public final static int entityKey = 3;

    /**
     * The market events associated with the update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Iterable<MarketEventBoth> events;
}