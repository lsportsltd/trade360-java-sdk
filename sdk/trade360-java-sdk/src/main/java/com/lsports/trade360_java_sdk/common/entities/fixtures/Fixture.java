package com.lsports.trade360_java_sdk.common.entities.fixtures;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.shared.*;

public class Fixture {

    public Sport sport;

    public Location location;

    public League league;

    public LocalDateTime startDate;

    public LocalDateTime lastUpdate;

    public FixtureStatus status;

    public Iterable<Participant> participants;

    public Iterable<NameValuePair> fixtureExtraData;

    public String externalfixtureId;

    public Subscription subscription;
}
