package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.League;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.LeagueMetadata;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

/**
 * Represents the schedule of a fixture.
 */
public class FixtureSchedule {
    /**
     * The ID of the fixture.
     */
    public int fixtureId;

    /**
     * The sport associated with the fixture.
     *
     * @see Sport
     */
    @Nullable public Sport sport;

    /**
     * The location of the fixture.
     *
     * @see Location
     */
    @Nullable public Location location;

    /**
     * The league of the fixture.
     *
     * @see League
     */
    @Nullable public LeagueMetadata league;

    /**
     * The start date of the fixture in UTC.
     */
    public LocalDateTime startDate;

    /**
     * The last update time of the fixture in UTC.
     */
    public LocalDateTime lastUpdate;

    /**
     * The status of the fixture.
     */
    public int status;

    /**
     * The participants of the fixture.
     *
     * @see ParticipantSchedule
     */
    @Nullable public Iterable<ParticipantSchedule> participants;
}