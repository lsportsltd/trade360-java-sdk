package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.lsports.trade360_java_sdk.common.entities.base.Error;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class LSportsHeaderErrorsExtractorTest {

    @Mock
    private JsonApiSerializer serializer;

    private LSportsHeaderErrorsExtractor extractor;
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        extractor = new LSportsHeaderErrorsExtractor();
        mapper = new ObjectMapper();
    }

    @Test
    void testExtractErrorsWithNoHeader() {
        JsonNode node = mapper.createObjectNode();
        assertNull(extractor.extractErrors(node, serializer));
    }

    @Test
    void testExtractErrorsWithHeaderButNoErrors() {
        ObjectNode node = mapper.createObjectNode();
        ObjectNode header = mapper.createObjectNode();
        node.set("Header", header);
        
        assertNull(extractor.extractErrors(node, serializer));
    }

    @Test
    void testExtractErrorsWithValidHeaderAndErrors() throws Exception {
        ObjectNode node = mapper.createObjectNode();
        ObjectNode header = mapper.createObjectNode();
        ArrayNode errors = mapper.createArrayNode();
        
        ObjectNode error1 = mapper.createObjectNode();
        error1.put("message", "Error 1");
        ObjectNode error2 = mapper.createObjectNode();
        error2.put("message", "Error 2");
        
        errors.add(error1);
        errors.add(error2);
        header.set("Errors", errors);
        node.set("Header", header);

        Error mockError1 = new Error();
        mockError1.message = "Error 1";
        Error mockError2 = new Error();
        mockError2.message = "Error 2";
        List<Error> mockErrors = List.of(mockError1, mockError2);

        when(serializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn(mockErrors);

        Iterable<String> result = extractor.extractErrors(node, serializer);
        
        assertNotNull(result);
        List<String> resultList = (List<String>) result;
        assertEquals(2, resultList.size());
        assertEquals("Error 1", resultList.get(0));
        assertEquals("Error 2", resultList.get(1));
    }

    @Test
    void testExtractErrorsWithEmptyErrorsArray() throws Exception {
        ObjectNode node = mapper.createObjectNode();
        ObjectNode header = mapper.createObjectNode();
        ArrayNode errors = mapper.createArrayNode();
        header.set("Errors", errors);
        node.set("Header", header);

        when(serializer.deserializeToValue(any(), any(TypeReference.class))).thenReturn(List.of());

        Iterable<String> result = extractor.extractErrors(node, serializer);
        
        assertNotNull(result);
        assertTrue(((List<String>) result).isEmpty());
    }

    @Test
    void testExtractErrorsWithSerializationException() throws Exception {
        ObjectNode node = mapper.createObjectNode();
        ObjectNode header = mapper.createObjectNode();
        ArrayNode errors = mapper.createArrayNode();
        header.set("Errors", errors);
        node.set("Header", header);

        when(serializer.deserializeToValue(any(), any(TypeReference.class)))
            .thenThrow(new RuntimeException("Serialization error"));

        Iterable<String> result = extractor.extractErrors(node, serializer);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithNullSerializer() {
        ObjectNode node = mapper.createObjectNode();
        ObjectNode header = mapper.createObjectNode();
        ArrayNode errors = mapper.createArrayNode();
        header.set("Errors", errors);
        node.set("Header", header);

        Iterable<String> result = extractor.extractErrors(node, null);
        
        assertNull(result);
    }

    @Test
    void testExtractErrorsWithNullJsonNode() {
        Iterable<String> result = extractor.extractErrors(null, serializer);
        
        assertNull(result);
    }
}    