package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.markets.ProviderMarket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.List;

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

    @Test
    void testProviderMarketsField() {
        OutrightMarketElement element = new OutrightMarketElement();
        element.id = 100;
        element.name = "Outright Winner";
        
        ProviderMarket providerMarket = new ProviderMarket();
        providerMarket.id = 1;
        providerMarket.name = "Provider1";
        
        element.providerMarkets = List.of(providerMarket);
        
        assertNotNull(element.providerMarkets);
        assertEquals(1, ((List<ProviderMarket>) element.providerMarkets).size());
        assertEquals(1, ((List<ProviderMarket>) element.providerMarkets).get(0).id);
        assertEquals("Provider1", ((List<ProviderMarket>) element.providerMarkets).get(0).name);
    }

    @Test
    void testProviderMarketsCanBeNull() {
        OutrightMarketElement element = new OutrightMarketElement();
        element.id = 200;
        element.providerMarkets = null;
        
        assertNull(element.providerMarkets);
    }
} 