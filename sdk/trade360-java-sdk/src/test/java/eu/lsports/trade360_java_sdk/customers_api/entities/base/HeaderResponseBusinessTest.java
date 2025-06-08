package eu.lsports.trade360_java_sdk.customers_api.entities.base;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import static org.junit.jupiter.api.Assertions.*;

class HeaderResponseBusinessTest {
    @Test
    void testHttpStatusCodeAssignment() {
        HeaderResponse header = new HeaderResponse();
        header.httpStatusCode = HttpStatusCode.valueOf(200);
        assertEquals(HttpStatusCode.valueOf(200), header.httpStatusCode);
    }

    @Test
    void testNullFields() {
        HeaderResponse header = new HeaderResponse();
        header.httpStatusCode = null;
        header.errors = null;
        assertNull(header.httpStatusCode);
        assertNull(header.errors);
    }
} 