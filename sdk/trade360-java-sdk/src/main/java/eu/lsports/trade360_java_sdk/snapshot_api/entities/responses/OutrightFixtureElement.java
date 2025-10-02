package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import java.time.LocalDateTime;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixtureVenue;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Participant;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;

import jakarta.annotation.Nullable;

/**
 * Represents an outright fixture element.
 */
public final class OutrightFixtureElement {
    /**
     * The sport associated with the outright fixture element.
     * Can be {@code null}.
     * 
     * @see Sport
     */
    @Nullable public Sport sport;

    /**
     * The location associated with the outright fixture element.
     * Can be {@code null}.
     * 
     * @see Location
     */
    @Nullable public Location location;

    /**
     * The start date of the outright fixture element in UTC.
     * Can be {@code null}.
     */
    @Nullable public LocalDateTime startDate;

    /**
     * The last update date of the outright fixture element in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The status of the outright fixture element.
     * 
     * @see FixtureStatus
     */
    public FixtureStatus status;

    /**
     * The participants associated with the outright fixture element.
     * Can be {@code null}.
     * 
     * @see Participant
     */
    @Nullable public Iterable<Participant> participants;

    /**
     * The subscription associated with the outright fixture element.
     * Can be {@code null}.
     * 
     * @see Subscription
     */
    @Nullable public Subscription subscription;

    /**
     * The venue of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public FixtureVenue venue;
}