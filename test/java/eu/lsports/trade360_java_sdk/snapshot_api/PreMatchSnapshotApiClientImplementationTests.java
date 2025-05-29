package eu.lsports.trade360_java_sdk.snapshot_api;

import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.*;
import eu.lsports.trade360_java_sdk.snapshot_api.springframework.SnapshotApiRestClient;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class PreMatchSnapshotApiClientImplementationTests {
    @Test
    public void getFixtures_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetFixtures"));
    }

    @Test
    public void getLivescore_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetScores"));
    }
    
    @Test
    public void getFixtureMarkets_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetFixtureMarkets"));
    }

    @Test
    public void getEvents_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getEvents(new GetEventRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetEvents"));
    }

    @Test
    public void getOutrightsEvents_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightEvents(new GetOutrightEventRequest(
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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightEvents"));
    }

    @Test
    public void getOutrightFixture_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightFixture(new GetOutrightFixtureRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightFixture"));
    }

    @Test
    public void getOutrightScores_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightScores(new GetOutrightLivescoreRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightScores"));
    }

    @Test
    public void getOutrightFixtureMarkets_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightFixtureMarkets(new GetOutrightMarketRequest(
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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightFixtureMarkets"));
    }

    @Test
    public void getOutrightLeagues_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightLeagues(new GetOutrightLeaguesRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));

        // Assert
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightLeagues"));
    }

    @Test
    public void getOutrightLeagueMarkets_calledWithCorrectRequest_callsCorrectUrl(){
        // Arrange
        var mockedClient = mock(SnapshotApiRestClient.class);
        var client = new PreMatchSnapshotApiClientImplementation(mockedClient);

        // Act
        client.getOutrightLeagueMarkets(new GetOutrightLeagueMarketRequest(
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
        verify(mockedClient).postRequest(any(), any(), eq("/Prematch/GetOutrightLeagueMarkets"));
    }
}
