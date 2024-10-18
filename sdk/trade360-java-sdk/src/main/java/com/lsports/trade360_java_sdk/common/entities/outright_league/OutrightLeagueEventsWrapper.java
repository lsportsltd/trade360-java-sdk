package com.lsports.trade360_java_sdk.common.entities.outright_league;

import jakarta.annotation.Nullable;

/**
 * The {@code OutrightLeagueEventsWrapper} class represents a wrapper for events in an outright league competition.
 *
 * @param <T> the type of the events associated with the competition
 */
public class OutrightLeagueEventsWrapper<T> {

    /**
     * The events associated with the competition.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<T> events;
}