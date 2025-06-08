package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetSportsRequestTest {
    @Test
    void testConstructorAndFields() {
        Integer languageId = 5;
        GetSportsRequest req = new GetSportsRequest(languageId);
        assertEquals(languageId, req.languageId());
        GetSportsRequest reqNoArg = new GetSportsRequest();
        assertNull(reqNoArg.languageId());
    }
} 