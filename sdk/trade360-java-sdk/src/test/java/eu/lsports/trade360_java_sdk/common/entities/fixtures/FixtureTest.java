package eu.lsports.trade360_java_sdk.common.entities.fixtures;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
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
        assertNull(fixture.league);
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
        fixture.league = new League();
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
        assertNotNull(fixture.league);
        assertEquals(now, fixture.startDate);
        assertNotNull(fixture.participants);
        assertNotNull(fixture.fixtureExtraData);
        assertEquals("ext123", fixture.externalFixtureId);
        assertNotNull(fixture.subscription);
    }
} 