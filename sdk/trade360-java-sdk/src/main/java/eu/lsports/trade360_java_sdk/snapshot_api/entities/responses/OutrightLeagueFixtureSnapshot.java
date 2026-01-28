package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import java.time.Instant;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;

import jakarta.annotation.Nullable;

/**
 * Represents a snapshot of an outright league fixture.
 */
public final class OutrightLeagueFixtureSnapshot {
    /**
     * The name of the fixture.
     * Can be {@code null}.
     */
    @Nullable
    public String fixtureName;

    /**
     * The subscription associated with the outright league fixture snapshot.
     * Can be {@code null}.
     * 
     * @see Subscription
     */
    @Nullable
    public Subscription subscription;

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
    public Instant lastUpdate;

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


    /**
     * The end date of the outright league fixture snapshot in UTC.
     */
    public Instant endDate;

    /**
     * The season associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair season;
}