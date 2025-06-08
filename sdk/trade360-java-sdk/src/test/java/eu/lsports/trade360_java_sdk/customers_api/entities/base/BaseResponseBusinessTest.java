package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseResponseBusinessTest {
    static class DummyBody {}

    @Test
    void testFullFieldAssignment() {
        BaseResponse<DummyBody> resp = new BaseResponse<>();
        HeaderResponse header = new HeaderResponse();
        DummyBody body = new DummyBody();
        resp.header = header;
        resp.body = body;
        assertEquals(header, resp.header);
        assertEquals(body, resp.body);
    }

    @Test
    void testNullFields() {
        BaseResponse<Object> resp = new BaseResponse<>();
        resp.header = null;
        resp.body = null;
        assertNull(resp.header);
        assertNull(resp.body);
    }
} 