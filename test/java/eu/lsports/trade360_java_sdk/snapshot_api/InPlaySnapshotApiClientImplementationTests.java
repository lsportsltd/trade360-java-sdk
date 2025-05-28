package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixtureRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetInPlayEventRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetLivescoreRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetMarketRequest;
import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class InPlaySnapshotApiClientImplementationTests {
    @Test
    public void getFixtures_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getFixtures(new GetFixtureRequest(
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
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getLivescore(new GetLivescoreRequest(
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
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getFixtureMarkets(new GetMarketRequest(
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
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new InPlaySnapshotApiClientImplementation(mockedClient);

        // Act
        client.getEvents(new GetInPlayEventRequest(
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
