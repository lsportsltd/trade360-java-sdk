package eu.lsports.trade360_java_sdk.common.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;

class SpringBootApiRestClientTest {
    @Test
    void testConstruction() {
        WebClient.Builder builder = WebClient.builder();
        JsonApiSerializer serializer = Mockito.mock(JsonApiSerializer.class);
        Mockito.when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        SpringBootApiRestClient client = new SpringBootApiRestClient(builder, serializer, URI.create("http://localhost"));
        assertNotNull(client);
    }
    // Add more tests for postRequest/getRequest as needed, mocking WebClient responses
} 