package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

class FixtureMetadataTest {
    @Test
    void testConstructorAndFields() {
        int fixtureId = 1;
        String fixtureName = "Fixture";
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime lastUpdate = LocalDateTime.now();
        int sportId = 2;
        int locationId = 3;
        int leagueId = 4;
        FixtureStatus fixtureStatus = FixtureStatus.NSY;
        List<Participant> participants = List.of();
        FixtureMetadata fm = new FixtureMetadata(fixtureId, fixtureName, startDate, lastUpdate, sportId, locationId, leagueId, fixtureStatus, participants);
        assertEquals(fixtureId, fm.fixtureId());
        assertEquals(fixtureName, fm.fixtureName());
        assertEquals(startDate, fm.startDate());
        assertEquals(lastUpdate, fm.lastUpdate());
        assertEquals(sportId, fm.sportId());
        assertEquals(locationId, fm.locationId());
        assertEquals(leagueId, fm.leagueId());
        assertEquals(fixtureStatus, fm.fixtureStatus());
        assertEquals(participants, fm.participants());
    }
} 