package eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.requests;

import org.junit.jupiter.api.Test;
import java.util.List;
import eu.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base.Suspension;
import static org.junit.jupiter.api.Assertions.*;

class ChangeManualSuspensionRequestTest {
    @Test
    void testConstructorAndFields() {
        List<Suspension> suspensions = List.of();
        ChangeManualSuspensionRequest req = new ChangeManualSuspensionRequest(suspensions);
        assertEquals(suspensions, req.suspensions());
    }
} 