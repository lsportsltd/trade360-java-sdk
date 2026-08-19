package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueMarketCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueMarketEvent;
import jakarta.annotation.Nullable;

import java.time.Instant;

/**
 * The {@code OutrightLeagueMarketUpdate} class represents an update to the markets of an outright league for trade360 customers.
 */
public class OutrightLeagueMarketUpdate {

    /**
     * The entity key for the outright league market update.
     */
    @JsonIgnore
    public final static int entityKey = 40;

    /**
     * The competition associated with the outright league market update.
     * This can be {@code null} if not set.
     * <p>
     * Deserialized as {@link OutrightLeagueMarketCompetition} at runtime so {@link #getNextFixtureStartTime()}
     * is available without changing the declared field type.
     */
    @Nullable
    @JsonDeserialize(as = OutrightLeagueMarketCompetition.class)
    public OutrightLeagueCompetition<OutrightLeagueMarketEvent> competition;

    /**
     * Returns the next fixture start time from {@link #competition},
     * or {@code null} when absent.
     */
    @Nullable
    public Instant getNextFixtureStartTime() {
        return competition != null ? competition.nextFixtureStartTime : null;
    }
}
