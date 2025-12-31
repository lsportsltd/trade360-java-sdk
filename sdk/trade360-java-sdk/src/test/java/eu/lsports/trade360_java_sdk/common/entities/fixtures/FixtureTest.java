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
        assertNull(fixture.fixtureName);
        assertNull(fixture.sport);
        assertNull(fixture.location);
        assertNull(fixture.venue);
        assertNull(fixture.league);
        assertNull(fixture.stage);
        assertNull(fixture.round);
        assertNull(fixture.season);
        assertNull(fixture.startDate);
        assertNull(fixture.participants);
        assertNull(fixture.fixtureExtraData);
        assertNull(fixture.externalFixtureId);
        assertNull(fixture.subscription);

        LocalDateTime now = LocalDateTime.now();
        fixture.fixtureName = "Team A vs Team B";
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.NSY;
        fixture.sport = new Sport();
        fixture.location = new Location();
        fixture.venue = new FixtureVenue();
        fixture.league = new League();
        fixture.stage = new IdNamePair(1, "Group Stage");
        fixture.round = new IdNamePair(2, "Round 1");
        fixture.season = new IdNamePair(2024, "2024-2025");
        fixture.startDate = now;
        fixture.participants = Arrays.asList(new Participant());
        NameValuePair nvp = new NameValuePair();
        nvp.name = "key";
        nvp.value = "value";
        fixture.fixtureExtraData = Arrays.asList(nvp);
        fixture.externalFixtureId = "ext123";
        fixture.subscription = new Subscription();

        assertEquals("Team A vs Team B", fixture.fixtureName);
        assertEquals(now, fixture.lastUpdate);
        assertEquals(FixtureStatus.NSY, fixture.status);
        assertNotNull(fixture.sport);
        assertNotNull(fixture.location);
        assertNotNull(fixture.venue);
        assertNotNull(fixture.league);
        assertNotNull(fixture.stage);
        assertEquals("Group Stage", fixture.stage.name());
        assertNotNull(fixture.round);
        assertEquals("Round 1", fixture.round.name());
        assertNotNull(fixture.season);
        assertEquals(2024, fixture.season.id());
        assertEquals("2024-2025", fixture.season.name());
        assertNotNull(fixture.participants);
        assertNotNull(fixture.fixtureExtraData);
        assertEquals("ext123", fixture.externalFixtureId);
        assertNotNull(fixture.subscription);
    }

    @Test
    void testFixtureNameAssignment() {
        Fixture fixture = new Fixture();

        fixture.fixtureName = "Champions League Final";
        assertEquals("Champions League Final", fixture.fixtureName);

        fixture.fixtureName = "World Cup Qualifier";
        assertEquals("World Cup Qualifier", fixture.fixtureName);

        fixture.fixtureName = null;
        assertNull(fixture.fixtureName);
    }

    @Test
    void testSeasonAssignment() {
        Fixture fixture = new Fixture();

        fixture.season = new IdNamePair(2024, "2024-2025");
        assertNotNull(fixture.season);
        assertEquals(2024, fixture.season.id());
        assertEquals("2024-2025", fixture.season.name());

        fixture.season = new IdNamePair(2023, "2023-2024");
        assertEquals(2023, fixture.season.id());
        assertEquals("2023-2024", fixture.season.name());

        fixture.season = null;
        assertNull(fixture.season);
    }

    @Test
    void testStageAssignment() {
        Fixture fixture = new Fixture();

        fixture.stage = new IdNamePair(1, "Group Stage");
        assertNotNull(fixture.stage);
        assertEquals(1, fixture.stage.id());
        assertEquals("Group Stage", fixture.stage.name());

        fixture.stage = new IdNamePair(2, "Knockout");
        assertEquals(2, fixture.stage.id());
        assertEquals("Knockout", fixture.stage.name());

        fixture.stage = null;
        assertNull(fixture.stage);
    }

    @Test
    void testRoundAssignment() {
        Fixture fixture = new Fixture();

        fixture.round = new IdNamePair(1, "Round of 16");
        assertNotNull(fixture.round);
        assertEquals(1, fixture.round.id());
        assertEquals("Round of 16", fixture.round.name());

        fixture.round = new IdNamePair(2, "Quarter Finals");
        assertEquals(2, fixture.round.id());
        assertEquals("Quarter Finals", fixture.round.name());

        fixture.round = null;
        assertNull(fixture.round);
    }

    @Test
    void testCompleteFixtureWithAllNewFields() {
        Fixture fixture = new Fixture();
        LocalDateTime now = LocalDateTime.now();

        fixture.fixtureName = "Manchester United vs Liverpool";
        fixture.sport = new Sport();
        fixture.sport.id = 1;
        fixture.sport.name = "Football";
        fixture.location = new Location();
        fixture.location.id = 1;
        fixture.location.name = "England";

        League league = new League();
        league.id = 1;
        league.name = "Premier League";
        league.tour = new IdNamePair(1, "Domestic League");
        league.sportCategory = new IdNamePair(1, "Football");
        fixture.league = league;

        fixture.stage = new IdNamePair(1, "Regular Season");
        fixture.round = new IdNamePair(10, "Matchday 10");
        fixture.season = new IdNamePair(2024, "2024-2025");
        fixture.startDate = now;
        fixture.lastUpdate = now;
        fixture.status = FixtureStatus.NSY;
        fixture.externalFixtureId = "EXT-MU-LIV-2024";

        Participant homeTeam = new Participant();
        homeTeam.id = 1;
        homeTeam.name = "Manchester United";
        homeTeam.form = "WDWWL";
        homeTeam.formation = "4-2-3-1";

        Participant awayTeam = new Participant();
        awayTeam.id = 2;
        awayTeam.name = "Liverpool";
        awayTeam.form = "WWWDW";
        awayTeam.formation = "4-3-3";

        fixture.participants = Arrays.asList(homeTeam, awayTeam);

        assertEquals("Manchester United vs Liverpool", fixture.fixtureName);
        assertEquals("Football", fixture.sport.name);
        assertEquals("Premier League", fixture.league.name);
        assertEquals("Domestic League", fixture.league.tour.name());
        assertEquals("Football", fixture.league.sportCategory.name());
        assertEquals("Regular Season", fixture.stage.name());
        assertEquals("Matchday 10", fixture.round.name());
        assertEquals("2024-2025", fixture.season.name());
        assertEquals(2024, fixture.season.id());
        assertNotNull(fixture.participants);
    }
}
