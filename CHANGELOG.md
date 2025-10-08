# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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

[Release Version 2.3.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.3.0
[Release Version 2.2.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.2.0
[Release Version 2.1.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.1.0
[Release Version 2.0.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.0.0
