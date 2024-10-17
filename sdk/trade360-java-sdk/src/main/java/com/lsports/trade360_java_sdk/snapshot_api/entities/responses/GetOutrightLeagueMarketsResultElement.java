package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright league markets.
 */
public final class GetOutrightLeagueMarketsResultElement {
    /**
     * The unique identifier of the outright league markets result element.
     */
    public int id;

    /**
     * The name of the outright league markets result element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright league markets result element.
     */
    public int type;

    /**
     * The collection of outright league markets competitions associated with this result element.
     * Can be {@code null}.
     * 
     * @see OutrightLeagueMarketsCompetition
     */
    @Nullable public Iterable<OutrightLeagueMarketsCompetition> competitions;
}