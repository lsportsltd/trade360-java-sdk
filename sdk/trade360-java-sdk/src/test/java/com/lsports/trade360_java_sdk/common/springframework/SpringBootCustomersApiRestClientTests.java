package com.lsports.trade360_java_sdk.common.springframework;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Consumer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lsports.trade360_java_sdk.common.configuration.JacksonApiSerializer;
import com.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import com.lsports.trade360_java_sdk.common.exceptions.Trade360Exception;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class SpringBootCustomersApiRestClientTests {
    private MockWebServer mockServer;
    private PackageCredentials packageCredentials;
    private URI baseUrl;

    @Before
    public void initialize() throws IOException {
        this.mockServer = new MockWebServer();
        this.mockServer.start();
        baseUrl = URI.create(String.format("http://localhost:%s", mockServer.getPort()));
        packageCredentials = new PackageCredentials(
            1234,
            "testUser",
            "testPassword");
    }

    @After
    public void tearDown() throws IOException {
        this.mockServer.shutdown();
    }

    @Test
    public void postRequest_allParametersProvided_allNecessaryPropertiesAreIncludedInRequest() {
        // Arrange
        final var expectedBody = "{\"Timestamp\":1722816000000,\"FromDate\":1722470400000,\"ToDate\":1722988800000,\"Sports\":[1,2,3],\"Locations\":[4,5,6],\"Leagues\":[7,8,9],\"Tournaments\":[10,11,12],\"Fixtures\":[13,14,15],\"Markets\":[16,17,18],\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\",\"MessageFormat\":\"json\"}";
        final var rawResponse = "{\"Header\":{},\"Body\":[]}";

        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(WebClient.builder(), serializer, baseUrl);

        this.prepareResponse(response -> response
            .setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM)
            .setResponseCode(HttpStatus.OK.value())
            .setBody(rawResponse));

        // Act
        client
            .postRequest(
                new GetSnapshotRequest(
                    ZonedDateTime.of(LocalDateTime.of(2024, 8, 5, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
                    ZonedDateTime.of(LocalDateTime.of(2024, 8, 1, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
                    ZonedDateTime.of(LocalDateTime.of(2024, 8, 7, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
                    List.of(1, 2, 3),
                    List.of(4, 5, 6),
                    List.of(7, 8, 9),
                    List.of(10, 11, 12),
                    List.of(13, 14, 15),
                    List.of(16, 17, 18)),
                new TypeReference<Object>() {},
                "/")
            .subscribe();

        // Assert
        this.expectRequest(request -> {
            var body = request.getBody().readString(StandardCharsets.UTF_8);
            assertEquals(expectedBody, body);
        });
    }

    @Test
    public void postRequest_optionalPropertiesNotProvided_nullsAreNotIncludedInRequest() {
        // Arrange
        final var expectedBody = "{\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\",\"MessageFormat\":\"json\"}";
        final var rawResponse = "{\"Header\":{},\"Body\":[]}";

        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(WebClient.builder(), serializer, baseUrl);

        this.prepareResponse(response -> response
            .setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM)
            .setResponseCode(HttpStatus.OK.value())
            .setBody(rawResponse));
        
        // Act
        client.postRequest(
            new GetSnapshotRequest(null, null, null, null, null, null, null, null, null),
            new TypeReference<Object>() {},
            "/")
            .subscribe();

        // Assert
        this.expectRequest(request -> {
            var body = request.getBody().readString(StandardCharsets.UTF_8);
            assertEquals(expectedBody, body);
        });
    }

    @Test
    public void postRequest_oneErrorInResponse_isParsedCorrectly() {
        // Arrange
        final var errorMessage = "Test error";
        final var expectedExceptionMessage = "Request failed because of 400 BAD_REQUEST.";
        final var rawResponse = "{\"Header\":{\"Errors\":[{\"Message\":\"" + errorMessage + "\"}]},\"Body\":[]}";

        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(WebClient.builder(), serializer, baseUrl);

        this.prepareResponse(response -> response
            .setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM)
            .setResponseCode(HttpStatus.BAD_REQUEST.value())
            .setBody(rawResponse));
        
        // Act
        var mono = client.postRequest(
            new GetSnapshotRequest(null, null, null, null, null, null, null, null, null),
            new TypeReference<Object>() {},
            "/");

        // Assert
        try {
            mono.block();
        } catch (Trade360Exception ex) {
            assertEquals(expectedExceptionMessage, ex.getMessage());
            assertIterableEquals(List.of(errorMessage), ex.getErrors());
        }
    }

    @Test
    public void postRequest_manyErrorInResponse_isParsedCorrectly() {
        // Arrange
        final var errorMessage1 = "Test error";
        final var errorMessage2 = "Wow, another error!";
        final var expectedExceptionMessage = "Request failed because of 400 BAD_REQUEST.";
        final var rawResponse = "{\"Header\":{\"Errors\":[{\"Message\":\"" + errorMessage1 + "\"},{\"Message\":\"" + errorMessage2 + "\"}]},\"Body\":[]}";

        var serializer = new JacksonApiSerializer(packageCredentials);
        var client = new SpringBootApiRestClient(WebClient.builder(), serializer, baseUrl);

        this.prepareResponse(response -> response
            .setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM)
            .setResponseCode(HttpStatus.BAD_REQUEST.value())
            .setBody(rawResponse));
        
        // Act
        var mono = client.postRequest(
            new GetSnapshotRequest(null, null, null, null, null, null, null, null, null),
            new TypeReference<Object>() {},
            "/");

        // Assert
        try {
            mono.block();
        } catch (Trade360Exception ex) {
            assertEquals(expectedExceptionMessage, ex.getMessage());
            assertIterableEquals(List.of(errorMessage1, errorMessage2), ex.getErrors());
        }
    }

    private void prepareResponse(Consumer<MockResponse> consumer) {
		MockResponse response = new MockResponse();
		consumer.accept(response);
		this.mockServer.enqueue(response);
	}

    private void expectRequest(Consumer<RecordedRequest> consumer) {
		try {
			consumer.accept(this.mockServer.takeRequest());
		}
		catch (InterruptedException ex) {
			throw new IllegalStateException(ex);
		}
	}
}