package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionResponsesComprehensiveTest {

    @Test
    void testGetManualSuspensionResponseDefaultConstructor() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        assertNotNull(response);
        assertNull(response.succeeded);
        assertNull(response.suspensions);
    }

    @Test
    void testGetManualSuspensionResponseFieldAssignment() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        Boolean testSucceeded = true;
        Iterable<Suspension> testSuspensions = Collections.singletonList(
            new Suspension(true, 1, 100, 2, 200, LocalDateTime.now(), Collections.emptyList()));
        
        response.succeeded = testSucceeded;
        response.suspensions = testSuspensions;
        
        assertEquals(testSucceeded, response.succeeded);
        assertEquals(testSuspensions, response.suspensions);
    }

    @Test
    void testGetManualSuspensionResponseNullAssignments() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.succeeded = null;
        response.suspensions = null;
        
        assertNull(response.succeeded);
        assertNull(response.suspensions);
    }

    @Test
    void testGetManualSuspensionResponseReassignment() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.succeeded = true;
        response.suspensions = Collections.singletonList(
            new Suspension(true, 1, 100, 2, 200, java.time.LocalDateTime.now(), Collections.emptyList()));
        
        assertTrue(response.succeeded);
        assertNotNull(response.suspensions);
        
        response.succeeded = false;
        response.suspensions = Arrays.asList(
            new Suspension(false, 3, 300, 4, 400, LocalDateTime.now(), Collections.emptyList()),
            new Suspension(true, 5, 500, 6, 600, LocalDateTime.now(), Collections.emptyList()));
        
        assertFalse(response.succeeded);
        assertNotNull(response.suspensions);
    }

    @Test
    void testMultipleGetManualSuspensionResponseInstances() {
        GetManualSuspensionResponse response1 = new GetManualSuspensionResponse();
        GetManualSuspensionResponse response2 = new GetManualSuspensionResponse();
        
        response1.succeeded = true;
        response1.suspensions = Collections.singletonList(
            new Suspension(true, 7, 700, 8, 800, LocalDateTime.now(), Collections.emptyList()));
        
        response2.succeeded = false;
        response2.suspensions = Arrays.asList(
            new Suspension(false, 9, 900, 10, 1000, LocalDateTime.now(), Collections.emptyList()),
            new Suspension(true, 11, 1100, 12, 1200, LocalDateTime.now(), Collections.emptyList()));
        
        assertTrue(response1.succeeded);
        assertFalse(response2.succeeded);
        assertNotSame(response1.suspensions, response2.suspensions);
    }

    @Test
    void testGetManualSuspensionResponseFieldIndependence() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.succeeded = true;
        assertNull(response.suspensions);
        
        response.suspensions = Collections.singletonList(
            new Suspension(true, 13, 1300, 14, 1400, LocalDateTime.now(), Collections.emptyList()));
        assertTrue(response.succeeded);
    }

    @Test
    void testGetManualSuspensionResponseConsistency() {
        GetManualSuspensionResponse response1 = new GetManualSuspensionResponse();
        GetManualSuspensionResponse response2 = new GetManualSuspensionResponse();
        
        Boolean sharedSucceeded = true;
        Iterable<Suspension> sharedSuspensions = Collections.singletonList(
            new Suspension(true, 15, 1500, 16, 1600, LocalDateTime.now(), Collections.emptyList()));
        
        response1.succeeded = sharedSucceeded;
        response1.suspensions = sharedSuspensions;
        
        response2.succeeded = sharedSucceeded;
        response2.suspensions = sharedSuspensions;
        
        assertSame(response1.succeeded, response2.succeeded);
        assertSame(response1.suspensions, response2.suspensions);
    }

    @Test
    void testGetManualSuspensionResponseEmptyCollections() {
        GetManualSuspensionResponse response = new GetManualSuspensionResponse();
        
        response.suspensions = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), response.suspensions);
        assertNotNull(response.suspensions);
    }
}
