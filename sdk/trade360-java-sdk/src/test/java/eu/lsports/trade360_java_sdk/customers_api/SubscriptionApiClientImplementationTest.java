package eu.lsports.trade360_java_sdk.customers_api;

import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.PackageQuotaResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests.*;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.*;
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
import java.util.List;

class SubscriptionApiClientImplementationTest {

    @Mock
    private ApiRestClient apiRestClient;

    private SubscriptionApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new SubscriptionApiClientImplementation(apiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetPackageQuota() {
        BaseResponse<PackageQuotaResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(TypeReference.class), eq("/package/GetPackageQuota")))
                .thenReturn(Mono.just(expectedResponse));

        Mono<BaseResponse<PackageQuotaResponse>> result = client.getPackageQuota();

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testSubscribeByFixture() {
        BaseResponse<FixtureSubscriptionCollectionResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(FixtureSubscriptionRequest.class), any(TypeReference.class), eq("Fixtures/Subscribe")))
                .thenReturn(Mono.just(expectedResponse));

        FixtureSubscriptionRequest request = new FixtureSubscriptionRequest(List.of(1, 2, 3));
        Mono<BaseResponse<FixtureSubscriptionCollectionResponse>> result = client.subscribeByFixture(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }

    @Test
    void testGetSubscriptions() {
        BaseResponse<GetSubscriptionResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.postRequest(any(GetSubscriptionRequest.class), any(TypeReference.class), eq("Fixtures/Get")))
                .thenReturn(Mono.just(expectedResponse));

        GetSubscriptionRequest request = new GetSubscriptionRequest(List.of(1), List.of(2), List.of(3));
        Mono<BaseResponse<GetSubscriptionResponse>> result = client.getSubscriptions(request);

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
