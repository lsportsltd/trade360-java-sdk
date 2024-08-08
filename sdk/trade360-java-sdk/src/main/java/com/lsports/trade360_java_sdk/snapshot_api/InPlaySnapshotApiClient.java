package com.lsports.trade360_java_sdk.snapshot_api;

import java.util.Collection;

import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;

public interface InPlaySnapshotApiClient {
    Collection<FixtureEvent> getFixtures(GetFixturesRequestDto getFixturesRequest) throws Trade360Exception;
}
