package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.fixtures.Fixture;
import eu.lsports.trade360_java_sdk.common.entities.livescore.Livescore;
import eu.lsports.trade360_java_sdk.common.entities.markets.Market;

import jakarta.annotation.Nullable;

/**
 * Represents an element in the result of a get events request.
 *
 * @param fixtureId The ID of the fixture
 * @param fixture The fixture details
 * @param livescore The livescore details
 * @param markets The markets associated with the fixture
 * @see Fixture
 * @see Livescore
 * @see Market
 */
public final class GetEventsResultElement {
    public int fixtureId;
    @Nullable public Fixture fixture;
    @Nullable public Livescore livescore;
    @Nullable public Iterable<Market> markets;
}