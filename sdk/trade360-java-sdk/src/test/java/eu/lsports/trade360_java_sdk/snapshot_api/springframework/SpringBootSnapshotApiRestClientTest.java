package eu.lsports.trade360_java_sdk.snapshot_api.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.net.URI;
import org.springframework.http.client.reactive.ClientHttpConnector;

class SpringBootSnapshotApiRestClientTest {
    @Test
    void testInstantiation() {
        WebClient.Builder builder = mock(WebClient.Builder.class, RETURNS_DEEP_STUBS);
        // Mock the builder chain
        when(builder.baseUrl(anyString())).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        URI uri = URI.create("http://localhost");
        assertDoesNotThrow(() -> new SpringBootSnapshotApiRestClient(builder, serializer, uri));
    }
} 