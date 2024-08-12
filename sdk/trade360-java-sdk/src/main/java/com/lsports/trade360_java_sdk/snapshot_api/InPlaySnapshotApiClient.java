package com.lsports.trade360_java_sdk.snapshot_api;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetEventsRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetEventsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixtureMarketsResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetFixturesResultElement;
import com.lsports.trade360_java_sdk.snapshot_api.entities.responses.GetLivescoreResultElement;

public interface InPlaySnapshotApiClient {
    Iterable<GetFixturesResultElement> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception;
    
    Iterable<GetLivescoreResultElement> getLivescore(GetLivescoreRequestDto getLivescoreRequestDto) throws Trade360Exception;

    Iterable<GetFixtureMarketsResultElement> getFixtureMarkets(GetMarketRequestDto getFixtureMarketsRequest) throws Trade360Exception;

    Iterable<GetEventsResultElement> getEvents(GetEventsRequestDto getEventsRequest) throws Trade360Exception;
}
