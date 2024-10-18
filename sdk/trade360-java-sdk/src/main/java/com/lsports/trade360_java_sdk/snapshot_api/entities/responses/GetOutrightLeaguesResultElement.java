package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright leagues.
 */
public final class GetOutrightLeaguesResultElement {
    /**
     * The unique identifier of the outright leagues result element.
     */
    public int id;

    /**
     * The name of the outright leagues result element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright leagues result element.
     */
    public int type;

    /**
     * The collection of outright competitions result elements associated with this result element.
     * Can be {@code null}.
     * 
     * @see OutrightCompetitionsResultElement
     */
    @Nullable public Iterable<OutrightCompetitionsResultElement> competitions;
}