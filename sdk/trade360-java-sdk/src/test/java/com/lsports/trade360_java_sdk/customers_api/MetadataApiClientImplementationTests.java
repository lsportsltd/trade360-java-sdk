package com.lsports.trade360_java_sdk.customers_api;

import org.junit.Test;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetLocationsRequest;
import com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests.GetSportsRequest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
}
