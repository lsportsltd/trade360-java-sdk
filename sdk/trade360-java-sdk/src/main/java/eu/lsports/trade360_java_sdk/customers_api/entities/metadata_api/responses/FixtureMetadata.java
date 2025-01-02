package eu.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.time.LocalDateTime;
import eu.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;
import jakarta.annotation.Nullable;

/**
 * The {@code FixtureMetadata} record represents metadata for a fixture.
 *
 * @param fixtureId the ID of the fixture
 * @param fixtureName the name of the fixture
 * @param startDate the start date of the fixture in UTC
 * @param lastUpdate the last update date of the fixture in UTC
 * @param sportId the ID of the sport associated with the fixture
 * @param locationId the ID of the location associated with the fixture
 * @param leagueId the ID of the league associated with the fixture
 * @param fixtureStatus the status of the fixture
 * @param participants the participants in the fixture
 * @see LocalDateTime
 * @see FixtureStatus
 */
public final record FixtureMetadata(
    int fixtureId,
    @Nullable String fixtureName,
    LocalDateTime startDate,
    LocalDateTime lastUpdate,
    int sportId,
    int locationId,
    int leagueId,
    FixtureStatus fixtureStatus,
    @Nullable Iterable<Participant> participants) {
}