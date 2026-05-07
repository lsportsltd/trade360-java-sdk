package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GetToursRequestTest {

    @Test
    void testConstructorWithAllFields() {
        GetToursRequest request = new GetToursRequest(123, 456);
        
        assertNotNull(request);
        assertEquals(123, request.tourId());
        assertEquals(456, request.sportId());
    }

    @Test
    void testConstructorWithNullFields() {
        GetToursRequest request = new GetToursRequest(null, null);
        
        assertNotNull(request);
        assertNull(request.tourId());
        assertNull(request.sportId());
    }

    @Test
    void testDefaultConstructor() {
        GetToursRequest request = new GetToursRequest();
        
        assertNotNull(request);
        assertNull(request.tourId());
        assertNull(request.sportId());
    }

    @Test
    void testConstructorWithOnlyTourId() {
        GetToursRequest request = new GetToursRequest(789, null);
        
        assertNotNull(request);
        assertEquals(789, request.tourId());
        assertNull(request.sportId());
    }

    @Test
    void testConstructorWithOnlySportId() {
        GetToursRequest request = new GetToursRequest(null, 101);
        
        assertNotNull(request);
        assertNull(request.tourId());
        assertEquals(101, request.sportId());
    }

    @Test
    void testZeroIds() {
        GetToursRequest request = new GetToursRequest(0, 0);
        
        assertNotNull(request);
        assertEquals(0, request.tourId());
        assertEquals(0, request.sportId());
    }

    @Test
    void testNegativeIds() {
        GetToursRequest request = new GetToursRequest(-1, -2);
        
        assertNotNull(request);
        assertEquals(-1, request.tourId());
        assertEquals(-2, request.sportId());
    }

    @Test
    void testRecordEquality() {
        GetToursRequest request1 = new GetToursRequest(100, 200);
        GetToursRequest request2 = new GetToursRequest(100, 200);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testRecordInequality() {
        GetToursRequest request1 = new GetToursRequest(100, 200);
        GetToursRequest request2 = new GetToursRequest(100, 300);
        
        assertNotEquals(request1, request2);
    }

    @Test
    void testNullEquality() {
        GetToursRequest request1 = new GetToursRequest(null, null);
        GetToursRequest request2 = new GetToursRequest(null, null);
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void testToString() {
        GetToursRequest request = new GetToursRequest(456, 789);
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetToursRequest"));
        assertTrue(toString.contains("456"));
        assertTrue(toString.contains("789"));
    }

    @Test
    void testLargeIds() {
        GetToursRequest request = new GetToursRequest(Integer.MAX_VALUE, Integer.MAX_VALUE);
        
        assertNotNull(request);
        assertEquals(Integer.MAX_VALUE, request.tourId());
        assertEquals(Integer.MAX_VALUE, request.sportId());
    }
}


