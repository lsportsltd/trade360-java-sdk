package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueEvent;
import eu.lsports.trade360_java_sdk.common.entities.markets.MarketEvent;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueCompetitionsWrapperTest {
    
    @Test
    void testInstantiation() {
        OutrightLeagueCompetitionsWrapper<String> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        assertNotNull(wrapper);
    }
    
    @Test
    void testGenericTypeParameterHandling() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> eventWrapper = new OutrightLeagueCompetitionsWrapper<>();
        OutrightLeagueCompetitionsWrapper<MarketEvent> marketWrapper = new OutrightLeagueCompetitionsWrapper<>();
        OutrightLeagueCompetitionsWrapper<String> stringWrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        assertNotNull(eventWrapper);
        assertNotNull(marketWrapper);
        assertNotNull(stringWrapper);
        
        // All should have null competition initially
        assertNull(eventWrapper.competition);
        assertNull(marketWrapper.competition);
        assertNull(stringWrapper.competition);
    }
    
    @Test
    void testCompetitionCollectionAssignment() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        // Test initial state
        assertNull(wrapper.competition);
        
        // Create competitions
        OutrightLeagueCompetition<OutrightLeagueEvent> competition1 = new OutrightLeagueCompetition<>();
        competition1.id = 100;
        competition1.name = "Test Competition 1";
        
        OutrightLeagueCompetition<OutrightLeagueEvent> competition2 = new OutrightLeagueCompetition<>();
        competition2.id = 200;
        competition2.name = "Test Competition 2";
        
        // Assign collection
        wrapper.competition = Arrays.asList(competition1, competition2);
        
        assertNotNull(wrapper.competition);
        assertEquals(2, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) wrapper.competition).size());
    }
    
    @Test
    void testCompetitionCollectionWithMarketEvent() {
        OutrightLeagueCompetitionsWrapper<MarketEvent> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        OutrightLeagueCompetition<MarketEvent> competition = new OutrightLeagueCompetition<>();
        competition.id = 300;
        competition.name = "Market Competition";
        competition.type = 1;
        
        wrapper.competition = Arrays.asList(competition);
        
        assertNotNull(wrapper.competition);
        assertEquals(1, ((java.util.List<OutrightLeagueCompetition<MarketEvent>>) wrapper.competition).size());
        
        OutrightLeagueCompetition<MarketEvent> retrievedCompetition = 
            ((java.util.List<OutrightLeagueCompetition<MarketEvent>>) wrapper.competition).get(0);
        assertEquals(300, retrievedCompetition.id);
        assertEquals("Market Competition", retrievedCompetition.name);
        assertEquals(1, retrievedCompetition.type);
    }
    
    @Test
    void testEmptyCompetitionCollection() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        wrapper.competition = Arrays.asList();
        
        assertNotNull(wrapper.competition);
        assertEquals(0, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) wrapper.competition).size());
    }
    
    @Test
    void testNullCompetitionAssignment() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        // Test null assignment
        wrapper.competition = null;
        assertNull(wrapper.competition);
        
        // Test assignment after null
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        wrapper.competition = Arrays.asList(competition);
        assertNotNull(wrapper.competition);
        
        // Test null reassignment
        wrapper.competition = null;
        assertNull(wrapper.competition);
    }
    
    @Test
    void testCompetitionReassignment() {
        OutrightLeagueCompetitionsWrapper<String> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        // First assignment
        OutrightLeagueCompetition<String> competition1 = new OutrightLeagueCompetition<>();
        wrapper.competition = Arrays.asList(competition1);
        assertSame(competition1, ((java.util.List<OutrightLeagueCompetition<String>>) wrapper.competition).get(0));
        
        // Reassignment
        OutrightLeagueCompetition<String> competition2 = new OutrightLeagueCompetition<>();
        wrapper.competition = Arrays.asList(competition2);
        assertSame(competition2, ((java.util.List<OutrightLeagueCompetition<String>>) wrapper.competition).get(0));
        assertNotSame(competition1, ((java.util.List<OutrightLeagueCompetition<String>>) wrapper.competition).get(0));
    }
    
    @Test
    void testMultipleWrapperInstances() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper1 = new OutrightLeagueCompetitionsWrapper<>();
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper2 = new OutrightLeagueCompetitionsWrapper<>();
        
        assertNotSame(wrapper1, wrapper2);
        
        // Test independent state
        OutrightLeagueCompetition<OutrightLeagueEvent> competition1 = new OutrightLeagueCompetition<>();
        OutrightLeagueCompetition<OutrightLeagueEvent> competition2 = new OutrightLeagueCompetition<>();
        
        wrapper1.competition = Arrays.asList(competition1);
        wrapper2.competition = Arrays.asList(competition2);
        
        assertNotSame(wrapper1.competition, wrapper2.competition);
    }
    
    @Test
    void testLargeCompetitionCollection() {
        OutrightLeagueCompetitionsWrapper<Integer> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        // Create large collection
        java.util.List<OutrightLeagueCompetition<Integer>> competitions = new java.util.ArrayList<>();
        for (int i = 0; i < 100; i++) {
            OutrightLeagueCompetition<Integer> competition = new OutrightLeagueCompetition<>();
            competition.id = i;
            competition.name = "Competition " + i;
            competitions.add(competition);
        }
        
        wrapper.competition = competitions;
        
        assertNotNull(wrapper.competition);
        assertEquals(100, ((java.util.List<OutrightLeagueCompetition<Integer>>) wrapper.competition).size());
        
        // Verify first and last elements
        java.util.List<OutrightLeagueCompetition<Integer>> retrievedCompetitions = 
            (java.util.List<OutrightLeagueCompetition<Integer>>) wrapper.competition;
        assertEquals(0, retrievedCompetitions.get(0).id);
        assertEquals("Competition 0", retrievedCompetitions.get(0).name);
        assertEquals(99, retrievedCompetitions.get(99).id);
        assertEquals("Competition 99", retrievedCompetitions.get(99).name);
    }
    
    @Test
    void testWrapperFieldAccess() {
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper = new OutrightLeagueCompetitionsWrapper<>();
        
        // Test direct field access
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        competition.id = 500;
        wrapper.competition = Arrays.asList(competition);
        
        // Direct field access should work
        assertNotNull(wrapper.competition);
        OutrightLeagueCompetition<OutrightLeagueEvent> retrieved = 
            ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) wrapper.competition).get(0);
        assertEquals(500, retrieved.id);
    }
}
