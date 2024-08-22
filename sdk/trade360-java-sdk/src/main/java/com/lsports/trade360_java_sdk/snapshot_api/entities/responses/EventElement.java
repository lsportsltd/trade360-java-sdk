package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

public final class EventElement {
    public int fixtureId;
    public @Nullable OutrightFixtureElement outrightFixture;
    public @Nullable OutrightScoreElement outrightScore;
    public @Nullable Iterable<FixtureMarketElement> markets;
}
