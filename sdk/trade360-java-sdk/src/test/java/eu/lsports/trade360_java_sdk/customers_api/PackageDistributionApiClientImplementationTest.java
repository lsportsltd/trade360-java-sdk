package eu.lsports.trade360_java_sdk.customers_api;

import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StopDistributionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.core.type.TypeReference;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PackageDistributionApiClientImplementationTest {

    @Mock
    private ApiRestClient apiRestClient;

    private PackageDistributionApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new PackageDistributionApiClientImplementation(apiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetDistributionStatus() {
        BaseResponse<GetDistributionStatusResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(TypeReference.class), eq("Package/GetDistributionStatus")))
                .thenReturn(Mono.just(expectedResponse));

        Mono<BaseResponse<GetDistributionStatusResponse>> result = client.getDistributionStatus();

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testStartDistribution() {
        BaseResponse<StartDistributionResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(TypeReference.class), eq("Distribution/Start")))
                .thenReturn(Mono.just(expectedResponse));

        Mono<BaseResponse<StartDistributionResponse>> result = client.startDistribution();

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testStopDistribution() {
        BaseResponse<StopDistributionResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(TypeReference.class), eq("Distribution/Stop")))
                .thenReturn(Mono.just(expectedResponse));

        Mono<BaseResponse<StopDistributionResponse>> result = client.stopDistribution();

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
