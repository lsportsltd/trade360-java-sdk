package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import java.time.Instant;
import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixtureVenue;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightFixture} class represents a fixture in an outright sport.
 */
public class OutrightFixture {

    /**
     * The name of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String fixtureName;

    /**
     * The sport associated with the fixture.
     */
    public Sport sport;

    /**
     * The location of the fixture.
     */
    public Location location;

    /**
     * The venue of the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable public FixtureVenue venue;

    /**
     * The start date and time of the fixture in UTC.
     */
    public Instant startDate;

    /**
     * The last update date and time of the fixture in UTC.
     */
    public Instant lastUpdate;

    /**
     * The status of the fixture.
     */
    public FixtureStatus status;

    /**
     * The participants in the fixture.
     */
    public Iterable<OutrightParticipant> participants;

    /**
     * Extra data associated with the fixture.
     */
    public Iterable<NameValuePair> extraData;

    /**
     * The subscription associated with the fixture.
     */
    public Subscription subscription;

    /**
     * The season associated with the fixture.
     * This can be {@code null} if not set.
     */
    @Nullable
    public IdNamePair season;
}