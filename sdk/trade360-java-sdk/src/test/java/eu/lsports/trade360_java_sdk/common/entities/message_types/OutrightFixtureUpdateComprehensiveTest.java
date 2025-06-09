package eu.lsports.trade360_java_sdk.common.entities.message_types;

import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightCompetition;
import eu.lsports.trade360_java_sdk.common.entities.outright_sport.OutrightFixtureEvent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureUpdateComprehensiveTest {

    @Test
    void testOutrightFixtureUpdateDefaultConstructor() {
        OutrightFixtureUpdate outrightFixtureUpdate = new OutrightFixtureUpdate();
        
        assertNotNull(outrightFixtureUpdate);
        assertNull(outrightFixtureUpdate.competition);
        assertEquals(37, OutrightFixtureUpdate.entityKey);
    }

    @Test
    void testOutrightFixtureUpdateCompetitionAssignment() {
        OutrightFixtureUpdate outrightFixtureUpdate = new OutrightFixtureUpdate();
        OutrightCompetition<OutrightFixtureEvent> testCompetition = new OutrightCompetition<>();
        
        outrightFixtureUpdate.competition = testCompetition;
        
        assertEquals(testCompetition, outrightFixtureUpdate.competition);
    }

    @Test
    void testOutrightFixtureUpdateNullAssignments() {
        OutrightFixtureUpdate outrightFixtureUpdate = new OutrightFixtureUpdate();
        
        outrightFixtureUpdate.competition = null;
        
        assertNull(outrightFixtureUpdate.competition);
    }

    @Test
    void testOutrightFixtureUpdateReassignment() {
        OutrightFixtureUpdate outrightFixtureUpdate = new OutrightFixtureUpdate();
        
        outrightFixtureUpdate.competition = new OutrightCompetition<>();
        assertNotNull(outrightFixtureUpdate.competition);
        
        outrightFixtureUpdate.competition = new OutrightCompetition<>();
        assertNotNull(outrightFixtureUpdate.competition);
    }

    @Test
    void testMultipleOutrightFixtureUpdateInstances() {
        OutrightFixtureUpdate outrightFixtureUpdate1 = new OutrightFixtureUpdate();
        OutrightFixtureUpdate outrightFixtureUpdate2 = new OutrightFixtureUpdate();
        
        outrightFixtureUpdate1.competition = new OutrightCompetition<>();
        outrightFixtureUpdate2.competition = new OutrightCompetition<>();
        
        assertNotSame(outrightFixtureUpdate1.competition, outrightFixtureUpdate2.competition);
    }

    @Test
    void testOutrightFixtureUpdateConsistency() {
        OutrightFixtureUpdate outrightFixtureUpdate1 = new OutrightFixtureUpdate();
        OutrightFixtureUpdate outrightFixtureUpdate2 = new OutrightFixtureUpdate();
        
        OutrightCompetition<OutrightFixtureEvent> testCompetition = new OutrightCompetition<>();
        
        outrightFixtureUpdate1.competition = testCompetition;
        outrightFixtureUpdate2.competition = testCompetition;
        
        assertSame(outrightFixtureUpdate1.competition, outrightFixtureUpdate2.competition);
    }

    @Test
    void testOutrightFixtureUpdateEntityKey() {
        assertEquals(37, OutrightFixtureUpdate.entityKey);
    }
}
