package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import eu.lsports.trade360_java_sdk.common.entities.livescore.Livescore;
import eu.lsports.trade360_java_sdk.common.entities.markets.Market;

import jakarta.annotation.Nullable;

/**
 * Represents a result element containing event information.
 */
public class GetEventsResultElement {
    /** The unique identifier of the fixture. */
    public int fixtureId;

    /** The detailed fixture information. */
    @Nullable public Fixture fixture;

    /** The live score information for the fixture. */
    @Nullable public Livescore livescore;

    /** The collection of markets associated with this fixture. */
    @Nullable public Iterable<Market> markets;
}