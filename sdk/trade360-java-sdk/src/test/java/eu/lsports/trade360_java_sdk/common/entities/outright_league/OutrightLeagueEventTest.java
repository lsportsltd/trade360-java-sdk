package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueEventTest {
    
    @Test
    void testInstantiation() {
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        assertNotNull(event);
    }
    
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        
        // Test initial state
        assertEquals(0, event.fixtureId);
        assertNull(event.outrightLeague);
        assertNull(event.markets);
        
        // Test field assignments
        event.fixtureId = 12345;
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        event.outrightLeague = fixture;
        MarketLeague market1 = new MarketLeague();
        MarketLeague market2 = new MarketLeague();
        event.markets = Arrays.asList(market1, market2);
        
        // Verify assignments
        assertEquals(12345, event.fixtureId);
        assertSame(fixture, event.outrightLeague);
        assertNotNull(event.markets);
        assertEquals(2, ((java.util.List<MarketLeague>) event.markets).size());
    }
    
    @Test
    void testFixtureIdValidation() {
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        
        // Test with negative fixture ID
        event.fixtureId = -1;
        assertEquals(-1, event.fixtureId);
        
        // Test with zero fixture ID
        event.fixtureId = 0;
        assertEquals(0, event.fixtureId);
        
        // Test with positive fixture ID
        event.fixtureId = 999999;
        assertEquals(999999, event.fixtureId);
    }
    
    @Test
    void testOutrightLeagueFixtureRelationship() {
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        
        // Test assignment
        event.outrightLeague = fixture;
        assertSame(fixture, event.outrightLeague);
        
        // Test reassignment
        OutrightLeagueFixture newFixture = new OutrightLeagueFixture();
        event.outrightLeague = newFixture;
        assertSame(newFixture, event.outrightLeague);
        assertNotSame(fixture, event.outrightLeague);
        
        // Test null assignment
        event.outrightLeague = null;
        assertNull(event.outrightLeague);
    }
    
    @Test
    void testMarketsCollectionHandling() {
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        
        // Test empty collection
        event.markets = Arrays.asList();
        assertNotNull(event.markets);
        assertEquals(0, ((java.util.List<MarketLeague>) event.markets).size());
        
        // Test single market
        MarketLeague market = new MarketLeague();
        event.markets = Arrays.asList(market);
        assertEquals(1, ((java.util.List<MarketLeague>) event.markets).size());
        
        // Test multiple markets
        MarketLeague market1 = new MarketLeague();
        MarketLeague market2 = new MarketLeague();
        MarketLeague market3 = new MarketLeague();
        event.markets = Arrays.asList(market1, market2, market3);
        assertEquals(3, ((java.util.List<MarketLeague>) event.markets).size());
        
        // Test null assignment
        event.markets = null;
        assertNull(event.markets);
    }
    
    @Test
    void testCompleteEventScenario() {
        // Test a complete scenario with all fields populated
        OutrightLeagueEvent event = new OutrightLeagueEvent();
        
        // Set up fixture
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        
        // Set up markets
        MarketLeague market1 = new MarketLeague();
        MarketLeague market2 = new MarketLeague();
        
        // Assign all fields
        event.fixtureId = 54321;
        event.outrightLeague = fixture;
        event.markets = Arrays.asList(market1, market2);
        
        // Verify all assignments
        assertEquals(54321, event.fixtureId);
        assertSame(fixture, event.outrightLeague);
        assertNotNull(event.markets);
        assertEquals(2, ((java.util.List<MarketLeague>) event.markets).size());
    }
}
