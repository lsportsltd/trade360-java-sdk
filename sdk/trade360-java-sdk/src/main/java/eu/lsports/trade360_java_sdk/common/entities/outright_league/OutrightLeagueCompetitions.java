package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueCompetitions} class represents competitions in an outright league.
 *
 * @param <T> the type of the events associated with the competition
 */
public class OutrightLeagueCompetitions<T> {

    /**
     * The ID of the competition.
     */
    public int id;

    /**
     * The name of the competition.
     */
    public String name;

    /**
     * The type of the competition.
     */
    public int type;

    /**
     * The events associated with the competition.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<T> events;
}