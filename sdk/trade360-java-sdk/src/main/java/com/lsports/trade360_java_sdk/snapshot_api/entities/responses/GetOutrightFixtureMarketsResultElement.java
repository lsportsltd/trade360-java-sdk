package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright fixture markets.
 */
public final class GetOutrightFixtureMarketsResultElement {
    /**
     * The unique identifier of the outright fixture markets.
     */
    public int id;

    /**
     * The name of the outright fixture markets.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright fixture markets.
     */
    public int type;

    /**
     * The collection of outright fixture market elements associated with this result element.
     * 
     * @see OutrightFixtureMarketsElement
     */
    public Iterable<OutrightFixtureMarketsElement> events;
}