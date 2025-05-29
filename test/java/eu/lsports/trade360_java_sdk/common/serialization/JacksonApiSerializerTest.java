package eu.lsports.trade360_java_sdk.common.serialization;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import org.junit.Test;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;

public class JacksonApiSerializerTest {
        private final PackageCredentials packageCredentials = new PackageCredentials(
        1234,
        "testUser",
        "testPassword");

    @Test
    public void serializeRequest_whenEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
        var serializer = new JacksonApiSerializer(this.packageCredentials);
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
        var result = serializer.serializeRequest(request);

        // Assert
        assertEquals(
            "{\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\",\"MessageFormat\":\"json\"}",
            result.toString()
        );
    }

    @Test
    public void serializeRequest_whenNonEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
        var serializer = new JacksonApiSerializer(this.packageCredentials);
        var request = new GetSnapshotRequest(
            LocalDateTime.of(2024, 8, 5, 0, 0),
            LocalDateTime.of(2024, 8, 1, 0, 0),
            LocalDateTime.of(2024, 8, 7, 0, 0),
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9),
            List.of(10, 11, 12),
            List.of(13, 14, 15),
            List.of(16, 17, 18)
        );

        // Act
        var result = serializer.serializeRequest(request);

        // Assert
        assertEquals(
            "{\"Timestamp\":1722816000000,\"FromDate\":1722470400000,\"ToDate\":1722988800000,\"Sports\":[1,2,3],\"Locations\":[4,5,6],\"Leagues\":[7,8,9],\"Tournaments\":[10,11,12],\"Fixtures\":[13,14,15],\"Markets\":[16,17,18],\"PackageId\":1234,\"UserName\":\"testUser\",\"Password\":\"testPassword\",\"MessageFormat\":\"json\"}",
            result.toString()
        );
    }
}
