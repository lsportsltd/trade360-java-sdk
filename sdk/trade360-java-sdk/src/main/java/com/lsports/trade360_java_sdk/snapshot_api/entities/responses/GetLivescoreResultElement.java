package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.livescore.Livescore;

import jakarta.annotation.Nullable;

public final class GetLivescoreResultElement {
    public int fixtureId;
    public @Nullable Livescore livescore;
}
