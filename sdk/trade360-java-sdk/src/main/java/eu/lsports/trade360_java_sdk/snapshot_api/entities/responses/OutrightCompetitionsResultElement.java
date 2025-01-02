package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright competitions.
 */
public final class OutrightCompetitionsResultElement {
    /**
     * The unique identifier of the outright competitions result element.
     */
    public int id;

    /**
     * The name of the outright competitions result element.
     * Can be {@code null}.
     */
    @Nullable public String Name;

    /**
     * The type of the outright competitions result element.
     */
    public int Type;

    /**
     * The collection of outright competition elements associated with this result element.
     * Can be {@code null}.
     * 
     * @see OutrightCompetition
     */
    @Nullable public Iterable<OutrightCompetition> events;
}