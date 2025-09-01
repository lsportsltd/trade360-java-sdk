package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;

/**
 * The {@code OutrightLeagueEvent} class represents an event related to an outright league.
 */
public class OutrightLeagueEvent {
    /**
     * The ID of the fixture.
     */
    public int fixtureId;

    /**
     * The outright league associated with the event.
     */
    public OutrightLeagueFixture outrightLeague;

    /**
     * The markets associated with the event.
     */
    public Iterable<MarketLeague> markets;
}
