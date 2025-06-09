package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartDistributionResponseTest {

    @Test
    void testFieldAssignment() {
        StartDistributionResponse response = new StartDistributionResponse();
        
        response.message = "Distribution started successfully";
        
        assertEquals("Distribution started successfully", response.message);
    }

    @Test
    void testNullFieldsAllowed() {
        StartDistributionResponse response = new StartDistributionResponse();
        
        response.message = null;
        
        assertNull(response.message);
    }

    @Test
    void testDefaultValues() {
        StartDistributionResponse response = new StartDistributionResponse();
        
        assertNull(response.message);
    }

    @Test
    void testMessageValues() {
        StartDistributionResponse response = new StartDistributionResponse();
        
        response.message = "Success";
        assertEquals("Success", response.message);
        
        response.message = "Error occurred";
        assertEquals("Error occurred", response.message);
    }
}
