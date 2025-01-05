package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEventProviderOdds;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueMarketUpdateProviderOdds} class represents an update to the markets of an outright league for providers odds type
 */
public class OutrightLeagueMarketUpdateProviderOdds {

    /**
     * The entity key for the outright league market update.
     */
    @JsonIgnore
    public final static int entityKey = 40;

    /**
     * The competition associated with the outright league market update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightLeagueCompetition<MarketEventProviderOdds> competition;
}