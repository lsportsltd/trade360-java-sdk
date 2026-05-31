package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import jakarta.annotation.Nullable;

/**
 * Represents an element of the result for outright league markets.
 */
public final class GetOutrightLeagueMarketsResultElement {
    /**
     * The league competition elements returned by the snapshot API.
     * Can be {@code null}.
     *
     * @see OutrightLeagueMarketsCompetitionElement
     */
    @Nullable public Iterable<OutrightLeagueMarketsCompetitionElement> competition;
}
