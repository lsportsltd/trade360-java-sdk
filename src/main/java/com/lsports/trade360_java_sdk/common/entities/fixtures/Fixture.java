package com.lsports.trade360_java_sdk.common.entities.fixtures;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.shared.*;

public class Fixture {

    public Sport Sport;

    public Location Location;

    public League League;

    public LocalDateTime StartDate;

    public LocalDateTime LastUpdate;

    public FixtureStatus Status;

    public Iterable<Participant> Participants;

    public Iterable<NameValuePair> FixtureExtraData;

    public String ExternalFixtureId;

    public Subscription Subscription;
}
