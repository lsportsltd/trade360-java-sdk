package com.lsports.trade360_java_sdk.snapshot_api;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.lsports.trade360_java_sdk.snapshot_api.http.SnapshotApiRestClient;

public class PreMatchSnapshotApiClientImplementationTests {
    @Test
    public void getFixtures_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), eq("/Prematch/GetFixtures"));
    }

    @Test
    public void getLivescore_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), eq("/Prematch/GetScores"));
    }
    
    @Test
    public void getFixtureMarkets_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), eq("/Prematch/GetFixtureMarkets"));
    }

    @Test
    public void getEvents_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), eq("/Prematch/GetEvents"));
    }

    @Test
    public void getOutrightsEvents_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightEvents(new GetSnapshotRequest(
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
        verify(mockedClient).postRequest(any(), eq("/Prematch/GetOutrightEvents"));
    }
}
