package eu.lsports.trade360_java_sdk.common.springframework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SpringBootApiRestClientComprehensiveTest {

    @Mock
    private WebClient.Builder mockWebClientBuilder;

    @Mock
    private WebClient mockWebClient;

    @Mock
    private JsonApiSerializer mockSerializer;

    @Mock
    private ObjectMapper mockObjectMapper;

    private SpringBootApiRestClient restClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        when(mockSerializer.getObjectMapper()).thenReturn(mockObjectMapper);
        when(mockWebClientBuilder.baseUrl(any(String.class))).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.codecs(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.defaultHeaders(any())).thenReturn(mockWebClientBuilder);
        when(mockWebClientBuilder.build()).thenReturn(mockWebClient);
        
        URI baseUrl = URI.create("https://api.example.com");
        restClient = new SpringBootApiRestClient(mockWebClientBuilder, mockSerializer, baseUrl);
    }

    @Test
    void testConstructorWithValidParameters() {
        URI baseUrl = URI.create("https://api.example.com");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder.baseUrl(any(String.class))).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client = new SpringBootApiRestClient(builder, serializer, baseUrl);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithDifferentUrls() {
        URI baseUrl1 = URI.create("https://api1.example.com");
        URI baseUrl2 = URI.create("https://api2.example.com");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder1 = mock(WebClient.Builder.class);
        WebClient.Builder builder2 = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder1.baseUrl(any(String.class))).thenReturn(builder1);
        when(builder1.codecs(any())).thenReturn(builder1);
        when(builder1.defaultHeaders(any())).thenReturn(builder1);
        when(builder1.build()).thenReturn(mock(WebClient.class));
        
        when(builder2.baseUrl(any(String.class))).thenReturn(builder2);
        when(builder2.codecs(any())).thenReturn(builder2);
        when(builder2.defaultHeaders(any())).thenReturn(builder2);
        when(builder2.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client1 = new SpringBootApiRestClient(builder1, serializer, baseUrl1);
        SpringBootApiRestClient client2 = new SpringBootApiRestClient(builder2, serializer, baseUrl2);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testConstructorWithHttpsUrl() {
        URI httpsUrl = URI.create("https://secure-api.example.com");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder.baseUrl(any(String.class))).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client = new SpringBootApiRestClient(builder, serializer, httpsUrl);
        
        assertNotNull(client);
    }

    @Test
    void testConstructorWithPortSpecificUrl() {
        URI urlWithPort = URI.create("https://api.example.com:8080");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder.baseUrl(any(String.class))).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client = new SpringBootApiRestClient(builder, serializer, urlWithPort);
        
        assertNotNull(client);
    }

    @Test
    void testMainMethodExists() {
        assertDoesNotThrow(() -> SpringBootApiRestClient.main(new String[]{}));
    }

    @Test
    void testMainMethodWithArguments() {
        String[] args = {"arg1", "arg2", "arg3"};
        assertDoesNotThrow(() -> SpringBootApiRestClient.main(args));
    }

    @Test
    void testMainMethodWithEmptyArguments() {
        String[] args = {};
        assertDoesNotThrow(() -> SpringBootApiRestClient.main(args));
    }

    @Test
    void testMainMethodWithNullArguments() {
        assertDoesNotThrow(() -> SpringBootApiRestClient.main(null));
    }

    @Test
    void testConstructorBuilderConfiguration() {
        URI baseUrl = URI.create("https://api.example.com");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder.baseUrl(any(String.class))).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        
        new SpringBootApiRestClient(builder, serializer, baseUrl);
        
        verify(builder).baseUrl(baseUrl.toString());
        verify(builder).codecs(any());
        verify(builder).defaultHeaders(any());
        verify(builder).build();
    }

    @Test
    void testConstructorWithDifferentSerializers() {
        URI baseUrl = URI.create("https://api.example.com");
        JsonApiSerializer serializer1 = mock(JsonApiSerializer.class);
        JsonApiSerializer serializer2 = mock(JsonApiSerializer.class);
        WebClient.Builder builder1 = mock(WebClient.Builder.class);
        WebClient.Builder builder2 = mock(WebClient.Builder.class);
        
        when(serializer1.getObjectMapper()).thenReturn(new ObjectMapper());
        when(serializer2.getObjectMapper()).thenReturn(new ObjectMapper());
        
        when(builder1.baseUrl(any(String.class))).thenReturn(builder1);
        when(builder1.codecs(any())).thenReturn(builder1);
        when(builder1.defaultHeaders(any())).thenReturn(builder1);
        when(builder1.build()).thenReturn(mock(WebClient.class));
        
        when(builder2.baseUrl(any(String.class))).thenReturn(builder2);
        when(builder2.codecs(any())).thenReturn(builder2);
        when(builder2.defaultHeaders(any())).thenReturn(builder2);
        when(builder2.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client1 = new SpringBootApiRestClient(builder1, serializer1, baseUrl);
        SpringBootApiRestClient client2 = new SpringBootApiRestClient(builder2, serializer2, baseUrl);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }

    @Test
    void testConstructorWithComplexUrl() {
        URI complexUrl = URI.create("https://api.example.com:8080/v1/trade360");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        when(builder.baseUrl(any(String.class))).thenReturn(builder);
        when(builder.codecs(any())).thenReturn(builder);
        when(builder.defaultHeaders(any())).thenReturn(builder);
        when(builder.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client = new SpringBootApiRestClient(builder, serializer, complexUrl);
        
        assertNotNull(client);
        verify(builder).baseUrl(complexUrl.toString());
    }

    @Test
    void testMultipleClientInstances() {
        URI baseUrl = URI.create("https://api.example.com");
        JsonApiSerializer serializer = mock(JsonApiSerializer.class);
        WebClient.Builder builder1 = mock(WebClient.Builder.class);
        WebClient.Builder builder2 = mock(WebClient.Builder.class);
        
        when(serializer.getObjectMapper()).thenReturn(new ObjectMapper());
        
        when(builder1.baseUrl(any(String.class))).thenReturn(builder1);
        when(builder1.codecs(any())).thenReturn(builder1);
        when(builder1.defaultHeaders(any())).thenReturn(builder1);
        when(builder1.build()).thenReturn(mock(WebClient.class));
        
        when(builder2.baseUrl(any(String.class))).thenReturn(builder2);
        when(builder2.codecs(any())).thenReturn(builder2);
        when(builder2.defaultHeaders(any())).thenReturn(builder2);
        when(builder2.build()).thenReturn(mock(WebClient.class));
        
        SpringBootApiRestClient client1 = new SpringBootApiRestClient(builder1, serializer, baseUrl);
        SpringBootApiRestClient client2 = new SpringBootApiRestClient(builder2, serializer, baseUrl);
        
        assertNotNull(client1);
        assertNotNull(client2);
        assertNotSame(client1, client2);
    }
}
