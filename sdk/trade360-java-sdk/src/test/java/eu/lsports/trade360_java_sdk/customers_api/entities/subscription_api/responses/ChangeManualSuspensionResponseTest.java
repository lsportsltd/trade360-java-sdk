package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.responses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangeManualSuspensionResponseTest {

    @Test
    void testFieldAssignment() {
        ChangeManualSuspensionResponse response = new ChangeManualSuspensionResponse();
        List<SuspensionChangeResponse> suspensions = List.of(new SuspensionChangeResponse());
        
        response.suspensions = suspensions;
        
        assertEquals(suspensions, response.suspensions);
    }

    @Test
    void testNullFieldsAllowed() {
        ChangeManualSuspensionResponse response = new ChangeManualSuspensionResponse();
        
        response.suspensions = null;
        
        assertNull(response.suspensions);
    }

    @Test
    void testDefaultValues() {
        ChangeManualSuspensionResponse response = new ChangeManualSuspensionResponse();
        
        assertNull(response.suspensions);
    }

    @Test
    void testEmptyList() {
        ChangeManualSuspensionResponse response = new ChangeManualSuspensionResponse();
        List<SuspensionChangeResponse> emptyList = List.of();
        
        response.suspensions = emptyList;
        
        assertEquals(emptyList, response.suspensions);
        assertTrue(((List<SuspensionChangeResponse>) response.suspensions).isEmpty());
    }
}
