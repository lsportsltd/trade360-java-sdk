package com.lsports.trade360_java_sdk.common.entities.fixtures;

import jakarta.annotation.Nullable;

/**
 * The {@code FixtureEvent} class represents an event related to a fixture.
 */
public class FixtureEvent {

    /**
     * The ID of the fixture.
     */
    public int fixtureId;

    /**
     * The fixture associated with the event.
     * This can be {@code null} if not set.
     */
    @Nullable public Fixture fixture;
}