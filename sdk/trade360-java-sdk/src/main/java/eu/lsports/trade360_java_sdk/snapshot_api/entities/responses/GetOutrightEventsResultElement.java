package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright events.
 */
public final class GetOutrightEventsResultElement {
    /**
     * The unique identifier of the outright event.
     */
    public int id;

    /**
     * The name of the outright event.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright event.
     */
    public int type;

    /**
     * The collection of outright event elements associated with this result element.
     * 
     * @see OutrightEventElement
     */
    public Iterable<OutrightEventElement> events;
}