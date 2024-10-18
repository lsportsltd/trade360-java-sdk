package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright scores.
 */
public final class GetOutrightScoresResultElement {
    /**
     * The unique identifier of the outright scores result element.
     */
    public int id;

    /**
     * The name of the outright scores result element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright scores result element.
     */
    public int type;

    /**
     * The collection of outright score event elements associated with this result element.
     * 
     * @see OutrightScoreEventElement
     */
    public Iterable<OutrightScoreEventElement> events;
}