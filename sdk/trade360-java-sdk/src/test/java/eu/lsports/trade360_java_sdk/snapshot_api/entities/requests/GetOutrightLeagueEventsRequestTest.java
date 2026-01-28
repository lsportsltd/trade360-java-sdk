package eu.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetOutrightLeagueEventsRequestTest {
    
    @Test
    void testRecordInstantiationWithAllNullParameters() {
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, null, null, null, null, null
        );
        
        assertNotNull(request);
        assertNull(request.timestamp());
        assertNull(request.fromDate());
        assertNull(request.toDate());
        assertNull(request.sports());
        assertNull(request.locations());
        assertNull(request.leagues());
        assertNull(request.fixtures());
        assertNull(request.markets());
    }
    
    @Test
    void testRecordInstantiationWithSpecificParameters() {
        Instant timestamp = Instant.parse("2024-01-15T10:30:00Z");
        Instant fromDate = Instant.parse("2024-01-01T00:00:00Z");
        Instant toDate = Instant.parse("2024-01-31T23:59:59Z");
        List<Integer> sports = Arrays.asList(1, 2, 3);
        List<Integer> locations = Arrays.asList(100, 200);
        List<Integer> leagues = Arrays.asList(10, 20, 30);
        List<Integer> fixtures = Arrays.asList(1000, 2000);
        List<Integer> markets = Arrays.asList(5, 10, 15);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            timestamp, fromDate, toDate, sports, locations, leagues, fixtures, markets
        );
        
        assertNotNull(request);
        assertEquals(timestamp, request.timestamp());
        assertEquals(fromDate, request.fromDate());
        assertEquals(toDate, request.toDate());
        assertEquals(sports, request.sports());
        assertEquals(locations, request.locations());
        assertEquals(leagues, request.leagues());
        assertEquals(fixtures, request.fixtures());
        assertEquals(markets, request.markets());
    }
    
    @Test
    void testTimestampParameter() {
        Instant testTimestamp = Instant.parse("2024-06-15T14:30:45Z");
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            testTimestamp, null, null, null, null, null, null, null
        );
        
        assertEquals(testTimestamp, request.timestamp());
        assertNull(request.fromDate());
        assertNull(request.toDate());
    }
    
    @Test
    void testDateRangeParameters() {
        Instant fromDate = Instant.parse("2024-01-01T00:00:00Z");
        Instant toDate = Instant.parse("2024-12-31T23:59:59Z");
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, fromDate, toDate, null, null, null, null, null
        );
        
        assertNull(request.timestamp());
        assertEquals(fromDate, request.fromDate());
        assertEquals(toDate, request.toDate());
    }
    
    @Test
    void testSportsParameter() {
        List<Integer> sports = Arrays.asList(1, 2, 3, 4, 5);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, sports, null, null, null, null
        );
        
        assertEquals(sports, request.sports());
        assertEquals(5, ((List<Integer>) request.sports()).size());
    }
    
    @Test
    void testLocationsParameter() {
        List<Integer> locations = Arrays.asList(100, 200, 300);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, null, locations, null, null, null
        );
        
        assertEquals(locations, request.locations());
        assertEquals(3, ((List<Integer>) request.locations()).size());
    }
    
    @Test
    void testLeaguesParameter() {
        List<Integer> leagues = Arrays.asList(10, 20);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, null, null, leagues, null, null
        );
        
        assertEquals(leagues, request.leagues());
        assertEquals(2, ((List<Integer>) request.leagues()).size());
    }
    
    @Test
    void testFixturesParameter() {
        List<Integer> fixtures = Arrays.asList(1000, 2000, 3000, 4000);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, null, null, null, fixtures, null
        );
        
        assertEquals(fixtures, request.fixtures());
        assertEquals(4, ((List<Integer>) request.fixtures()).size());
    }
    
    @Test
    void testMarketsParameter() {
        List<Integer> markets = Arrays.asList(5, 10, 15, 20, 25);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, null, null, null, null, markets
        );
        
        assertEquals(markets, request.markets());
        assertEquals(5, ((List<Integer>) request.markets()).size());
    }
    
    @Test
    void testEmptyCollections() {
        List<Integer> emptySports = Arrays.asList();
        List<Integer> emptyLocations = Arrays.asList();
        List<Integer> emptyLeagues = Arrays.asList();
        List<Integer> emptyFixtures = Arrays.asList();
        List<Integer> emptyMarkets = Arrays.asList();
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            null, null, null, emptySports, emptyLocations, emptyLeagues, emptyFixtures, emptyMarkets
        );
        
        assertNotNull(request.sports());
        assertNotNull(request.locations());
        assertNotNull(request.leagues());
        assertNotNull(request.fixtures());
        assertNotNull(request.markets());
        
        assertEquals(0, ((List<Integer>) request.sports()).size());
        assertEquals(0, ((List<Integer>) request.locations()).size());
        assertEquals(0, ((List<Integer>) request.leagues()).size());
        assertEquals(0, ((List<Integer>) request.fixtures()).size());
        assertEquals(0, ((List<Integer>) request.markets()).size());
    }
    
    @Test
    void testRecordEquality() {
        Instant timestamp = Instant.parse("2024-01-15T10:30:00Z");
        List<Integer> sports = Arrays.asList(1, 2);
        
        GetOutrightLeagueEventsRequest request1 = new GetOutrightLeagueEventsRequest(
            timestamp, null, null, sports, null, null, null, null
        );
        
        GetOutrightLeagueEventsRequest request2 = new GetOutrightLeagueEventsRequest(
            timestamp, null, null, sports, null, null, null, null
        );
        
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
    }
    
    @Test
    void testRecordInequality() {
        Instant timestamp1 = Instant.parse("2024-01-15T10:30:00Z");
        Instant timestamp2 = Instant.parse("2024-01-16T10:30:00Z");
        
        GetOutrightLeagueEventsRequest request1 = new GetOutrightLeagueEventsRequest(
            timestamp1, null, null, null, null, null, null, null
        );
        
        GetOutrightLeagueEventsRequest request2 = new GetOutrightLeagueEventsRequest(
            timestamp2, null, null, null, null, null, null, null
        );
        
        assertNotEquals(request1, request2);
    }
    
    @Test
    void testToString() {
        Instant timestamp = Instant.parse("2024-01-15T10:30:00Z");
        List<Integer> sports = Arrays.asList(1, 2);
        
        GetOutrightLeagueEventsRequest request = new GetOutrightLeagueEventsRequest(
            timestamp, null, null, sports, null, null, null, null
        );
        
        String toString = request.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("GetOutrightLeagueEventsRequest"));
    }
}
