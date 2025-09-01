package eu.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueEvent;
import eu.lsports.trade360_java_sdk.common.entities.outright_league.OutrightLeagueCompetition;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class GetOutrightLeagueEventsResultElementTest {
    
    @Test
    void testInstantiation() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        assertNotNull(element);
    }
    
    @Test
    void testInheritanceFromOutrightLeagueCompetitionsWrapper() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Test that it's an instance of the parent class
        assertTrue(element instanceof OutrightLeagueCompetitionsWrapper);
        assertTrue(element instanceof OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent>);
    }
    
    @Test
    void testGenericTypeHandling() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Test initial state
        assertNull(element.competition);
        
        // Test assignment of competition with OutrightLeagueEvent type
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        element.competition = Arrays.asList(competition);
        
        assertNotNull(element.competition);
        assertEquals(1, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition).size());
        assertSame(competition, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition).get(0));
    }
    
    @Test
    void testCompetitionCollectionAssignment() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Create multiple competitions
        OutrightLeagueCompetition<OutrightLeagueEvent> competition1 = new OutrightLeagueCompetition<>();
        competition1.id = 1;
        competition1.name = "Competition 1";
        
        OutrightLeagueCompetition<OutrightLeagueEvent> competition2 = new OutrightLeagueCompetition<>();
        competition2.id = 2;
        competition2.name = "Competition 2";
        
        // Assign collection
        element.competition = Arrays.asList(competition1, competition2);
        
        assertNotNull(element.competition);
        assertEquals(2, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition).size());
        
        // Verify the competitions are correctly stored
        java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>> competitions = 
            (java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition;
        assertEquals(1, competitions.get(0).id);
        assertEquals("Competition 1", competitions.get(0).name);
        assertEquals(2, competitions.get(1).id);
        assertEquals("Competition 2", competitions.get(1).name);
    }
    
    @Test
    void testEmptyCompetitionCollection() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Test empty collection assignment
        element.competition = Arrays.asList();
        
        assertNotNull(element.competition);
        assertEquals(0, ((java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition).size());
    }
    
    @Test
    void testNullCompetitionAssignment() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Test null assignment
        element.competition = null;
        assertNull(element.competition);
        
        // Test reassignment after null
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        element.competition = Arrays.asList(competition);
        assertNotNull(element.competition);
    }
    
    @Test
    void testPolymorphicBehavior() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // Test that it can be treated as its parent type
        OutrightLeagueCompetitionsWrapper<OutrightLeagueEvent> wrapper = element;
        assertNotNull(wrapper);
        
        // Test that operations work through the parent type
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        wrapper.competition = Arrays.asList(competition);
        
        assertNotNull(wrapper.competition);
        assertSame(wrapper.competition, element.competition);
    }
    
    @Test
    void testMultipleInstances() {
        GetOutrightLeagueEventsResultElement element1 = new GetOutrightLeagueEventsResultElement();
        GetOutrightLeagueEventsResultElement element2 = new GetOutrightLeagueEventsResultElement();
        
        assertNotSame(element1, element2);
        
        // Test that they can have different competitions
        OutrightLeagueCompetition<OutrightLeagueEvent> competition1 = new OutrightLeagueCompetition<>();
        OutrightLeagueCompetition<OutrightLeagueEvent> competition2 = new OutrightLeagueCompetition<>();
        
        element1.competition = Arrays.asList(competition1);
        element2.competition = Arrays.asList(competition2);
        
        assertNotSame(element1.competition, element2.competition);
    }
    
    @Test
    void testTypeParameterConsistency() {
        GetOutrightLeagueEventsResultElement element = new GetOutrightLeagueEventsResultElement();
        
        // This test ensures the generic type is properly maintained
        OutrightLeagueCompetition<OutrightLeagueEvent> competition = new OutrightLeagueCompetition<>();
        element.competition = Arrays.asList(competition);
        
        // Should be able to access as OutrightLeagueEvent type
        assertNotNull(element.competition);
        java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>> competitions = 
            (java.util.List<OutrightLeagueCompetition<OutrightLeagueEvent>>) element.competition;
        assertNotNull(competitions.get(0));
    }
}
