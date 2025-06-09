package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopDistributionResponseTest {

    @Test
    void testFieldAssignment() {
        StopDistributionResponse response = new StopDistributionResponse();
        
        response.message = "Distribution stopped successfully";
        
        assertEquals("Distribution stopped successfully", response.message);
    }

    @Test
    void testNullFieldsAllowed() {
        StopDistributionResponse response = new StopDistributionResponse();
        
        response.message = null;
        
        assertNull(response.message);
    }

    @Test
    void testDefaultValues() {
        StopDistributionResponse response = new StopDistributionResponse();
        
        assertNull(response.message);
    }

    @Test
    void testMessageValues() {
        StopDistributionResponse response = new StopDistributionResponse();
        
        response.message = "Success";
        assertEquals("Success", response.message);
        
        response.message = "Error occurred";
        assertEquals("Error occurred", response.message);
    }
}
