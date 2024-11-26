package com.lsports.trade360_java_sdk.common.entities.outright_sport;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;
import com.lsports.trade360_java_sdk.common.entities.fixtures.*;
import com.lsports.trade360_java_sdk.common.entities.shared.*;

/**
 * The {@code OutrightFixture} class represents a fixture in an outright sport.
 */
public class OutrightFixture {

    /**
     * The sport associated with the fixture.
     */
    public Sport sport;

    /**
     * The location of the fixture.
     */
    public Location location;

    /**
     * The start date and time of the fixture in UTC.
     */
    public LocalDateTime startDate;

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
}