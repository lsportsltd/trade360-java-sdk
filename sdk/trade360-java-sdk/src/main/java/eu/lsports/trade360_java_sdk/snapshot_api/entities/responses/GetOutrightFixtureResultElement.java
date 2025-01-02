package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright fixtures.
 */
public final class GetOutrightFixtureResultElement {
    /**
     * The unique identifier of the outright fixture.
     */
    public int id;

    /**
     * The name of the outright fixture.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the outright fixture.
     */
    public int type;

    /**
     * The collection of outright fixture events associated with this result.
     * 
     * @see OutrightFixtureEventElement
     */
    public Iterable<OutrightFixtureEventElement> events;
}