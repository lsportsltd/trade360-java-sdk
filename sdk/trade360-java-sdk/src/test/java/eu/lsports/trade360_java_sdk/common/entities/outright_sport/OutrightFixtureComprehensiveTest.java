package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureComprehensiveTest {

    @Test
    void testOutrightFixtureDefaultConstructor() {
        OutrightFixture outrightFixture = new OutrightFixture();
        
        assertNotNull(outrightFixture);
        assertNull(outrightFixture.sport);
        assertNull(outrightFixture.location);
        assertNull(outrightFixture.startDate);
        assertNull(outrightFixture.lastUpdate);
        assertNull(outrightFixture.status);
        assertNull(outrightFixture.participants);
        assertNull(outrightFixture.extraData);
        assertNull(outrightFixture.subscription);
    }

    @Test
    void testOutrightFixtureSportAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        Sport testSport = new Sport();
        
        outrightFixture.sport = testSport;
        
        assertEquals(testSport, outrightFixture.sport);
    }

    @Test
    void testOutrightFixtureLocationAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        Location testLocation = new Location();
        
        outrightFixture.location = testLocation;
        
        assertEquals(testLocation, outrightFixture.location);
    }

    @Test
    void testOutrightFixtureStartDateAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        LocalDateTime testStartDate = LocalDateTime.now();
        
        outrightFixture.startDate = testStartDate;
        
        assertEquals(testStartDate, outrightFixture.startDate);
    }

    @Test
    void testOutrightFixtureLastUpdateAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        LocalDateTime testLastUpdate = LocalDateTime.now();
        
        outrightFixture.lastUpdate = testLastUpdate;
        
        assertEquals(testLastUpdate, outrightFixture.lastUpdate);
    }

    @Test
    void testOutrightFixtureStatusAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        FixtureStatus testStatus = FixtureStatus.NSY;
        
        outrightFixture.status = testStatus;
        
        assertEquals(testStatus, outrightFixture.status);
    }

    @Test
    void testOutrightFixtureParticipantsAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        OutrightParticipant participant1 = new OutrightParticipant();
        OutrightParticipant participant2 = new OutrightParticipant();
        Iterable<OutrightParticipant> testParticipants = Arrays.asList(participant1, participant2);
        
        outrightFixture.participants = testParticipants;
        
        assertEquals(testParticipants, outrightFixture.participants);
    }

    @Test
    void testOutrightFixtureExtraDataAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        NameValuePair extraData1 = new NameValuePair();
        NameValuePair extraData2 = new NameValuePair();
        Iterable<NameValuePair> testExtraData = Arrays.asList(extraData1, extraData2);
        
        outrightFixture.extraData = testExtraData;
        
        assertEquals(testExtraData, outrightFixture.extraData);
    }

    @Test
    void testOutrightFixtureSubscriptionAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        Subscription testSubscription = new Subscription();
        
        outrightFixture.subscription = testSubscription;
        
        assertEquals(testSubscription, outrightFixture.subscription);
    }

    @Test
    void testOutrightFixtureAllFieldsAssignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        Sport testSport = new Sport();
        Location testLocation = new Location();
        LocalDateTime testStartDate = LocalDateTime.now();
        LocalDateTime testLastUpdate = LocalDateTime.now();
        FixtureStatus testStatus = FixtureStatus.IN_PROGRESS;
        Iterable<OutrightParticipant> testParticipants = Collections.singletonList(new OutrightParticipant());
        Iterable<NameValuePair> testExtraData = Collections.singletonList(new NameValuePair());
        Subscription testSubscription = new Subscription();
        
        outrightFixture.sport = testSport;
        outrightFixture.location = testLocation;
        outrightFixture.startDate = testStartDate;
        outrightFixture.lastUpdate = testLastUpdate;
        outrightFixture.status = testStatus;
        outrightFixture.participants = testParticipants;
        outrightFixture.extraData = testExtraData;
        outrightFixture.subscription = testSubscription;
        
        assertEquals(testSport, outrightFixture.sport);
        assertEquals(testLocation, outrightFixture.location);
        assertEquals(testStartDate, outrightFixture.startDate);
        assertEquals(testLastUpdate, outrightFixture.lastUpdate);
        assertEquals(testStatus, outrightFixture.status);
        assertEquals(testParticipants, outrightFixture.participants);
        assertEquals(testExtraData, outrightFixture.extraData);
        assertEquals(testSubscription, outrightFixture.subscription);
    }

    @Test
    void testOutrightFixtureNullAssignments() {
        OutrightFixture outrightFixture = new OutrightFixture();
        
        outrightFixture.sport = null;
        outrightFixture.location = null;
        outrightFixture.startDate = null;
        outrightFixture.lastUpdate = null;
        outrightFixture.status = null;
        outrightFixture.participants = null;
        outrightFixture.extraData = null;
        outrightFixture.subscription = null;
        
        assertNull(outrightFixture.sport);
        assertNull(outrightFixture.location);
        assertNull(outrightFixture.startDate);
        assertNull(outrightFixture.lastUpdate);
        assertNull(outrightFixture.status);
        assertNull(outrightFixture.participants);
        assertNull(outrightFixture.extraData);
        assertNull(outrightFixture.subscription);
    }

    @Test
    void testOutrightFixtureReassignment() {
        OutrightFixture outrightFixture = new OutrightFixture();
        
        outrightFixture.sport = new Sport();
        outrightFixture.status = FixtureStatus.NSY;
        
        assertNotNull(outrightFixture.sport);
        assertEquals(FixtureStatus.NSY, outrightFixture.status);
        
        outrightFixture.sport = new Sport();
        outrightFixture.status = FixtureStatus.FINISHED;
        
        assertNotNull(outrightFixture.sport);
        assertEquals(FixtureStatus.FINISHED, outrightFixture.status);
    }

    @Test
    void testMultipleOutrightFixtureInstances() {
        OutrightFixture outrightFixture1 = new OutrightFixture();
        OutrightFixture outrightFixture2 = new OutrightFixture();
        
        outrightFixture1.sport = new Sport();
        outrightFixture1.status = FixtureStatus.NSY;
        
        outrightFixture2.sport = new Sport();
        outrightFixture2.status = FixtureStatus.IN_PROGRESS;
        
        assertNotNull(outrightFixture1.sport);
        assertNotNull(outrightFixture2.sport);
        assertEquals(FixtureStatus.NSY, outrightFixture1.status);
        assertEquals(FixtureStatus.IN_PROGRESS, outrightFixture2.status);
        
        assertNotSame(outrightFixture1.sport, outrightFixture2.sport);
        assertNotEquals(outrightFixture1.status, outrightFixture2.status);
    }

    @Test
    void testOutrightFixtureFieldIndependence() {
        OutrightFixture outrightFixture = new OutrightFixture();
        
        outrightFixture.sport = new Sport();
        assertNull(outrightFixture.location);
        
        outrightFixture.location = new Location();
        assertNotNull(outrightFixture.sport);
    }

    @Test
    void testOutrightFixtureConsistency() {
        OutrightFixture outrightFixture1 = new OutrightFixture();
        OutrightFixture outrightFixture2 = new OutrightFixture();
        
        Sport testSport = new Sport();
        FixtureStatus testStatus = FixtureStatus.CANCELLED;
        
        outrightFixture1.sport = testSport;
        outrightFixture1.status = testStatus;
        
        outrightFixture2.sport = testSport;
        outrightFixture2.status = testStatus;
        
        assertSame(outrightFixture1.sport, outrightFixture2.sport);
        assertEquals(outrightFixture1.status, outrightFixture2.status);
    }

    @Test
    void testOutrightFixtureEmptyCollections() {
        OutrightFixture outrightFixture = new OutrightFixture();
        
        outrightFixture.participants = Collections.emptyList();
        outrightFixture.extraData = Collections.emptyList();
        
        assertEquals(Collections.emptyList(), outrightFixture.participants);
        assertEquals(Collections.emptyList(), outrightFixture.extraData);
        assertNotNull(outrightFixture.participants);
        assertNotNull(outrightFixture.extraData);
    }
}
