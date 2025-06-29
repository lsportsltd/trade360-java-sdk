package eu.lsports.trade360_java_sdk.common.serialization;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import eu.lsports.trade360_java_sdk.common.configuration.PackageCredentials;
import org.junit.jupiter.api.Test;
import eu.lsports.trade360_java_sdk.snapshot_api.entities.requests.GetSnapshotRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.core.type.TypeReference;

public class JacksonApiSerializerTest {
    private JacksonApiSerializer serializer;

    @BeforeEach
    void setUp() {
        PackageCredentials credentials = mock(PackageCredentials.class);
        when(credentials.packageId()).thenReturn(123);
        when(credentials.userName()).thenReturn("user");
        when(credentials.password()).thenReturn("pass");
        when(credentials.messageFormat()).thenReturn("json");
        serializer = new JacksonApiSerializer(credentials);
    }

    @Test
    public void serializeRequestWithEmptyRequestAppendsCredentialsToFinalJson() {
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
    public void serializeRequestWithNonEmptyRequestAppendsCredentialsToFinalJson() {
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
    public void testSerializeAndDeserialize() throws Exception {
        SimplePojo pojo = new SimplePojo("hello", 42);
        String json = serializer.serializeToString(pojo);
        assertTrue(json.contains("hello"));
        JsonNode node = serializer.deserializeToTree(json);
        assertEquals("hello", node.get("Foo").asText());
        assertEquals(42, node.get("Bar").asInt());
    }

    @Test
    public void testSerializeRequestWithCredentials() {
        ObjectNode node = serializer.serializeRequest(new DummyRequest("foo"));
        assertEquals(123, node.get("PackageId").asInt());
        assertEquals("user", node.get("UserName").asText());
        assertEquals("pass", node.get("Password").asText());
        assertEquals("json", node.get("MessageFormat").asText());
        assertEquals("foo", node.get("Value").asText());
    }

    @Test
    public void serializeToStringValid() throws JsonProcessingException {
        String json = serializer.serializeRequest(new DummyRequest("bar")).toString();
        assertTrue(json.contains("bar"));
    }

    @Test
    public void testSerializeRequestNullRequest() {
        ObjectNode node = serializer.serializeRequest(null);
        assertEquals(123, node.get("PackageId").asInt());
        assertEquals("user", node.get("UserName").asText());
        assertEquals("pass", node.get("Password").asText());
        assertEquals("json", node.get("MessageFormat").asText());
    }

    @Test
    public void testSerializeRequestWithoutCredentials() {
        JacksonApiSerializer serializer = new JacksonApiSerializer(null);
        SimpleDto dto = new SimpleDto(42, "foo");
        ObjectNode node = serializer.serializeRequest(dto);
        assertEquals(42, node.get("Id").asInt());
        assertEquals("foo", node.get("Name").asText());
        assertNull(node.get("PackageId"));
    }

    @Test
    public void testSerializeToStringAndDeserializeToTree() throws JsonProcessingException {
        PackageCredentials creds = new PackageCredentials(1, "user", "pass");
        JacksonApiSerializer serializer = new JacksonApiSerializer(creds);
        SimpleDto dto = new SimpleDto(7, "bar");
        String json = serializer.serializeToString(dto);
        assertTrue(json.contains("\"Id\":7"));
        assertTrue(json.contains("\"Name\":\"bar\""));
        JsonNode node = serializer.deserializeToTree(json);
        assertEquals(7, node.get("Id").asInt());
        assertEquals("bar", node.get("Name").asText());
    }

    @Test
    public void testConvertValue() {
        PackageCredentials creds = new PackageCredentials(1, "user", "pass");
        JacksonApiSerializer serializer = new JacksonApiSerializer(creds);
        SimpleDto dto = new SimpleDto(99, "baz");
        SimpleDto result = serializer.convertValue(dto, new TypeReference<SimpleDto>(){});
        assertEquals(99, result.id);
        assertEquals("baz", result.name);
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

    static class SimpleDto {
        public int id;
        public String name;
        public SimpleDto() {}
        public SimpleDto(int id, String name) { this.id = id; this.name = name; }
    }
}
