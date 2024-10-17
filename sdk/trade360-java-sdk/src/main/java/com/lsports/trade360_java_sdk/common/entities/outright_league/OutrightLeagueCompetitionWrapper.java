package com.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueCompetitionWrapper} class represents a wrapper for outright league competitions.
 *
 * @param <T> the type of the events associated with the competition
 */
public class OutrightLeagueCompetitionWrapper<T> {

    /**
     * The ID of the competition.
     */
    public int id;

    /**
     * The name of the competition.
     * This can be {@code null} if not set.
     */
    @Nullable public String name;

    /**
     * The type of the competition.
     */
    public int type;

    /**
     * The competitions associated with the competition wrapper.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<OutrightLeagueEventsWrapper<T>> competitions;
}