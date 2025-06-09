package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FixtureComprehensiveTest {

    @Test
    void testFixtureDefaultConstructor() {
        Fixture fixture = new Fixture();
        
        assertNotNull(fixture);
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.league);
        assertNull(fixture.startDate);
        assertNull(fixture.lastUpdate);
        assertNull(fixture.status);
        assertNull(fixture.participants);
        assertNull(fixture.fixtureExtraData);
        assertNull(fixture.externalFixtureId);
        assertNull(fixture.subscription);
    }

    @Test
    void testFixtureSportAssignment() {
        Fixture fixture = new Fixture();
        Sport testSport = new Sport();
        
        fixture.sport = testSport;
        
        assertEquals(testSport, fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.league);
    }

    @Test
    void testFixtureLocationAssignment() {
        Fixture fixture = new Fixture();
        Location testLocation = new Location();
        
        fixture.location = testLocation;
        
        assertEquals(testLocation, fixture.location);
        assertNull(fixture.sport);
        assertNull(fixture.league);
    }

    @Test
    void testFixtureLeagueAssignment() {
        Fixture fixture = new Fixture();
        League testLeague = new League();
        
        fixture.league = testLeague;
        
        assertEquals(testLeague, fixture.league);
        assertNull(fixture.sport);
        assertNull(fixture.location);
    }

    @Test
    void testFixtureStartDateAssignment() {
        Fixture fixture = new Fixture();
        LocalDateTime testStartDate = LocalDateTime.now();
        
        fixture.startDate = testStartDate;
        
        assertEquals(testStartDate, fixture.startDate);
        assertNull(fixture.lastUpdate);
    }

    @Test
    void testFixtureLastUpdateAssignment() {
        Fixture fixture = new Fixture();
        LocalDateTime testLastUpdate = LocalDateTime.now();
        
        fixture.lastUpdate = testLastUpdate;
        
        assertEquals(testLastUpdate, fixture.lastUpdate);
        assertNull(fixture.startDate);
    }

    @Test
    void testFixtureStatusAssignment() {
        Fixture fixture = new Fixture();
        FixtureStatus testStatus = FixtureStatus.NSY;
        
        fixture.status = testStatus;
        
        assertEquals(testStatus, fixture.status);
    }

    @Test
    void testFixtureParticipantsAssignment() {
        Fixture fixture = new Fixture();
        Participant participant1 = new Participant();
        Participant participant2 = new Participant();
        Iterable<Participant> testParticipants = Arrays.asList(participant1, participant2);
        
        fixture.participants = testParticipants;
        
        assertEquals(testParticipants, fixture.participants);
        assertNull(fixture.fixtureExtraData);
    }

    @Test
    void testFixtureExtraDataAssignment() {
        Fixture fixture = new Fixture();
        NameValuePair pair = new NameValuePair();
        Iterable<NameValuePair> testExtraData = Collections.singletonList(pair);
        
        fixture.fixtureExtraData = testExtraData;
        
        assertEquals(testExtraData, fixture.fixtureExtraData);
        assertNull(fixture.participants);
    }

    @Test
    void testFixtureExternalIdAssignment() {
        Fixture fixture = new Fixture();
        String testExternalId = "EXT-12345";
        
        fixture.externalFixtureId = testExternalId;
        
        assertEquals(testExternalId, fixture.externalFixtureId);
        assertNull(fixture.subscription);
    }

    @Test
    void testFixtureSubscriptionAssignment() {
        Fixture fixture = new Fixture();
        Subscription testSubscription = new Subscription();
        
        fixture.subscription = testSubscription;
        
        assertEquals(testSubscription, fixture.subscription);
        assertNull(fixture.externalFixtureId);
    }

    @Test
    void testFixtureAllFieldsAssignment() {
        Fixture fixture = new Fixture();
        Sport testSport = new Sport();
        Location testLocation = new Location();
        League testLeague = new League();
        LocalDateTime testStartDate = LocalDateTime.now();
        LocalDateTime testLastUpdate = LocalDateTime.now();
        FixtureStatus testStatus = FixtureStatus.IN_PROGRESS;
        Iterable<Participant> testParticipants = Collections.singletonList(new Participant());
        Iterable<NameValuePair> testExtraData = Collections.singletonList(new NameValuePair());
        String testExternalId = "EXT-67890";
        Subscription testSubscription = new Subscription();
        
        fixture.sport = testSport;
        fixture.location = testLocation;
        fixture.league = testLeague;
        fixture.startDate = testStartDate;
        fixture.lastUpdate = testLastUpdate;
        fixture.status = testStatus;
        fixture.participants = testParticipants;
        fixture.fixtureExtraData = testExtraData;
        fixture.externalFixtureId = testExternalId;
        fixture.subscription = testSubscription;
        
        assertEquals(testSport, fixture.sport);
        assertEquals(testLocation, fixture.location);
        assertEquals(testLeague, fixture.league);
        assertEquals(testStartDate, fixture.startDate);
        assertEquals(testLastUpdate, fixture.lastUpdate);
        assertEquals(testStatus, fixture.status);
        assertEquals(testParticipants, fixture.participants);
        assertEquals(testExtraData, fixture.fixtureExtraData);
        assertEquals(testExternalId, fixture.externalFixtureId);
        assertEquals(testSubscription, fixture.subscription);
    }

    @Test
    void testFixtureNullAssignments() {
        Fixture fixture = new Fixture();
        
        fixture.sport = null;
        fixture.location = null;
        fixture.league = null;
        fixture.startDate = null;
        fixture.participants = null;
        fixture.fixtureExtraData = null;
        fixture.externalFixtureId = null;
        fixture.subscription = null;
        
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.league);
        assertNull(fixture.startDate);
        assertNull(fixture.participants);
        assertNull(fixture.fixtureExtraData);
        assertNull(fixture.externalFixtureId);
        assertNull(fixture.subscription);
    }

    @Test
    void testMultipleFixtureInstances() {
        Fixture fixture1 = new Fixture();
        Fixture fixture2 = new Fixture();
        
        fixture1.sport = new Sport();
        fixture1.status = FixtureStatus.NSY;
        fixture1.externalFixtureId = "EXT-100";
        
        fixture2.sport = new Sport();
        fixture2.status = FixtureStatus.FINISHED;
        fixture2.externalFixtureId = "EXT-200";
        
        assertNotSame(fixture1.sport, fixture2.sport);
        assertNotEquals(fixture1.status, fixture2.status);
        assertNotEquals(fixture1.externalFixtureId, fixture2.externalFixtureId);
    }

    @Test
    void testFixtureConsistency() {
        Fixture fixture1 = new Fixture();
        Fixture fixture2 = new Fixture();
        
        Sport testSport = new Sport();
        FixtureStatus testStatus = FixtureStatus.IN_PROGRESS;
        String testExternalId = "EXT-999";
        
        fixture1.sport = testSport;
        fixture1.status = testStatus;
        fixture1.externalFixtureId = testExternalId;
        
        fixture2.sport = testSport;
        fixture2.status = testStatus;
        fixture2.externalFixtureId = testExternalId;
        
        assertSame(fixture1.sport, fixture2.sport);
        assertEquals(fixture1.status, fixture2.status);
        assertEquals(fixture1.externalFixtureId, fixture2.externalFixtureId);
    }
}
