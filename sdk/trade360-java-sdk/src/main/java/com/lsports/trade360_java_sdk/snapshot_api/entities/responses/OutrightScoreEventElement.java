package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an outright score event element.
 */
public final class OutrightScoreEventElement {
    /**
     * The unique identifier of the fixture.
     */
    public int fixtureId;

    /**
     * The outright live score associated with this event.
     * Can be {@code null}.
     * 
     * @see OutrightLivescore
     */
    @Nullable public OutrightLivescore outrightScore;
}