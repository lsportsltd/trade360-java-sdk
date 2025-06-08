package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseRequestBusinessTest {
    @Test
    void testFullFieldAssignment() {
        BaseRequest req = new BaseRequest();
        req.packageId = 123;
        req.userName = "user";
        req.password = "pass";
        assertEquals(123, req.packageId);
        assertEquals("user", req.userName);
        assertEquals("pass", req.password);
    }

    @Test
    void testNullFields() {
        BaseRequest req = new BaseRequest();
        req.userName = null;
        req.password = null;
        assertNull(req.userName);
        assertNull(req.password);
    }

    @Test
    void testDefaultPackageId() {
        BaseRequest req = new BaseRequest();
        assertEquals(0, req.packageId);
    }
} 