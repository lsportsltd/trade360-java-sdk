package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

class OutrightMarketElementTest {
    @Test
    void testConstructorAndFields() {
        OutrightMarketElement element = new OutrightMarketElement();
        element.id = 1;
        element.name = "market";
        element.bets = Collections.emptyList();
        assertEquals(1, element.id);
        assertEquals("market", element.name);
        assertNotNull(element.bets);
    }
} 