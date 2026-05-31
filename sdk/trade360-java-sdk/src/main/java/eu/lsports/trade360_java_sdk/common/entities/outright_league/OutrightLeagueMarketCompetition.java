package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import jakarta.annotation.Nullable;

import java.time.Instant;

/**
 * The {@code OutrightLeagueMarketCompetition} class represents a competition in an outright league market update (type 40).
 */
public class OutrightLeagueMarketCompetition extends OutrightLeagueCompetition<MarketEvent> {

    /**
     * The start time of the next fixture in UTC.
     * This can be {@code null} if not set.
     */
    @Nullable public Instant nextFixtureStartTime;
}
