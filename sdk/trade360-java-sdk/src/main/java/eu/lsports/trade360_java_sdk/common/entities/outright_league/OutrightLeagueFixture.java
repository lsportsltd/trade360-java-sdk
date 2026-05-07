package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import jakarta.annotation.Nullable;

import java.time.Instant;

/**
 * The {@code OutrightLeagueFixture} class represents a fixture in an outright league.
 */
public class OutrightLeagueFixture {

    /**
     * The name of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String fixtureName;

    /**
     * The subscription associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Subscription subscription;

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
     * The start date time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public Instant startDate;

    /**
     * The last update time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public Instant lastUpdate;


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

    /**
     * The End Date time of the fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable
    public Instant endDate;

    /**
     * The season associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair season;
}