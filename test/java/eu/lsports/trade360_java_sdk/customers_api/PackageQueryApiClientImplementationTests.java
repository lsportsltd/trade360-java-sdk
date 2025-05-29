package eu.lsports.trade360_java_sdk.customers_api;

import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;

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