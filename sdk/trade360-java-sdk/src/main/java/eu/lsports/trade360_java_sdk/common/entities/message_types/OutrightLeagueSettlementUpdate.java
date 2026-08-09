package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueMarketEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueSettlementUpdate} class represents an update to the
 * settlements of an outright league for trade360 customers.
 */
public class OutrightLeagueSettlementUpdate {

    /**
     * The entity key for the outright league settlement update.
     */
    @JsonIgnore
    public final static int entityKey = 43;

    /**
     * The competition associated with the outright league settlement update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightLeagueCompetition<OutrightLeagueMarketEvent> competition;
}