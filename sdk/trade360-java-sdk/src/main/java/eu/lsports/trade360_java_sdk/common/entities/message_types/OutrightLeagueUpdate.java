package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueFixtureEvent;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueUpdate} class represents an update to the outright leagues.
 */
public class OutrightLeagueUpdate {

    /**
     * The entity key for the outright league update.
     */
    @JsonIgnore
    public final static int entityKey = 38;

    /**
     * The competitions associated with the outright league update.
     * This can be {@code null} if not set.
     */
    @Nullable
    public OutrightLeagueCompetition<OutrightLeagueFixtureEvent> competition;
}