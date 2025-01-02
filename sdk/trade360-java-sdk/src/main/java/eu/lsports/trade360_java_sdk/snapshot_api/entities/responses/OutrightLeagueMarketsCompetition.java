package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents a competition in outright league markets.
 */
public final class OutrightLeagueMarketsCompetition {
    /**
     * The unique identifier of the outright league markets competition.
     */
    public int id;

    /**
     * The name of the outright league markets competition.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright league markets competition.
     */
    public int type;

    /**
     * The collection of outright fixture markets elements associated with this competition.
     * Can be {@code null}.
     * 
     * @see OutrightFixtureMarketsElement
     */
    @Nullable public Iterable<OutrightFixtureMarketsElement> events;
}