package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import java.time.LocalDateTime;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Participant;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import com.lsports.trade360_java_sdk.common.entities.shared.Subscription;

import jakarta.annotation.Nullable;

public final class OutrightFixtureElement {
    public @Nullable Sport sport;
    public @Nullable Location location;
    public @Nullable LocalDateTime startDate;
    public LocalDateTime lastUpdate;
    public FixtureStatus status;
    public @Nullable Iterable<Participant> participants;
    public @Nullable Subscription subscription;
}
