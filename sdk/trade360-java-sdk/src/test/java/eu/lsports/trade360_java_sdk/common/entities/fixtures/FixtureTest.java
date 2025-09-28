package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class FixtureTest {
    @Test
    void testFieldAssignmentAndNullability() {
        Fixture fixture = new Fixture();
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.venue);
        assertNull(fixture.league);
        assertNull(fixture.stage);
        assertNull(fixture.round);
        assertNull(fixture.startDate);
        assertNull(fixture.participants);
        assertNull(fixture.fixtureExtraData);
        assertNull(fixture.externalFixtureId);
        assertNull(fixture.subscription);

        LocalDateTime now = LocalDateTime.now();
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.NSY;
        fixture.sport = new Sport();
        fixture.location = new Location();
        fixture.venue = new FixtureVenue();
        fixture.league = new League();
        IdNamePair stage = new IdNamePair();
        stage.id = 1;
        stage.name = "Group Stage";
        fixture.stage = stage;
        IdNamePair round = new IdNamePair();
        round.id = 2;
        round.name = "Round 1";
        fixture.round = round;
        fixture.startDate = now;
        fixture.participants = Arrays.asList(new Participant());
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        fixture.fixtureExtraData = Arrays.asList(nvp);
        fixture.externalFixtureId = "ext123";
        fixture.subscription = new Subscription();

        assertEquals(now, fixture.lastUpdate);
        assertEquals(FixtureStatus.NSY, fixture.status);
        assertNotNull(fixture.sport);
        assertNotNull(fixture.location);
        assertNotNull(fixture.venue);
        assertNotNull(fixture.league);
        assertNotNull(fixture.stage);
        assertEquals(1, fixture.stage.id);
        assertEquals("Group Stage", fixture.stage.name);
        assertNotNull(fixture.round);
        assertEquals(2, fixture.round.id);
        assertEquals("Round 1", fixture.round.name);
        assertEquals(now, fixture.startDate);
        assertNotNull(fixture.participants);
        assertNotNull(fixture.fixtureExtraData);
        assertEquals("ext123", fixture.externalFixtureId);
        assertNotNull(fixture.subscription);
    }

    @Test
    void testVenueFieldAssignment() {
        Fixture fixture = new Fixture();
        FixtureVenue venue = new FixtureVenue();
        venue.id = 100;
        venue.name = "Test Stadium";
        
        fixture.venue = venue;
        
        assertNotNull(fixture.venue);
        assertEquals(100, fixture.venue.id);
        assertEquals("Test Stadium", fixture.venue.name);
    }

    @Test
    void testStageFieldAssignment() {
        Fixture fixture = new Fixture();
        IdNamePair stage = new IdNamePair();
        stage.id = 5;
        stage.name = "Knockout Stage";
        
        fixture.stage = stage;
        
        assertNotNull(fixture.stage);
        assertEquals(5, fixture.stage.id);
        assertEquals("Knockout Stage", fixture.stage.name);
    }

    @Test
    void testRoundFieldAssignment() {
        Fixture fixture = new Fixture();
        IdNamePair round = new IdNamePair();
        round.id = 10;
        round.name = "Final";
        
        fixture.round = round;
        
        assertNotNull(fixture.round);
        assertEquals(10, fixture.round.id);
        assertEquals("Final", fixture.round.name);
    }

    @Test
    void testNewFieldsNullability() {
        Fixture fixture = new Fixture();
        
        fixture.venue = null;
        fixture.stage = null;
        fixture.round = null;
        
        assertNull(fixture.venue);
        assertNull(fixture.stage);
        assertNull(fixture.round);
    }
}