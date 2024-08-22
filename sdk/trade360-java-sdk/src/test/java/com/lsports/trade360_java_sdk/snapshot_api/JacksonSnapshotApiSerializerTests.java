package com.lsports.trade360_java_sdk.snapshot_api;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Test;

import com.lsports.trade360_java_sdk.snapshot_api.configuration.SnapshotApiSettings;
import com.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;

public class JacksonSnapshotApiSerializerTests {
        private final SnapshotApiSettings apiSettings = new SnapshotApiSettings(
        URI.create("testhost"),
        1234,
        "testUser",
        "testPassword");

    @Test
    public void serialize_whenEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
        var serializer = new JacksonSnapshotApiSerializer(this.apiSettings);
        var request = new GetSnapshotRequest(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );

        // Act
        var result = serializer.serialize(request);

        // Assert
        assertEquals(
            "{\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\"}",
            result.toString()
        );
    }

    @Test
    public void serialize_whenNonEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
        var serializer = new JacksonSnapshotApiSerializer(this.apiSettings);
        var request = new GetSnapshotRequest(
            ZonedDateTime.of(LocalDateTime.of(2024, 8, 5, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
            ZonedDateTime.of(LocalDateTime.of(2024, 8, 1, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
            ZonedDateTime.of(LocalDateTime.of(2024, 8, 7, 0, 0), ZoneId.of(ZoneOffset.UTC.getId())),
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9),
            List.of(10, 11, 12),
            List.of(13, 14, 15),
            List.of(16, 17, 18)
        );

        // Act
        var result = serializer.serialize(request);

        // Assert
        assertEquals(
            "{\"Timestamp\":1722816000000,\"FromDate\":1722470400000,\"ToDate\":1722988800000,\"Sports\":[1,2,3],\"Locations\":[4,5,6],\"Leagues\":[7,8,9],\"Tournaments\":[10,11,12],\"Fixtures\":[13,14,15],\"Markets\":[16,17,18],\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\"}",
            result.toString()
        );
    }
}
