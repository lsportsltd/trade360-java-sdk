package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

import java.time.Instant;

/**
 * Represents the league-level competition element in a GetOutrightLeagueMarkets snapshot response.
 */
public final class OutrightLeagueMarketsCompetitionElement {
    /**
     * The unique identifier of the league competition element.
     */
    public int id;

    /**
     * The name of the league competition element.
     * Can be {@code null}.
     */
    @Nullable public String name;

    /**
     * The type of the league competition element.
     */
    public int type;

    /**
     * The start time of the next fixture in UTC.
     * Can be {@code null}.
     */
    @Nullable public Instant nextFixtureStartTime;

    /**
     * The nested season/competition elements associated with this league element.
     * Can be {@code null}.
     *
     * @see OutrightLeagueMarketsCompetition
     */
    @Nullable public Iterable<OutrightLeagueMarketsCompetition> competitions;
}
