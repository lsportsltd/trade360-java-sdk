package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightFixtureMarketUpdate} class represents an update to the markets of an outright fixture for trade360 customers.
 */
public class OutrightFixtureMarketUpdate {

    /**
     * The entity key for the outright fixture market update.
     */
    @JsonIgnore
    public final static int entityKey = 41;

    /**
     * The competition associated with the outright fixture market update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightCompetition<MarketEvent> competition;
}