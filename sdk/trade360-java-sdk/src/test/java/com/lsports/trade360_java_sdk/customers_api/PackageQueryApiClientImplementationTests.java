package com.lsports.trade360_java_sdk.customers_api;

import com.lsports.trade360_java_sdk.common.http.ApiRestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PackageQueryApiClientImplementationTests {
    @org.junit.Test
    public void getPackageQueryApiClientImplementationAsync_callsCorrectUrl() {

        //Arrange
        var mockedClient = mock(ApiRestClient.class);
        var client = new PackageQueryApiClientImplementation(mockedClient);

        //Act
        client.getProviderOddsType();

        //Assert
        verify(mockedClient).getRequest(any(), any(), eq("Package/GetProviderOddsType"));
    }
}