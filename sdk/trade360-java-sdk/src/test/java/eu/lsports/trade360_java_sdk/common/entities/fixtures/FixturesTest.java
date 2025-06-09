package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FixturesTest {

    @Test
    void testFieldAssignments() {
        Fixtures fixtures = new Fixtures();
        
        fixtures.setId(123);
        assertEquals(123, fixtures.getId());
        
        fixtures.setName("Test Fixture");
        assertEquals("Test Fixture", fixtures.getName());
        
        fixtures.setStartDate("2023-12-01T10:00:00Z");
        assertEquals("2023-12-01T10:00:00Z", fixtures.getStartDate());
        
        fixtures.setStatus(1);
        assertEquals(1, fixtures.getStatus());
        
        fixtures.setLeagueId(456);
        assertEquals(456, fixtures.getLeagueId());
        
        fixtures.setSportId(789);
        assertEquals(789, fixtures.getSportId());
    }

    @Test
    void testNullValues() {
        Fixtures fixtures = new Fixtures();
        
        assertNull(fixtures.getName());
        assertNull(fixtures.getStartDate());
    }

    @Test
    void testDefaultValues() {
        Fixtures fixtures = new Fixtures();
        
        assertEquals(0, fixtures.getId());
        assertEquals(0, fixtures.getStatus());
        assertEquals(0, fixtures.getLeagueId());
        assertEquals(0, fixtures.getSportId());
    }

    @Test
    void testDateStringHandling() {
        Fixtures fixtures = new Fixtures();
        
        fixtures.setStartDate("2023-01-01T00:00:00Z");
        assertEquals("2023-01-01T00:00:00Z", fixtures.getStartDate());
        
        fixtures.setStartDate("");
        assertEquals("", fixtures.getStartDate());
    }
}
