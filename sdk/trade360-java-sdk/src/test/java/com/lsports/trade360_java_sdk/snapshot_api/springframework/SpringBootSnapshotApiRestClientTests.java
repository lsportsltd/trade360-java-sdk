package com.lsports.trade360_java_sdk.snapshot_api.springframework;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import org.springframework.web.client.RestClient;

import com.lsports.trade360_java_sdk.snapshot_api.JacksonSnapshotApiSerializer;
import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetFixturesRequestDto;

public class SpringBootSnapshotApiRestClientTests {
    private final SnapshotApiSettings apiSettings = new SnapshotApiSettings(
        URI.create("testhost"),
        1234,
        "testUser",
        "testPassword");

    @Test
    public void postRequest_allParametersProvided_allNecessaryPropertiesAreIncludedInRequest() {
        // Arrange
        final var expectedBody = "{\"FromDate\":1722470400000,\"ToDate\":1722988800000,\"Sports\":[1,2,3],\"Locations\":[4,5,6],\"Fixtures\":[7,8,9],\"Leagues\":[10,11,12],\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\"}";
        final var rawResponse = "{\"Header\":{},\"Body\":[]}";

        var restClientBuilder = RestClient.builder();
        var mockServer = MockRestServiceServer.bindTo(restClientBuilder).build();
        mockServer.expect(requestTo("testhost/"))
            .andExpect(content().json(expectedBody))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andRespond(withSuccess().contentType(MediaType.APPLICATION_OCTET_STREAM).body(rawResponse));

        var serializer = new JacksonSnapshotApiSerializer(apiSettings);
        var client = new SpringBootSnapshotApiRestClient(restClientBuilder, serializer, apiSettings);

        // Act
        client.postRequest(new GetFixturesRequestDto(
            ZonedDateTime.of(LocalDateTime.of(2024, 8, 1, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
            ZonedDateTime.of(LocalDateTime.of(2024, 8, 7, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9),
            List.of(10, 11, 12)
        ), "/");

        // Assert
        mockServer.verify();
    }

    @Test
    public void postRequest_optionalPropertiesNotProvided_nullsAreNotIncludedInRequest() {
        // Arrange
        final var expectedBody = "{\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\"}";
        final var rawResponse = "{\"Header\":{},\"Body\":[]}";

        var restClientBuilder = RestClient.builder();
        var mockServer = MockRestServiceServer.bindTo(restClientBuilder).build();
        mockServer.expect(requestTo("testhost/"))
            .andExpect(content().json(expectedBody))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andRespond(withSuccess().contentType(MediaType.APPLICATION_OCTET_STREAM).body(rawResponse));

        var serializer = new JacksonSnapshotApiSerializer(apiSettings);
        var client = new SpringBootSnapshotApiRestClient(restClientBuilder, serializer, apiSettings);
        
        // Act
        client.postRequest(
            new GetFixturesRequestDto(null, null, null, null, null, null),
            "/");

        // Assert
        mockServer.verify();
    }
}