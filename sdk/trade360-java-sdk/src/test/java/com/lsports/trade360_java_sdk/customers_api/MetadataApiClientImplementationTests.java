package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import org.junit.Test;

import com.lsports.trade360_java_sdk.common.entities.enums.SubscriptionState;
import com.lsports.trade360_java_sdk.common.entities.enums.MarketType;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetCompetitionsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLeaguesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetMarketsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesMetadataRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSubscribedFixturesRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetTranslationsRequest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.List;

public class MetadataApiClientImplementationTests {

    @Test
    public void getSports_parameterlessCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getSports();

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Sports/Get"));
    }

    @Test
    public void getSports_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getSports(new GetSportsRequest(2));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Sports/Get"));
    }

    @Test
    public void getLocations_parameterlessCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getLocations();

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Locations/Get"));
    }

    @Test
    public void getLocations_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getLocations(new GetLocationsRequest(2));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Locations/Get"));
    }

    @Test
    public void getLeagues_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getLeagues(new GetLeaguesRequest(List.of(1), List.of(2), SubscriptionState.ALL, 2));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Leagues/Get"));
    }

    @Test
    public void getMarkets_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getMarkets(new GetMarketsRequest(List.of(1), List.of(2), List.of(3), List.of(4), false, MarketType.ALL, 2));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Markets/Get"));
    }

    @Test
    public void getTranslations_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getTranslations(new GetTranslationsRequest(List.of(1), List.of(2), List.of(3), List.of(4), List.of(5), List.of(6)));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Translation/Get"));
    }

    @Test
    public void getCompetitions_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getCompetitions(new GetCompetitionsRequest(List.of(1), List.of(2), List.of(3), SubscriptionState.ALL));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Outright/GetCompetitions"));
    }

    @Test
    public void getSubscribedFixtures_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getSubscribedFixtures(new GetSubscribedFixturesRequest(List.of(1), List.of(2), List.of(3)));

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Fixtures/Get"));
    }

    @Test
    public void getSubscribedFixturesMetadata_withParameterCalledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new MetadataApiClientImplementation(mockedClient);

        //Act
        client.getSubscribedFixturesMetadata(new GetSubscribedFixturesMetadataRequest(LocalDate.now(), LocalDate.now(), null, null, null));

        //Assert
        verify(mockedClient).getRequest(any(), any(), eq("Fixtures/GetSubscribedMetaData"));
    }
}
