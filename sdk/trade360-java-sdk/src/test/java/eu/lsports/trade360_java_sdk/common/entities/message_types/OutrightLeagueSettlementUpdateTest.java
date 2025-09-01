package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueSettlementUpdateTest {
    
    @Test
    void testInstantiation() {
        OutrightLeagueSettlementUpdate update = new OutrightLeagueSettlementUpdate();
        assertNotNull(update);
    }
    
    @Test
    void testEntityKey() {
        // Test that the entity key is correctly set to 43
        assertEquals(43, OutrightLeagueSettlementUpdate.entityKey);
    }
    
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueSettlementUpdate update = new OutrightLeagueSettlementUpdate();
        
        // Test initial state - competition should be null
        assertNull(update.competition);
        
        // Test assignment of competition
        OutrightLeagueCompetition<MarketEvent> competition = new OutrightLeagueCompetition<>();
        update.competition = competition;
        assertSame(competition, update.competition);
        
        // Test reassignment
        OutrightLeagueCompetition<MarketEvent> newCompetition = new OutrightLeagueCompetition<>();
        update.competition = newCompetition;
        assertSame(newCompetition, update.competition);
        assertNotSame(competition, update.competition);
        
        // Test null assignment
        update.competition = null;
        assertNull(update.competition);
    }
    
    @Test
    void testCompetitionWithMarketEvent() {
        OutrightLeagueSettlementUpdate update = new OutrightLeagueSettlementUpdate();
        OutrightLeagueCompetition<MarketEvent> competition = new OutrightLeagueCompetition<>();
        
        // Set up competition properties
        competition.id = 123;
        competition.name = "Test Competition";
        competition.type = 1;
        
        // Assign to update
        update.competition = competition;
        
        // Verify the competition is correctly assigned and accessible
        assertNotNull(update.competition);
        assertEquals(123, update.competition.id);
        assertEquals("Test Competition", update.competition.name);
        assertEquals(1, update.competition.type);
    }
    
    @Test
    void testStaticEntityKeyAccess() {
        // Test that the entity key can be accessed statically
        int key = OutrightLeagueSettlementUpdate.entityKey;
        assertEquals(43, key);
        
        // Verify it's consistent with the constant
        assertEquals(OutrightLeagueSettlementUpdate.entityKey, 43);
    }
    
    @Test
    void testCompetitionGenericType() {
        OutrightLeagueSettlementUpdate update = new OutrightLeagueSettlementUpdate();
        
        // Test with explicit generic type
        OutrightLeagueCompetition<MarketEvent> marketEventCompetition = new OutrightLeagueCompetition<>();
        update.competition = marketEventCompetition;
        
        assertNotNull(update.competition);
        assertSame(marketEventCompetition, update.competition);
    }
    
    @Test
    void testMultipleInstances() {
        // Test that multiple instances can be created independently
        OutrightLeagueSettlementUpdate update1 = new OutrightLeagueSettlementUpdate();
        OutrightLeagueSettlementUpdate update2 = new OutrightLeagueSettlementUpdate();
        
        assertNotSame(update1, update2);
        
        // Test that they can have different competitions
        OutrightLeagueCompetition<MarketEvent> competition1 = new OutrightLeagueCompetition<>();
        OutrightLeagueCompetition<MarketEvent> competition2 = new OutrightLeagueCompetition<>();
        
        update1.competition = competition1;
        update2.competition = competition2;
        
        assertNotSame(update1.competition, update2.competition);
        assertSame(competition1, update1.competition);
        assertSame(competition2, update2.competition);
    }
}
