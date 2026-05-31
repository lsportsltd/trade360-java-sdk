# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Release Version 2.10.0] - 2026-05-31

### Added

- Added `nextFixtureStartTime` to `OutrightLeagueMarketCompetition` for `OutrightLeagueMarketUpdate` (message type 40) (TR-22695).

### Fixed

- Fixed `GetOutrightLeagueMarkets` snapshot deserialization using feed `OutrightLeagueCompetition` entities instead of snapshot-specific types; added `OutrightLeagueMarketsCompetitionElement` for the correct three-level response shape (TR-22695).

### Changed

- Bumped project/module versions from `2.9.2` to `2.10.0` for a new publishable release.

## [Release Version 2.9.2] - 2026-05-07

### Added

- Added `startDate` to outright league fixture models:
  - `OutrightLeagueFixture`
  - `OutrightLeagueFixtureSnapshot`

- Added new livescore status description values `46-59`.

- Added participant uniform color support with object-based shirt color fields (`shirtColor`, `goalKeeperShirtColor`) using `primary`, `number`, and `outline`.

### Changed

- Bumped project/module versions from `2.9.1` to `2.9.2` for a new publishable release.

## [Release Version 2.9.1] - 2026-02-01

### Fixed

- **OutrightMarketElement missing ProviderMarkets** (TR-22187)
  - Added `providerMarkets` field to `OutrightMarketElement` class
  - The `GetOutrightLeagueMarkets` API response now correctly includes provider markets data
  - This field was present in the API response but missing from the SDK entity model

## [Release Version 2.9.0] - 2026-01-28

### Changed

- **BREAKING CHANGE**: Migrated all timestamp fields from `LocalDateTime` to `Instant`
  - All date/time fields in entity models now use `java.time.Instant` instead of `java.time.LocalDateTime`
  - This ensures correct timezone handling - all timestamps are now unambiguous points in time
  - Affected entities include: `Fixture`, `BaseBet`, `MessageHeader`, `CurrentIncident`, `DangerIndicator`, `Incident`, `FixturePlayerInfo`, `ProviderMarket`, `Provider`, `OutrightFixture`, `OutrightLeagueFixture`, `Suspension`, `FixtureSchedule`, `PackageQuotaResponse`, `FixtureMetadata`, `SuspensionChangeResponse`, and all Snapshot API request classes

- **New Custom Instant Serialization**
  - Added `LSportsInstantSerializer` - serializes `Instant` to epoch milliseconds for API compatibility
  - Added `LSportsInstantDeserializer` - deserializes JSON to `Instant` supporting:
    - ISO-8601 with timezone (e.g., `"2025-06-15T18:30:00Z"`, `"2025-06-15T18:30:00+02:00"`)
    - ISO-8601 without timezone (e.g., `"2025-06-15T18:30:00"`) - treated as UTC
    - Epoch milliseconds as string (e.g., `"1750009800000"`)
  - Removed `LSportsLocalDateTimeSerializer` (no longer needed)

- **Java 24 Compatibility**
  - Fixed Mockito/ByteBuddy compatibility issues with Java 24
  - Upgraded Mockito to 5.14.2 and ByteBuddy to 1.15.11
  - Configured subclass mock maker for Java 21+ environments
  - Refactored tests to avoid mocking final classes (Java records)

### Migration Guide

#### Updating Code Using Timestamp Fields

If you access timestamp fields from SDK entities, update your code to use `Instant`:

```java
// Before
LocalDateTime startDate = fixture.startDate();
LocalDateTime lastUpdate = fixture.lastUpdate();

// After
Instant startDate = fixture.startDate();
Instant lastUpdate = fixture.lastUpdate();
```

#### Creating Request Objects with Timestamps

```java
// Before
new GetSnapshotRequest(LocalDateTime.now(), fromDate, toDate, ...);

// After
new GetSnapshotRequest(Instant.now(), fromDate, toDate, ...);
```

#### Converting Between Types (if needed)

```java
// Instant to LocalDateTime (for display in specific timezone)
LocalDateTime local = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

// LocalDateTime to Instant (assuming UTC)
Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
```

### Benefits of This Change

- **Timezone Safety**: `Instant` represents an unambiguous point in time, eliminating timezone-related bugs
- **API Consistency**: Source timestamps with timezone info (e.g., `"2025-06-15T18:30:00+02:00"`) are now correctly parsed
- **UTC by Default**: Timestamps without timezone info are treated as UTC, matching API behavior

## [Release Version 2.8.1] - 2026-01-25

### Added

