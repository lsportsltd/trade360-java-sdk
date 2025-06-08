package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketMetadataTest {
    @Test
    void testConstructorAndFields() {
        int id = 1;
        String name = "Market";
        Boolean isSettleable = true;
        MarketMetadata mm = new MarketMetadata(id, name, isSettleable);
        assertEquals(id, mm.id());
        assertEquals(name, mm.name());
        assertEquals(isSettleable, mm.isSettleable());
    }
} 