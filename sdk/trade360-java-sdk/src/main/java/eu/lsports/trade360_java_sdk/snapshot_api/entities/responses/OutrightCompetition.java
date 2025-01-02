package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an outright competition.
 */
public final class OutrightCompetition {
    /**
     * The unique identifier of the fixture.
     */
    public int fixtureId;

    /**
     * The outright league fixture snapshot associated with this competition.
     * Can be {@code null}.
     * 
     * @see OutrightLeagueFixtureSnapshot
     */
    @Nullable public OutrightLeagueFixtureSnapshot outrightLeague;
}