- **Enhanced Outright Fixture Entities**
  - `OutrightFixture` - Enhanced with:
    - `fixtureName` property for the name of the fixture
    - `season` property of type `IdNamePair` for season information
  - `OutrightLeagueFixture` - Enhanced with:
    - `fixtureName` property for the name of the fixture
    - `season` property of type `IdNamePair` for season information
  - `OutrightParticipant` - Enhanced with:
    - `form` property for recent form (e.g., "WWDLW")
    - `formation` property for formation (e.g., "4-3-3")
    - `fixturePlayers` property of type `Iterable<FixturePlayer>` for player information
    - `gender` property for gender category
    - `ageCategory` property for age category
    - `type` property for participant type

- **Enhanced Outright Snapshot Response Entities**
  - `OutrightFixtureElement` - Enhanced with:
    - `fixtureName` property for the name of the fixture
    - `season` property of type `IdNamePair` for season information
  - `OutrightLeagueFixtureSnapshot` - Enhanced with:
    - `fixtureName` property for the name of the fixture
    - `season` property of type `IdNamePair` for season information

### Backward Compatibility

All changes are backward compatible. Existing code will continue to work without modification. The new properties are optional additions to existing entities.

## [Release Version 2.7.0] - 2025-12-25

### Added

- **Seasons Metadata API**
  - `getSeasons()` - New endpoint to fetch season information with optional filtering
  - `GetSeasonsRequest` - Request DTO with optional `seasonId` parameter
  - `GetSeasonsResponse` - Response structure containing collection of seasons
  - `SeasonMetadata` - Response structure for season data including `seasonId` and `seasonName`

- **Tours Metadata API**
  - `getTours()` - New endpoint to fetch tour information with optional filtering
  - `GetToursRequest` - Request DTO with optional `tourId` and `sportId` parameters
  - `GetToursResponse` - Response structure containing collection of tours
  - `TourMetadata` - Response structure for tour data including `tourId`, `tourName`, `sportId`, and `sportName`

- **Enhanced Sample Projects**
  - **customer-api-sample**: Added menu options and examples for seasons and tours metadata APIs

### Changed

- Extended `MetadataApiClient` interface with seasons and tours functionality
- Updated `MetadataApiClientImplementation` to support new seasons and tours endpoints

### Backward Compatibility

All changes are backward compatible. Existing code will continue to work without modification. The new seasons and tours endpoints are additions to the existing metadata API.

## [Release Version 2.6.2] - 2025-12-21

### Fixed

- **Performance Optimization in AmqpMessageHandler** (TR-21255)
  - **Issue**: RabbitMQ message processing throughput was limited to ~2,700 msg/s (vs ~5,000 msg/s without SDK) due to redundant JSON parsing
  - **Root Cause**: `AmqpMessageHandler.process()` was calling `ObjectMapper.readValue()` three times per message:
    - Once in `getTypeIdFromMessage()`
    - Once in `getBodyFromMessage()`
    - Once in `getHeaderFromMessage()`
  - Additionally, each call was creating a new `ObjectMapper` instance instead of reusing the class-level singleton
  - **Solution**:
    - Refactored to parse message body only once using new `parseMessageOnce()` method
    - Created new internal methods that accept pre-parsed `Map<String, Object>`:
      - `getTypeIdFromParsedMessage()`
      - `getBodyFromParsedMessage()`
      - `getHeaderFromParsedMessage()`
    - All methods now reuse the class-level `ObjectMapper` instance
  - **Impact**:
    - ~66% reduction in JSON parsing overhead per message
    - Significant throughput improvement for single-threaded RabbitMQ consumers
    - Reduced CPU usage and GC pressure in high-throughput scenarios
  - **Customer**: SportBet (via 10Bet) - reported production concerns with high-rate Prematch queue processing

### Changed

- Updated `AmqpMessageHandlerTest` to reflect new internal method signatures
- Tests now validate the optimized parsing behavior

### Backward Compatibility

Fully backward compatible. Public API (`process(Message)`) remains unchanged. Only internal implementation optimized.

## [Release Version 2.5.1]

### Added

- Added `startDate` to outright league fixture models:
  - `OutrightLeagueFixture`
  - `OutrightLeagueFixtureSnapshot`

- Added new livescore status description values `46-59`.

- Added participant uniform color support with object-based shirt color fields (`shirtColor`, `goalKeeperShirtColor`) using `primary`, `number`, and `outline`.

### Backward Compatibility

All changes are backward compatible. New fields are additive and existing integer-based parsing behavior is preserved.

## [Release Version 2.4.0]

### Added

- **Participants Metadata API**
  - `getParticipants()` - New endpoint to fetch participant information with filtering and pagination capabilities
  - `GetParticipantsRequest` - Request DTO with pagination parameters (page, pageSize) and ParticipantsFilter for comprehensive filtering
  - `ParticipantsFilter` - Request filter supporting:
    - Participant IDs filtering
    - Sport IDs filtering
    - Location IDs filtering
    - Partial name matching
    - Gender filtering
    - Age category filtering
    - Participant type filtering
  - `GetParticipantsResponse` - Response structure containing:
    - `data` - Collection of participant metadata
    - `totalItems` - Total count of items across all pages for pagination support
  - `ParticipantMetadata` - Response structure for participant data including ID, sport ID, location ID, name, and optional gender, age category, and type

