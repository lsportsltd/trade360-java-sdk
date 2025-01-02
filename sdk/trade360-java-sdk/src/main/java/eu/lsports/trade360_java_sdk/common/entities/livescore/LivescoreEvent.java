package eu.lsports.trade360_java_sdk.common.entities.livescore;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import jakarta.annotation.Nullable;

/**
 * The {@code LivescoreEvent} class represents a live score event associated with a fixture.
 */
public class LivescoreEvent {

    /**
     * The ID of the fixture associated with the live score event.
     */
    public int fixtureId;

    /**
     * The fixture associated with the live score event.
     * This can be {@code null} if not set.
     */
    @Nullable public Fixture fixture;

    /**
     * The live score information associated with the live score event.
     * This can be {@code null} if not set.
     */
    @Nullable public Livescore livescore;
}
