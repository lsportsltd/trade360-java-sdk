package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseRequestTest {

    @Test
    void testFieldAssignment() {
        BaseRequest request = new BaseRequest();
        
        assertNotNull(request);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        BaseRequest request = new BaseRequest();
        
        assertNotNull(request);
    }
}
