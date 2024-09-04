package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.customers_api.http.ApiRestClient;
import com.lsports.trade360_java_sdk.customers_api.interfaces.PackageDistributionApiClient;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PackageDistributionApiClientImplementationTests {

    @Test
    public void getDistributionStatusAsync_calledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageDistributionApiClientImplementation(mockedClient);

        //Act
        var result = client.getDistributionStatusAsync();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Package/GetDistributionStatus"));
    }

    @Test
    public void StartDistribution_calledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageDistributionApiClientImplementation(mockedClient);

        //Act
        var result = client.StartDistribution();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Distribution/Start"));
    }

    @Test
    public void stopDistributionCalledWithCorrectUrlCallsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageDistributionApiClientImplementation(mockedClient);

        //Act
        var result = client.StopDistribution();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Distribution/Stop"));
    }
}
