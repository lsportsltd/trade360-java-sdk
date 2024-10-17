package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import java.time.LocalDateTime;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import com.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import com.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import com.lsports.trade360_java_sdk.common.entities.shared.Subscription;

import jakarta.annotation.Nullable;

/**
 * Represents a snapshot of an outright league fixture.
 */
public final class OutrightLeagueFixtureSnapshot {
    /**
     * The subscription associated with the outright league fixture snapshot.
     * Can be {@code null}.
     * 
     * @see Subscription
     */
    @Nullable public Subscription subscription;

    /**
     * The sport associated with the outright league fixture snapshot.
     * Can be {@code null}.
     * 
     * @see Sport
     */
    @Nullable public Sport sport;

    /**
     * The location associated with the outright league fixture snapshot.
     * Can be {@code null}.
     * 
     * @see Location
     */
    @Nullable public Location location;

    /**
     * The last update date of the outright league fixture snapshot in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The status of the outright league fixture snapshot.
     * 
     * @see FixtureStatus
     */
    public FixtureStatus status;

    /**
     * The extra data associated with the outright league fixture snapshot.
     * Can be {@code null}.
     * 
     * @see NameValuePair
     */
    @Nullable public Iterable<NameValuePair> extraData;
}