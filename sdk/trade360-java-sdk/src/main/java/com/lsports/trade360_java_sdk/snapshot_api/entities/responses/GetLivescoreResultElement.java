package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.livescore.Livescore;

import jakarta.annotation.Nullable;

/**
 * Represents an element in the result of a get livescore request.
 */
public final class GetLivescoreResultElement {
    /**
     * The ID of the fixture.
     */
    public int fixtureId;

    /**
     * The livescore details.
     */
    @Nullable public Livescore livescore;
}