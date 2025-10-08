package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.FixtureVenue;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightFixtureTest {
    @Test
    void testInstantiation() {
        OutrightFixture fixture = new OutrightFixture();
        assertNotNull(fixture);
    }

    @Test
    void testFieldAssignmentAndNullability() {
        OutrightFixture fixture = new OutrightFixture();
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.venue);
        assertNull(fixture.startDate);
        assertNull(fixture.lastUpdate);
        assertNull(fixture.status);
        assertNull(fixture.participants);
        assertNull(fixture.extraData);
        assertNull(fixture.subscription);

        fixture.sport = new Sport();
        fixture.location = new Location();
        fixture.venue = new FixtureVenue();
        LocalDateTime now = LocalDateTime.now();
        fixture.startDate = now;
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.FINISHED;
        fixture.participants = Arrays.asList(new OutrightParticipant());
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        fixture.extraData = Arrays.asList(nvp);
        fixture.subscription = new Subscription();

        assertNotNull(fixture.sport);
        assertNotNull(fixture.location);
        assertNotNull(fixture.venue);
        assertEquals(now, fixture.startDate);
        assertEquals(now, fixture.lastUpdate);
        assertEquals(FixtureStatus.FINISHED, fixture.status);
        assertNotNull(fixture.participants);
        assertNotNull(fixture.extraData);
        assertNotNull(fixture.subscription);
    }

    @Test
    void testVenueFieldAssignment() {
        OutrightFixture fixture = new OutrightFixture();
        FixtureVenue venue = new FixtureVenue();
        venue.id = 200;
        venue.name = "Outright Venue";
        
        fixture.venue = venue;
        
        assertNotNull(fixture.venue);
        assertEquals(200, fixture.venue.id);
        assertEquals("Outright Venue", fixture.venue.name);
    }

    @Test
    void testVenueNullability() {
        OutrightFixture fixture = new OutrightFixture();
        
        fixture.venue = null;
        
        assertNull(fixture.venue);
    }
}