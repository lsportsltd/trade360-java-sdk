package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import jakarta.annotation.Nullable;

public final class OutrightLivescore {
    @Nullable public Iterable<OutrightParticipantResult> participantResults;
    public FixtureStatus status;
}