package com.lsports.trade360_java_sdk.snapshot_api;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;

public class InPlaySnapshotApiClientImplementationTests {
    @Test
    public void getFixtures_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getFixtures(new GetSnapshotRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Inplay/GetFixtures"));
    }

    @Test
    public void getLivescore_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getLivescore(new GetSnapshotRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Inplay/GetScores"));
    }

    @Test
    public void getFixtureMarkets_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getFixtureMarkets(new GetSnapshotRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Inplay/GetFixtureMarkets"));
    }

    @Test
    public void getEvents_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getEvents(new GetSnapshotRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Inplay/GetEvents"));
    }
}
