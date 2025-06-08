package eu.lsports.trade360_java_sdk.common.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import org.junit.Test;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

public class JacksonApiSerializerTest {
    private PackageCredentials credentials;
    private JacksonApiSerializer serializer;

    @BeforeEach
    void setUp() {
        credentials = mock(PackageCredentials.class);
        when(credentials.packageId()).thenReturn(123);
        when(credentials.userName()).thenReturn("user");
        when(credentials.password()).thenReturn("pass");
        when(credentials.messageFormat()).thenReturn("json");
        serializer = new JacksonApiSerializer(credentials);
    }

    @Test
    public void serializeRequest_whenEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
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
            123,
            result.get("PackageId").asInt()
        );
        assertEquals(
            "user",
            result.get("UserName").asText()
        );
        assertEquals(
            "pass",
            result.get("Password").asText()
        );
        assertEquals(
            "json",
            result.get("MessageFormat").asText()
        );
    }

    @Test
    public void serializeRequest_whenNonEmptyRequestProvided_appendsCredentialsToFinalJson() {
        // Arrange
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
            123,
            result.get("PackageId").asInt()
        );
        assertEquals(
            "user",
            result.get("UserName").asText()
        );
        assertEquals(
            "pass",
            result.get("Password").asText()
        );
        assertEquals(
            "json",
            result.get("MessageFormat").asText()
        );
        assertEquals(
            1722816000000L,
            result.get("Timestamp").asLong()
        );
        assertEquals(
            1722470400000L,
            result.get("FromDate").asLong()
        );
        assertEquals(
            1722988800000L,
            result.get("ToDate").asLong()
        );
        assertEquals(
            "[1,2,3]",
            result.get("Sports").toString()
        );
        assertEquals(
            "[4,5,6]",
            result.get("Locations").toString()
        );
        assertEquals(
            "[7,8,9]",
            result.get("Leagues").toString()
        );
        assertEquals(
            "[10,11,12]",
            result.get("Tournaments").toString()
        );
        assertEquals(
            "[13,14,15]",
            result.get("Fixtures").toString()
        );
        assertEquals(
            "[16,17,18]",
            result.get("Markets").toString()
        );
    }

    @Test
    void testSerializeAndDeserialize() throws Exception {
        SimplePojo pojo = new SimplePojo("hello", 42);
        String json = serializer.serializeToString(pojo);
        assertTrue(json.contains("hello"));
        JsonNode node = serializer.deserializeToTree(json);
        assertEquals("hello", node.get("foo").asText());
        assertEquals(42, node.get("bar").asInt());
    }

    @Test
    void testSerializeRequest_WithCredentials() {
        ObjectNode node = serializer.serializeRequest(new DummyRequest("foo"));
        assertEquals(123, node.get("PackageId").asInt());
        assertEquals("user", node.get("UserName").asText());
        assertEquals("pass", node.get("Password").asText());
        assertEquals("json", node.get("MessageFormat").asText());
        assertEquals("foo", node.get("value").asText());
    }

    @Test
    void testSerializeToString_Valid() throws JsonProcessingException {
        DummyRequest req = new DummyRequest("bar");
        String json = serializer.serializeToString(req);
        assertTrue(json.contains("bar"));
    }

    @Test
    void testSerializeRequest_NullRequest() {
        ObjectNode node = serializer.serializeRequest(null);
        assertEquals(123, node.get("PackageId").asInt());
        assertEquals("user", node.get("UserName").asText());
        assertEquals("pass", node.get("Password").asText());
        assertEquals("json", node.get("MessageFormat").asText());
    }

    static class SimplePojo {
        public String foo;
        public int bar;
        public SimplePojo() {}
        public SimplePojo(String foo, int bar) { this.foo = foo; this.bar = bar; }
    }

    static class DummyRequest {
        public String value;
        DummyRequest(String value) { this.value = value; }
    }
}
