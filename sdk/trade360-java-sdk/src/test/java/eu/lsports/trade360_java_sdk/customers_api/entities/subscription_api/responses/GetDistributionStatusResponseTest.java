package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetDistributionStatusResponseTest {

    @Test
    void testFieldAssignment() {
        GetDistributionStatusResponse response = new GetDistributionStatusResponse();
        List<String> consumers = List.of("consumer1", "consumer2");
        
        response.isDistributionOn = true;
        response.consumers = consumers;
        response.numberMessagesInQueue = 10;
        response.messagesPerSecond = 5.5;
        
        assertTrue(response.isDistributionOn);
        assertEquals(consumers, response.consumers);
        assertEquals(10, response.numberMessagesInQueue);
        assertEquals(5.5, response.messagesPerSecond);
    }

    @Test
    void testNullFieldsAllowed() {
        GetDistributionStatusResponse response = new GetDistributionStatusResponse();
        
        response.isDistributionOn = null;
        response.consumers = null;
        
        assertNull(response.isDistributionOn);
        assertNull(response.consumers);
    }

    @Test
    void testDefaultValues() {
        GetDistributionStatusResponse response = new GetDistributionStatusResponse();
        
        assertNull(response.isDistributionOn);
        assertNull(response.consumers);
        assertEquals(0, response.numberMessagesInQueue);
        assertEquals(0.0, response.messagesPerSecond);
    }

    @Test
    void testBooleanValues() {
        GetDistributionStatusResponse response = new GetDistributionStatusResponse();
        
        response.isDistributionOn = false;
        assertFalse(response.isDistributionOn);
        
        response.isDistributionOn = true;
        assertTrue(response.isDistributionOn);
    }
}
