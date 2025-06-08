package eu.lsports.trade360_java_sdk.customers_api.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PackageQueryApiClientTest {
    @Test
    void testInterfaceCanBeImplemented() {
        assertDoesNotThrow(() -> {
            class Impl implements PackageQueryApiClient {
                public reactor.core.publisher.Mono<eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse<eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetProviderOddsTypeResponse>> getProviderOddsType() { return null; }
            }
            new Impl();
        });
    }
} 