- **New Participant-Related Enums**
  - `Gender` - Enum for gender categories (Men=1, Women=2, Mix=3)
  - `AgeCategory` - Enum for age categories (Regular=0, Youth=1, Reserves=2)
  - `ParticipantType` - Enum for participant types (Club=1, National=2, Individual=3, Virtual=4, Esports=5, VirtuReal=6, Doubles=7)

- **Enhanced Sample Projects**
  - **customer-api-sample**: Added menu option and example for participants metadata API with filtering and pagination

### Changed

- Extended `MetadataApiClient` interface with participants functionality
- Updated `MetadataApiClientImplementation` to support new participants endpoint

### Backward Compatibility

All changes are backward compatible. Existing code will continue to work without modification. The new participants endpoint is an addition to the existing metadata API.

## [Release Version 2.3.0]

### Added

- **Venue, City, and State Metadata APIs**
  - `getVenues()` - New endpoint to fetch venue information with filtering capabilities
  - `getCities()` - New endpoint to fetch city information with filtering capabilities  
  - `getStates()` - New endpoint to fetch state information with filtering capabilities
  - `GetVenuesRequest` / `VenuesFilter` - Request DTOs for venue filtering by venue IDs, country IDs, state IDs, and city IDs
  - `GetCitiesRequest` / `CitiesFilter` - Request DTOs for city filtering by country IDs and state IDs
  - `GetStatesRequest` / `CountriesFilter` - Request DTOs for state filtering by country IDs
  - `VenueMetadata` - Response structure for venue data including country, state, and city information
  - `CityMetadata` - Response structure for city data including country and state information
  - `StateMetadata` - Response structure for state data including country information
  - `GetVenuesResponse` / `GetCitiesResponse` / `GetStatesResponse` - Collection response wrappers

- **Enhanced Fixture Entities**
  - **`FixtureVenue`** - New comprehensive venue entity with:
    - Basic venue information (ID, name, capacity, attendance)
    - Court surface type, environment (indoor/outdoor), and assignment (home/away/neutral)
    - Geographic information (country, state, city)
  - **`Fixture`** - Enhanced with:
    - `venue` property of type `FixtureVenue`
    - `stage` property of type `IdNamePair` for tournament stage information
    - `round` property of type `IdNamePair` for tournament round information
  - **`OutrightFixture`** - Enhanced with:
    - `venue` property of type `FixtureVenue`
  - **`OutrightFixtureElement`** - Enhanced with:
    - `venue` property of type `FixtureVenue`

- **New Venue-Related Enums**
  - `CourtSurface` - Enum for court surface types (Grass, Hard, Clay, ArtificialGrass)
  - `VenueAssignment` - Enum for venue assignment (Home, Away, Neutral)
  - `VenueEnvironment` - Enum for venue environment (Indoors, Outdoors)

- **Enhanced Sample Projects**
  - **customer-api-sample**: Added menu options and examples for venues, cities, and states metadata APIs
  - **feed-sample**: Updated to demonstrate enhanced fixture entities with venue information

### Changed

- Extended `MetadataApiClient` interface with venues, cities, and states functionality
- Updated `MetadataApiClientImplementation` to support new metadata endpoints
- Enhanced Spring Boot REST client configuration for new metadata endpoints

### Backward Compatibility

All changes are backward compatible. Existing code will continue to work without modification. The new venue, stage, and round properties are optional additions to existing entities.

## [Release Version 2.2.0]

### Added

- **Enhanced Livescore Functionality**
  - `IncidentConfirmation` - New enum for incident confirmation status with values for confirmed/unconfirmed incidents
  - Enhanced `CurrentIncident` entity with additional incident confirmation capabilities

- **Enhanced Outright League Features**
  - Enhanced `OutrightLeagueFixture` entity with additional fixture properties
  - Improved `OutrightLeagueFixtureSnapshot` response structure

### Changed

- Updated livescore processing to support incident confirmation workflows
- Enhanced outright league fixture handling with additional metadata

## [Release Version 2.1.0]

### Added

- **New Outright League Support** - Added comprehensive support for outright league functionality:
  - `OutrightLeagueEvent` - New entity class for outright league events with fixture ID, outright league fixture, and markets
  - `OutrightLeagueSettlementUpdate` - New message type (entity key 43) for outright league settlement updates
  - `GetOutrightLeagueEventsRequest` - New snapshot API request for retrieving outright league events with filtering by timestamp, date range, sports, locations, leagues, fixtures, and markets
  - `GetOutrightLeagueEventsResultElement` - New response wrapper for outright league events results
  - `OutrightLeagueCompetitionsWrapper` - New response wrapper for outright league competitions
