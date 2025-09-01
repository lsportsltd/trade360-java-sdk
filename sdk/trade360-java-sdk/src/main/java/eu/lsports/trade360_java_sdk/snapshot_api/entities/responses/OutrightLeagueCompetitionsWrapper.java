package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;

public class OutrightLeagueCompetitionsWrapper<T> {
    public Iterable<OutrightLeagueCompetition<T>> competition;
}
