package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import com.lsports.trade360_java_sdk.common.entities.livescore.Livescore;
import com.lsports.trade360_java_sdk.common.entities.markets.Market;

import jakarta.annotation.Nullable;

public final class GetEventsResultElement {
    public int fixtureId;
    public @Nullable Fixture fixture;
    public @Nullable Livescore livescore;
    public @Nullable Iterable<Market> markets;
}