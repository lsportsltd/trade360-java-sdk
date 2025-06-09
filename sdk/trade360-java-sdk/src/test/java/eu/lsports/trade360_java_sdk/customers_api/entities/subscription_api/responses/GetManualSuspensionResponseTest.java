package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetManualSuspensionResponseTest {

    @Test
    void testFieldAssignment() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        List<Suspension> suspensions = List.of(new Suspension(true, 1, 2, 3, 4, java.time.LocalDateTime.now(), null));
        
        response.succeeded = true;
        response.suspensions = suspensions;
        
        assertTrue(response.succeeded);
        assertEquals(suspensions, response.suspensions);
    }

    @Test
    void testNullFieldsAllowed() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.succeeded = null;
        response.suspensions = null;
        
        assertNull(response.succeeded);
        assertNull(response.suspensions);
    }

    @Test
    void testDefaultValues() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        assertNull(response.succeeded);
        assertNull(response.suspensions);
    }

    @Test
    void testBooleanValues() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.succeeded = false;
        assertFalse(response.succeeded);
        
        response.succeeded = true;
        assertTrue(response.succeeded);
    }
}
