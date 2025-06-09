package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.common.entities.enums.ProviderOddsType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetProviderOddsTypeResponseTest {

    @Test
    void testFieldAssignment() {
        GetProviderOddsTypeResponse response = new GetProviderOddsTypeResponse();
        
        response.providerOddsType = ProviderOddsType.AVERAGE;
        
        assertEquals(ProviderOddsType.AVERAGE, response.providerOddsType);
    }

    @Test
    void testNullFieldsAllowed() {
        GetProviderOddsTypeResponse response = new GetProviderOddsTypeResponse();
        
        response.providerOddsType = null;
        
        assertNull(response.providerOddsType);
    }

    @Test
    void testDefaultValues() {
        GetProviderOddsTypeResponse response = new GetProviderOddsTypeResponse();
        
        assertNull(response.providerOddsType);
    }

    @Test
    void testProviderOddsTypeValues() {
        GetProviderOddsTypeResponse response = new GetProviderOddsTypeResponse();
        
        response.providerOddsType = ProviderOddsType.PROVIDER_ODDS;
        assertEquals(ProviderOddsType.PROVIDER_ODDS, response.providerOddsType);
        
        response.providerOddsType = ProviderOddsType.BOTH;
        assertEquals(ProviderOddsType.BOTH, response.providerOddsType);
    }
}
