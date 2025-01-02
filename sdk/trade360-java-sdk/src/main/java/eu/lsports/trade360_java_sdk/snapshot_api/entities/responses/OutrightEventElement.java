package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an outright event element.
 */
public final class OutrightEventElement {
    /**
     * The unique identifier of the fixture.
     */
    public int fixtureId;

    /**
     * The outright fixture element associated with this event.
     * Can be {@code null}.
     * 
     * @see OutrightFixtureElement
     */
    @Nullable public OutrightFixtureElement outrightFixture;

    /**
     * The outright score element associated with this event.
     * Can be {@code null}.
     * 
     * @see OutrightScoreElement
     */
    @Nullable public OutrightScoreElement outrightScore;

    /**
     * The collection of fixture market elements associated with this event.
     * Can be {@code null}.
     * 
     * @see FixtureMarketElement
     */
    @Nullable public Iterable<FixtureMarketElement> markets;
}