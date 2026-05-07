package eu.lsports.trade360_java_sdk.common.entities.outright_league;

import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Location;
import eu.lsports.trade360_java_sdk.common.entities.fixtures.Sport;
import eu.lsports.trade360_java_sdk.common.entities.shared.IdNamePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import eu.lsports.trade360_java_sdk.common.entities.shared.Subscription;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OutrightLeagueFixtureTest {
    @Test
    void testFieldAssignmentAndNullability() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        assertNull(fixture.subscription);
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.startDate);
        assertNull(fixture.lastUpdate);
        assertNull(fixture.endDate);
        assertNull(fixture.status);
        assertNull(fixture.extraData);

        fixture.subscription = new Subscription();
        fixture.sport = new Sport();
        fixture.location = new Location();
        Instant start = Instant.now().minus(1, ChronoUnit.HOURS);
        Instant now = Instant.now();
        fixture.startDate = start;
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.FINISHED;
        fixture.endDate = Instant.now().plus(2, ChronoUnit.HOURS);

        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        fixture.extraData = Arrays.asList(nvp);

        assertNotNull(fixture.subscription);
        assertNotNull(fixture.sport);
        assertNotNull(fixture.location);
        assertEquals(start, fixture.startDate);
        assertEquals(now, fixture.lastUpdate);
        assertEquals(FixtureStatus.FINISHED, fixture.status);
        assertNotNull(fixture.extraData);
        assertEquals(now, fixture.lastUpdate);
    }

    @Test
    void testInstantiation() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();
        assertNotNull(fixture);
    }

    @Test
    void testFixtureNameAndSeasonFields() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();

        assertNull(fixture.fixtureName);
        assertNull(fixture.season);

        fixture.fixtureName = "Test League Fixture Name";
        fixture.season = new IdNamePair(2024, "Season 2024");

        assertEquals("Test League Fixture Name", fixture.fixtureName);
        assertNotNull(fixture.season);
        assertEquals(2024, fixture.season.id());
        assertEquals("Season 2024", fixture.season.name());
    }

    @Test
    void testFixtureNameAndSeasonNullability() {
        OutrightLeagueFixture fixture = new OutrightLeagueFixture();

        fixture.fixtureName = null;
        fixture.season = null;

        assertNull(fixture.fixtureName);
        assertNull(fixture.season);
    }
} 