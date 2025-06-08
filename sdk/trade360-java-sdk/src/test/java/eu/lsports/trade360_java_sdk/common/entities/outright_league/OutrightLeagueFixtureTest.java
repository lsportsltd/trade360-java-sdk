package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueFixtureTest {
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        assertNull(fixture.subscription);
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.lastUpdate);
        assertNull(fixture.status);
        assertNull(fixture.extraData);

        fixture.subscription = new Subscription();
        fixture.sport = new Sport();
        fixture.location = new Location();
        LocalDateTime now = LocalDateTime.now();
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.FINISHED;
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        fixture.extraData = Arrays.asList(nvp);

        assertNotNull(fixture.subscription);
        assertNotNull(fixture.sport);
        assertNotNull(fixture.location);
        assertEquals(now, fixture.lastUpdate);
        assertEquals(FixtureStatus.FINISHED, fixture.status);
        assertNotNull(fixture.extraData);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        assertNotNull(fixture);
    }
} 