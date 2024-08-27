package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class OutrightEventElement {
    public int fixtureId;
    @Nullable public OutrightFixtureElement outrightFixture;
    @Nullable public OutrightScoreElement outrightScore;
    @Nullable public Iterable<FixtureMarketElement> markets;
}
