package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseResponseTest {

    @Test
    void testFieldAssignment() {
        BaseResponse<String> response = new BaseResponse<>();
        HeaderResponse header = new HeaderResponse();
        String body = "test body";
        
        response.header = header;
        response.body = body;
        
        assertNotNull(response.header);
        assertNotNull(response.body);
        assertEquals(header, response.header);
        assertEquals(body, response.body);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        BaseResponse<String> response = new BaseResponse<>();
        
        assertNull(response.header);
        assertNull(response.body);
    }

    @Test
    void testGenericTypeHandling() {
        BaseResponse<Integer> intResponse = new BaseResponse<>();
        BaseResponse<String> stringResponse = new BaseResponse<>();
        
        intResponse.body = 42;
        stringResponse.body = "test";
        
        assertEquals(Integer.valueOf(42), intResponse.body);
        assertEquals("test", stringResponse.body);
    }
}
