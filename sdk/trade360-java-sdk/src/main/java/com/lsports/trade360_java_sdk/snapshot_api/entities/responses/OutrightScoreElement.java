package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightParticipant;

import jakarta.annotation.Nullable;

public final class OutrightScoreElement {
    @Nullable public Iterable<OutrightParticipant> participantResults;
    public FixtureStatus status;
}
