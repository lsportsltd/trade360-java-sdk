package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import com.lsports.trade360_java_sdk.common.entities.fixtures.League;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public class FixtureSchedule
{
    public int fixtureId;
    @Nullable public Sport sport;
    @Nullable public Location location;
    @Nullable public League league;
    public LocalDateTime startDate;
    public LocalDateTime lastUpdate;
    public int status;
    @Nullable public Iterable<ParticipantSchedule> participants;
}
