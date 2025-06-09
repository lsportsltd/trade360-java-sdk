package eu.lsports.trade360_java_sdk.common.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.customers_api.entities.base.BaseResponse;
import eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses.GetSportsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class JacksonApiSerializerExpandedTest {

    @Mock
    private ObjectMapper objectMapper;

    private JacksonApiSerializer serializer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        serializer = new JacksonApiSerializer(objectMapper);
    }

    @Test
    void testSerializeWithValidObject() throws JsonProcessingException {
        BaseResponse response = new BaseResponse();
        String expectedJson = "{\"success\":true}";
        
        when(objectMapper.writeValueAsString(response)).thenReturn(expectedJson);
        
        String result = serializer.serialize(response);
        
        assertEquals(expectedJson, result);
        verify(objectMapper).writeValueAsString(response);
    }

    @Test
    void testSerializeWithNullObject() throws JsonProcessingException {
        when(objectMapper.writeValueAsString(null)).thenReturn("null");
        
        String result = serializer.serialize(null);
        
        assertEquals("null", result);
        verify(objectMapper).writeValueAsString(null);
    }

    @Test
    void testSerializeThrowsException() throws JsonProcessingException {
        BaseResponse response = new BaseResponse();
        
        when(objectMapper.writeValueAsString(response))
            .thenThrow(new JsonProcessingException("Serialization failed") {});
        
        assertThrows(RuntimeException.class, () -> serializer.serialize(response));
        verify(objectMapper).writeValueAsString(response);
    }

    @Test
    void testDeserializeWithValidJson() throws JsonProcessingException {
        String json = "{\"success\":true}";
        GetSportsResponse expectedResponse = new GetSportsResponse();
        
        when(objectMapper.readValue(json, GetSportsResponse.class)).thenReturn(expectedResponse);
        
        GetSportsResponse result = serializer.deserialize(json, GetSportsResponse.class);
        
        assertEquals(expectedResponse, result);
        verify(objectMapper).readValue(json, GetSportsResponse.class);
    }

    @Test
    void testDeserializeWithEmptyJson() throws JsonProcessingException {
        String json = "";
        
        when(objectMapper.readValue(json, BaseResponse.class)).thenReturn(new BaseResponse());
        
        BaseResponse result = serializer.deserialize(json, BaseResponse.class);
        
        assertNotNull(result);
        verify(objectMapper).readValue(json, BaseResponse.class);
    }

    @Test
    void testDeserializeThrowsException() throws JsonProcessingException {
        String json = "{invalid json}";
        
        when(objectMapper.readValue(anyString(), any(Class.class)))
            .thenThrow(new JsonProcessingException("Deserialization failed") {});
        
        assertThrows(RuntimeException.class, () -> serializer.deserialize(json, BaseResponse.class));
        verify(objectMapper).readValue(json, BaseResponse.class);
    }

    @Test
    void testDeserializeWithNullJson() throws JsonProcessingException {
        when(objectMapper.readValue(null, BaseResponse.class)).thenReturn(null);
        
        BaseResponse result = serializer.deserialize(null, BaseResponse.class);
        
        assertNull(result);
        verify(objectMapper).readValue(null, BaseResponse.class);
    }
}
