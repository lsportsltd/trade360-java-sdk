package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

import java.time.LocalDateTime;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import jakarta.annotation.Nullable;

/**
 * The {@code Fixture} class represents a sports fixture.
 */
public class Fixture {

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
     * The venue of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public FixtureVenue venue;

    /**
     * The league associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public League league;

    /**
     * The stage associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public IdNamePair stage;

    /**
     * The round associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public IdNamePair round;

    /**
     * The start date and time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public LocalDateTime startDate;

    /**
     * The last update date and time of the fixture in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The status of the fixture.
     */
    public FixtureStatus status;

    /**
     * The participants in the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<Participant> participants;

    /**
     * Extra data associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<NameValuePair> fixtureExtraData;

    /**
     * The external ID of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public String externalFixtureId;

    /**
     * The subscription associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public Subscription subscription;
}
