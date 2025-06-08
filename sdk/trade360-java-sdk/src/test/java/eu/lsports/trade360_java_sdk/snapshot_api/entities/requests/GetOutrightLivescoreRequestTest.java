package eu.lsports.trade360_java_sdk.snapshot_api.entities.requests;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GetOutrightLivescoreRequestTest {
    @Test
    void testConstructorAndFields() {
        LocalDateTime now = LocalDateTime.now();
        List<Integer> sports = List.of(1, 2);
        List<Integer> locations = List.of(3, 4);
        List<Integer> tournaments = List.of(5, 6);
        List<Integer> fixtures = List.of(7, 8);
        GetOutrightLivescoreRequest req = new GetOutrightLivescoreRequest(now, now, now, sports, locations, tournaments, fixtures);
        assertEquals(now, req.timestamp());
        assertEquals(now, req.fromDate());
        assertEquals(now, req.toDate());
        assertEquals(sports, req.sports());
        assertEquals(locations, req.locations());
        assertEquals(tournaments, req.tournaments());
        assertEquals(fixtures, req.fixtures());
    }
} 