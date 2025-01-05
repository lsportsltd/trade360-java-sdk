package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEventBoth;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightSettlementsUpdateBoth} class represents an update to the settlements of outright competitions for both customer types.
 */
public class OutrightSettlementsUpdateBoth {

    /**
     * The entity key for the outright settlements update.
     */
    @JsonIgnore
    public final static int entityKey = 42;

    /**
     * The competition associated with the outright settlements update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightCompetition<MarketEventBoth> competition;
}