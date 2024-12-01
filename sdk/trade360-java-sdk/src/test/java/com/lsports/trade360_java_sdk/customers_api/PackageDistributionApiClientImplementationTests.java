package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
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
        client.getDistributionStatus();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Package/GetDistributionStatus"));
    }

    @Test
    public void startDistribution_calledWithCorrectUrl_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageDistributionApiClientImplementation(mockedClient);

        //Act
        client.startDistribution();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Distribution/Start"));
    }

    @Test
    public void stopDistributionCalledWithCorrectUrlCallsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageDistributionApiClientImplementation(mockedClient);

        //Act
        client.stopDistribution();

        //Assert
        verify(mockedClient).postRequest(any(), eq("Distribution/Stop"));
    }
}