- **New Snapshot API Method** - `getOutrightLeagueEvents()` method added to `PreMatchSnapshotApiClient` interface for retrieving outright league event snapshots
- Enhanced outright league market and settlement processing capabilities

### Changed

- Extended `PreMatchSnapshotApiClient` interface with outright league events functionality
- Updated `PreMatchSnapshotApiClientImplementation` to support outright league events retrieval
- Enhanced Spring Boot REST client configuration for outright league endpoints

## [Release Version 2.0.0]

### Added

- **New `TransportMessageHeaders` class** - Extracts and provides access to RabbitMQ message headers including:
  - `MessageGuid` - Unique identifier for the message
  - `MessageType` - Type of the message being processed  
  - `TimestampInMs` - Message timestamp in milliseconds
  - `MessageSequence` - Sequence number for message ordering (optional)
  - `FixtureId` - Associated fixture identifier (optional)
- Factory method `createFromProperties()` for creating `TransportMessageHeaders` from RabbitMQ message properties
- Comprehensive validation for required message header properties
- Support for both string and object header values with automatic conversion
- `getAsMap()` method in `TransportMessageHeaders` to return headers as a map containing only non-null and non-empty values

### Changed

- **BREAKING CHANGE**: `EntityHandler<T>.process()` method signature
  - **Before**: `void process(T entity, Map<String, String> messageHeaders)`
  - **After**: `void process(T entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders)`
- Updated `AmqpMessageHandler` to extract RabbitMQ message headers and pass them through the processing pipeline
- Enhanced message processing to preserve transport-level metadata from RabbitMQ
- All sample entity handlers updated to accommodate the new method signature

### Fixed

- Improved message processing pipeline to include transport-level headers for enhanced observability
- Better error handling for missing or invalid transport headers

### Migration Guide

#### For Custom Entity Handlers

If you have implemented custom `EntityHandler<T>` classes, you need to update the `process` method signature:

```java
// Before
public class MyHandler implements EntityHandler<MyEntity> {
    @Override
    public void process(MyEntity entity, Map<String, String> messageHeaders) {
        // Your processing logic
    }
    
    @Override
    public int getEntityKey() {
        return MyEntity.entityKey;
    }
}

// After  
public class MyHandler implements EntityHandler<MyEntity> {
    @Override
    public void process(MyEntity entity, Map<String, String> messageHeaders, Map<String, String> transportMessageHeaders) {
        // Access transport headers
        if (transportMessageHeaders != null) {
            String messageGuid = transportMessageHeaders.get("MessageGuid");
            String timestamp = transportMessageHeaders.get("timestamp_in_ms");
            String messageType = transportMessageHeaders.get("MessageType");
            String messageSequence = transportMessageHeaders.get("MessageSequence");
            String fixtureId = transportMessageHeaders.get("FixtureId");
            // Use transport metadata as needed
        }

        // Your existing processing logic
    }
    
    @Override
    public int getEntityKey() {
        return MyEntity.entityKey;
    }
}
```

#### Working with TransportMessageHeaders

The new `TransportMessageHeaders` class provides structured access to transport-level metadata:

```java
// Creating from RabbitMQ message properties
Map<String, Object> properties = amqpMessage.getMessageProperties().getHeaders();
TransportMessageHeaders transportHeaders = TransportMessageHeaders.createFromProperties(properties);

// Accessing individual properties
String messageGuid = transportHeaders.getMessageGuid();
String messageType = transportHeaders.getMessageType();
String timestampInMs = transportHeaders.getTimestampInMs();
String messageSequence = transportHeaders.getMessageSequence(); // May be null
String fixtureId = transportHeaders.getFixtureId(); // May be null

// Converting to map for compatibility
Map<String, String> headersMap = transportHeaders.getAsMap();
```

#### Benefits of This Change

- **Enhanced Observability**: Access to message-level metadata for logging, debugging, and monitoring
- **Message Ordering**: Support for message sequence tracking via `MessageSequence`
- **Correlation**: Message GUID for end-to-end request correlation
- **Temporal Analysis**: Precise message timestamps for performance analysis
- **Fixture Context**: Direct access to fixture IDs where applicable
- **Type Safety**: Structured access to transport headers instead of raw map lookups

[Release Version 2.9.1]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.9.1
[Release Version 2.9.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.9.0
[Release Version 2.8.1]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.8.1
[Release Version 2.7.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.7.0
[Release Version 2.6.2]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.6.2
[Release Version 2.4.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.4.0
[Release Version 2.3.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.3.0
[Release Version 2.2.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.2.0
[Release Version 2.1.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.1.0
[Release Version 2.0.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.0.0
