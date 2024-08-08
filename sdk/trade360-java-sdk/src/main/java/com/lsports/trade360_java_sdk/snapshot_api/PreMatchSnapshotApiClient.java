package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.LivescoreElement;

public interface PreMatchSnapshotApiClient {
    Iterable<FixtureEvent> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception;

    Iterable<LivescoreElement> getLivescore(GetLivescoreRequestDto getLivescoreRequestDto) throws Trade360Exception;
    
    Iterable<MarketEvent> getFixtureMarkets(GetMarketRequestDto getFixtureMarketsRequest) throws Trade360Exception;
}
