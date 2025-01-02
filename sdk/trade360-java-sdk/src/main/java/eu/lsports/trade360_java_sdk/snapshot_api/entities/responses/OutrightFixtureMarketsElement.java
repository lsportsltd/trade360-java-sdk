package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an outright fixture markets element.
 */
public final class OutrightFixtureMarketsElement {
    /**
     * The unique identifier of the fixture.
     */
    public int fixtureId;

    /**
     * The collection of outright market elements associated with this fixture.
     * Can be {@code null}.
     * 
     * @see OutrightMarketElement
     */
    @Nullable public Iterable<OutrightMarketElement> markets;
}