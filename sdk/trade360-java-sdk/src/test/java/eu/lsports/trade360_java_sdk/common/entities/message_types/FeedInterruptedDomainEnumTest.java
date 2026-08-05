package eu.lsports.trade360_java_sdk.common.entities.message_types;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeedInterruptedDomainEnumTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void serializesMarketsAsIntegerOne() throws Exception {
        assertEquals("1", objectMapper.writeValueAsString(FeedInterruptedDomainEnum.Markets));
    }
}
