# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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

[Release Version 2.0.0]: https://github.com/lsportsltd/trade360-java-sdk/releases/tag/trade360-java-sdk-2.0.0
