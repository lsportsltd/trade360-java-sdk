package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetLocationsRequestTest {
    @Test
    void testConstructorAndFields() {
        Integer languageId = 5;
        GetLocationsRequest req = new GetLocationsRequest(languageId);
        assertEquals(languageId, req.languageId());
        GetLocationsRequest reqNoArg = new GetLocationsRequest();
        assertNull(reqNoArg.languageId());
    }
} 