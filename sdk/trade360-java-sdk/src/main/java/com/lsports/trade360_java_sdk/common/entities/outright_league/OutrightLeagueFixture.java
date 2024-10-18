package com.lsports.trade360_java_sdk.common.entities.outright_league;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import com.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import com.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * The {@code OutrightLeagueFixture} class represents a fixture in an outright league.
 */
public class OutrightLeagueFixture {

    /**
     * The subscription associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Subscription subscription;

    /**
     * The sport associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Sport sport;

    /**
     * The location of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Location location;

    /**
     * The last update time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public LocalDateTime lastUpdate;

    /**
     * The status of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public FixtureStatus status;

    /**
     * Extra data associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<NameValuePair> extraData;
}