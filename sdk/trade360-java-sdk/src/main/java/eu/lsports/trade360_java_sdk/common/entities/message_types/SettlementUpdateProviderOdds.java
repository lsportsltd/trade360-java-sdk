package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEventProviderOdds;
import jakarta.annotation.Nullable;

/**
 * The {@code SettlementUpdateProviderOdds} class represents an update to the settlements of markets for providers odds type
 */
public class SettlementUpdateProviderOdds {

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
    public Iterable<MarketEventProviderOdds> events;
}