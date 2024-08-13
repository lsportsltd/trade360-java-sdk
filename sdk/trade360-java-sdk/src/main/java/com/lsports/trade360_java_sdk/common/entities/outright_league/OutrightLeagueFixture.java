package com.lsports.trade360_java_sdk.common.entities.outright_league;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import com.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import com.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class OutrightLeagueFixture {
    @Nullable public Subscription subscription;

    @Nullable public Sport sport;

    @Nullable public Location location;

    @Nullable public LocalDateTime lastUpdate;

    @Nullable public FixtureStatus status;

    @Nullable public Iterable<NameValuePair> extraData;

}
