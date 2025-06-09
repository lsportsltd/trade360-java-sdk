package eu.lsports.trade360_java_sdk.customers_api;

import eu.lsports.trade360_java_sdk.common.http.ApiRestClient;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetProviderOddsTypeResponse;
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

class PackageQueryApiClientImplementationTest {

    @Mock
    private ApiRestClient apiRestClient;

    private PackageQueryApiClientImplementation client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new PackageQueryApiClientImplementation(apiRestClient);
    }

    @Test
    void testConstructor() {
        assertNotNull(client);
    }

    @Test
    void testGetProviderOddsType() {
        BaseResponse<GetProviderOddsTypeResponse> expectedResponse = new BaseResponse<>();
        when(apiRestClient.getRequest(any(), any(TypeReference.class), eq("Package/GetProviderOddsType")))
                .thenReturn(Mono.just(expectedResponse));

        Mono<BaseResponse<GetProviderOddsTypeResponse>> result = client.getProviderOddsType();

        assertNotNull(result);
        assertEquals(expectedResponse, result.block());
    }
}
