package com.lsports.trade360_java_sdk.snapshot_api;

import java.util.List;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import com.lsports.trade360_java_sdk.common.entities.fixtures.FixtureEvent;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequestDto;

public class PreMatchSnapshotApiClientImplementationTests {
    @Test
    public void getFixtures_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        when(mockedClient.<GetFixturesRequestDto, Iterable<FixtureEvent>>postRequest(any(), anyString()))
            .thenReturn(List.of());
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getFixtures(new GetFixturesRequestDto(
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
        when(mockedClient.<GetFixturesRequestDto, Iterable<FixtureEvent>>postRequest(any(), anyString()))
            .thenReturn(List.of());
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getLivescore(new GetLivescoreRequestDto(
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
}
