package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProblemJsonErrorsExtractorTest {
    @Test
    void testExtractErrorsWithNoErrors() throws Exception {
        ProblemJsonErrorsExtractor extractor = new ProblemJsonErrorsExtractor();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.createObjectNode();
        JsonApiSerializer serializer = null;
        assertNull(extractor.extractErrors(node, serializer));
    }
} 