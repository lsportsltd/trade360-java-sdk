package eu.lsports.trade360_java_sdk.feed.rabbitmq.handlers;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.GetDistributionStatusResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses.StartDistributionResponse;
import eu.lsports.trade360_java_sdk.customers_api.interfaces.CustomersApiClientFactory;
import eu.lsports.trade360_java_sdk.customers_api.PackageDistributionApiClientImplementation;
import eu.lsports.trade360_java_sdk.feed.rabbitmq.configurations.RabbitConnectionConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PackageDistributionHandlerTest {
    private CustomersApiClientFactory apiClientFactory;
    private RabbitConnectionConfiguration configuration;
    private PackageDistributionApiClientImplementation client;
    private PackageDistributionHandler handler;

    @BeforeEach
    void setUp() {
        apiClientFactory = mock(CustomersApiClientFactory.class);
        configuration = mock(RabbitConnectionConfiguration.class);
        client = mock(PackageDistributionApiClientImplementation.class);
        when(configuration.getBase_customers_api()).thenReturn("http://localhost");
        when(configuration.getPackage_id()).thenReturn(1);
        when(configuration.getUser_name()).thenReturn("user");
        when(configuration.getPassword()).thenReturn("pass");
        when(apiClientFactory.createPackageDistributionHttpClient(any(URI.class), any(PackageCredentials.class))).thenReturn(client);
        handler = new PackageDistributionHandler(apiClientFactory, configuration);
    }

    @Test
    void testProcessDistributionAlreadyStarted() {
        GetDistributionStatusResponse status = new GetDistributionStatusResponse();
        status.isDistributionOn = true;
        BaseResponse<GetDistributionStatusResponse> baseResponse = new BaseResponse<>();
        baseResponse.body = status;
        when(client.getDistributionStatus()).thenReturn(Mono.just(baseResponse));
        assertDoesNotThrow(() -> handler.process());
    }

    @Test
    void testProcess_DistributionNotStarted_StartsDistribution() {
        GetDistributionStatusResponse status = new GetDistributionStatusResponse();
        status.isDistributionOn = false;
        BaseResponse<GetDistributionStatusResponse> baseResponse = new BaseResponse<>();
        baseResponse.body = status;
        StartDistributionResponse startResponse = new StartDistributionResponse();
        BaseResponse<StartDistributionResponse> baseStartResponse = new BaseResponse<>();
        baseStartResponse.body = startResponse;
        when(client.getDistributionStatus()).thenReturn(Mono.just(baseResponse));
        when(client.startDistribution()).thenReturn(Mono.just(baseStartResponse));
        assertDoesNotThrow(() -> handler.process());
    }

    @Test
    void testProcessDistributionStatusNullThrows() {
        when(client.getDistributionStatus()).thenReturn(Mono.just(new BaseResponse<>()));
        assertThrows(IllegalStateException.class, () -> handler.process());
    }

    @Test
    void testProcess_StartDistributionNull_Throws() {
        GetDistributionStatusResponse status = new GetDistributionStatusResponse();
        status.isDistributionOn = false;
        BaseResponse<GetDistributionStatusResponse> baseResponse = new BaseResponse<>();
        baseResponse.body = status;
        when(client.getDistributionStatus()).thenReturn(Mono.just(baseResponse));
        when(client.startDistribution()).thenReturn(Mono.just(new BaseResponse<>()));
        assertThrows(IllegalStateException.class, () -> handler.process());
    }
} 