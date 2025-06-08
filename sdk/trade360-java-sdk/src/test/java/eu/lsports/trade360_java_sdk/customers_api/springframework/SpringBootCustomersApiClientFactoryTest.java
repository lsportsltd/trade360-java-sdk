package eu.lsports.trade360_java_sdk.customers_api.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SpringBootCustomersApiClientFactoryTest {
    @Test
    void testInstantiation() {
        WebClient.Builder builder = mock(WebClient.Builder.class);
        assertDoesNotThrow(() -> new SpringBootCustomersApiClientFactory(builder));
    }
} 