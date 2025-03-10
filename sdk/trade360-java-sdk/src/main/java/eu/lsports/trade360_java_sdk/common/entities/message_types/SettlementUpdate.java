package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code SettlementUpdate} class represents an update to the settlements of markets for trade360 customers.
 */
public class SettlementUpdate {

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
    public Iterable<MarketEvent> events;
}