package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetSeasonsRequestTest {

    @Test
    void testConstructorWithSeasonId() {
        GetSeasonsRequest request = new GetSeasonsRequest(123);
        
        assertNotNull(request);
        assertEquals(123, request.seasonId());
    }

    @Test
    void testConstructorWithNullSeasonId() {
        GetSeasonsRequest request = new GetSeasonsRequest(null);
        
        assertNotNull(request);
        assertNull(request.seasonId());
    }

    @Test
    void testDefaultConstructor() {
        GetSeasonsRequest request = new GetSeasonsRequest();
        
        assertNotNull(request);
        assertNull(request.seasonId());
    }

    @Test
    void testZeroSeasonId() {
        GetSeasonsRequest request = new GetSeasonsRequest(0);
        
        assertNotNull(request);
        assertEquals(0, request.seasonId());
    }

    @Test
    void testNegativeSeasonId() {
        GetSeasonsRequest request = new GetSeasonsRequest(-1);
        
        assertNotNull(request);
        assertEquals(-1, request.seasonId());
    }

    @Test
    void testRecordEquality() {
        GetSeasonsRequest request1 = new GetSeasonsRequest(100);
        GetSeasonsRequest request2 = new GetSeasonsRequest(100);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testRecordInequality() {
        GetSeasonsRequest request1 = new GetSeasonsRequest(100);
        GetSeasonsRequest request2 = new GetSeasonsRequest(200);
        
        assertNotEquals(request1, request2);
    }

    @Test
    void testNullEquality() {
        GetSeasonsRequest request1 = new GetSeasonsRequest(null);
        GetSeasonsRequest request2 = new GetSeasonsRequest(null);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        GetSeasonsRequest request = new GetSeasonsRequest(456);
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetSeasonsRequest"));
        assertTrue(toString.contains("456"));
    }

    @Test
    void testLargeSeasonId() {
        GetSeasonsRequest request = new GetSeasonsRequest(Integer.MAX_VALUE);
        
        assertNotNull(request);
        assertEquals(Integer.MAX_VALUE, request.seasonId());
    }
}


