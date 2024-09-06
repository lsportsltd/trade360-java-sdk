package com.lsports.trade360_java_sdk.customers_api;

import org.junit.Test;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        client.getSports();

        //Assert
        verify(mockedClient).postRequest(any(), any(), eq("Sports/Get"));
    }
}
