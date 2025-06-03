package eu.lsports.trade360_java_sdk.common.http;

import com.fasterxml.jackson.databind.JsonNode;
import eu.lsports.trade360_java_sdk.common.interfaces.JsonApiSerializer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorsExtractorTest {
    static class DummyErrorsExtractor implements ErrorsExtractor {
        @Override
        public Iterable<String> extractErrors(JsonNode bodyJsonNode, JsonApiSerializer serializer) {
            return java.util.List.of("error1", "error2");
        }
    }
    @Test
    void testExtractErrors() {
        DummyErrorsExtractor extractor = new DummyErrorsExtractor();
        Iterable<String> errors = extractor.extractErrors(null, null);
        assertNotNull(errors);
        assertTrue(errors.iterator().hasNext());
    }
} 