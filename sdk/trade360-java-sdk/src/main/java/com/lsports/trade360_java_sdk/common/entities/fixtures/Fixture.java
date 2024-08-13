package com.lsports.trade360_java_sdk.common.entities.fixtures;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.shared.*;
import jakarta.annotation.Nullable;

public class Fixture {

    @Nullable public Sport sport;

    @Nullable public Location location;

    @Nullable public League league;

    @Nullable public LocalDateTime startDate;

    public LocalDateTime lastUpdate;

    public FixtureStatus status;

    @Nullable public Iterable<Participant> participants;

    @Nullable public Iterable<NameValuePair> fixtureExtraData;

    @Nullable public String externalfixtureId;

    @Nullable public Subscription subscription;
}
