package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import java.time.LocalDateTime;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import com.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import com.lsports.trade360_java_sdk.common.entities.shared.Subscription;

import jakarta.annotation.Nullable;

public final class OutrightLeagueFixtureSnapshot {
    @Nullable public Subscription subscription;
    @Nullable public Sport sport;
    @Nullable public Location location;
    public LocalDateTime lastUpdate;
    public FixtureStatus status;
    @Nullable public Iterable<NameValuePair> extraData;
}