# System Patterns: Trade360 Java SDK

## System Architecture

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    Client Application                        │
│  (Spring Boot app with custom business logic)              │
└─────────────────┬───────────────────────────────────────────┘
                  │
                  │ Uses SDK
                  ▼
┌─────────────────────────────────────────────────────────────┐
│                  Trade360 Java SDK                           │
│  ┌─────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │ Feed Module │  │ Snapshot API │  │ Customers API│      │
│  │  (RabbitMQ) │  │   (HTTP)     │  │    (HTTP)    │      │
│  └──────┬──────┘  └──────┬───────┘  └──────┬───────┘      │
│         │                 │                  │               │
│  ┌──────▼─────────────────▼──────────────────▼──────┐      │
│  │         Common Infrastructure Layer              │      │
│  │  (Entities, Serialization, Config, Exceptions)   │      │
│  └──────────────────────────────────────────────────┘      │
└─────────────────┬───────────────────────────────────────────┘
                  │
                  │ Connects to
                  ▼
┌─────────────────────────────────────────────────────────────┐
│                External Trade360 Services                    │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │   RabbitMQ   │  │  Snapshot    │  │  Customers   │      │
│  │    Broker    │  │     API      │  │     API      │      │
│  └──────────────┘  └──────────────┘  └──────────────┘      │
└─────────────────────────────────────────────────────────────┘
```

## Key Technical Decisions

### Decision 1: Reactive Programming Model
**Context**: HTTP operations can block threads and limit throughput

**Decision**: Use Project Reactor and `Mono<T>` for all HTTP operations

**Rationale**:
- Non-blocking I/O enables high concurrency
- Natural fit with Spring WebFlux
- Industry standard for async Java operations
- Excellent error propagation and composition

**Trade-offs**:
- ✅ Better resource utilization
- ✅ Higher throughput for I/O-bound operations
- ❌ Steeper learning curve for developers unfamiliar with reactive
- ❌ More complex debugging

**Impact**: All Snapshot API and Customers API clients return `Mono<T>`

### Decision 2: Factory Pattern for Client Creation
**Context**: Need flexible client instantiation supporting multiple frameworks

**Decision**: Use factory interfaces with framework-specific implementations

**Rationale**:
- Decouples client creation from usage
- Allows Spring Boot, Quarkus, or plain Java implementations
- Enables easy testing with mock factories
- Follows SOLID principles (Dependency Inversion)

**Implementations**:
- `SpringBootSnapshotApiClientFactory` - Uses Spring `WebClient`
- `SpringBootCustomersApiClientFactory` - Uses Spring `WebClient`
- Future: `QuarkusSnapshotApiClientFactory` (potential)

**Trade-offs**:
- ✅ Framework flexibility
- ✅ Testability
- ❌ Slightly more boilerplate
- ❌ Requires factory bean registration

### Decision 3: Handler Registry Pattern
**Context**: RabbitMQ messages have different types requiring different processing

**Decision**: Use `EntityRegistry` to map message type IDs to handlers

**Rationale**:
- Single responsibility: Each handler processes one message type
- Open/closed principle: Add new handlers without modifying core
- Type safety: Handler signature enforces correct entity type
- Flexibility: Users define their own handlers

**Implementation**:
```java
public interface EntityHandler<T> {
    void process(T entity, Map<String, String> header, Map<String, String> transportHeaders);
}

public class EntityRegistry {
    private Map<Integer, EntityHandler<?>> handlers = new ConcurrentHashMap<>();
    
    public void setEntityHandler(EntityHandler<?> handler) {
        // Register by message type ID
    }
    
    public EntityHandler<?> getEntityHandler(int typeId) {
        // Lookup handler
    }
}
```

**Trade-offs**:
- ✅ Clean separation of concerns
- ✅ Easy to test handlers independently
- ✅ Users control business logic
- ❌ Requires handler registration boilerplate

### Decision 4: Configuration-Driven Design
**Context**: Applications need to run in multiple environments (dev, QA, prod)

**Decision**: Externalize all configuration to `application.properties`

**Rationale**:
- 12-factor app principles
- No code changes for environment differences
- Spring Boot property binding
- Environment variable overrides

**Configuration Structure**:
- `rabbitmq.{env}.{property}` - RabbitMQ connection settings
- `snapshotapi.{env}.{property}` - Snapshot API settings
- `customersapi.{env}.{property}` - Customers API settings

**Trade-offs**:
- ✅ Environment flexibility
- ✅ No hardcoded secrets
- ✅ Spring Boot native support
- ❌ Verbose configuration files
- ❌ Property naming must be consistent

### Decision 5: Strong Typing with Enums
**Context**: API uses numeric codes for statuses, message types, etc.

**Decision**: Use Java enums with integer values for all coded fields

**Rationale**:
- Compile-time safety prevents invalid values
- IDE autocomplete and refactoring support
- Self-documenting code
- Easy to extend with helper methods

**Implementation**:
```java
public enum MessageType {
    FixtureMetadataUpdate(1, FixtureMetadataUpdate.class),
    LivescoreUpdate(2, LivescoreUpdate.class),
    MarketUpdate(3, MarketUpdate.class);
    
    private final int value;
    private final Class<?> clazz;
    
    public static MessageType findMessageType(int typeId) {
        // Lookup by ID
    }
}
```

**Trade-offs**:
- ✅ Type safety
- ✅ Refactoring support
- ✅ Clear API contracts
- ❌ Requires updates when LSports adds new codes
- ❌ Cannot handle unknown values gracefully (need fallback logic)

## Design Patterns in Use

### 1. Factory Pattern
**Usage**: `SnapshotApiClientFactory`, `CustomersApiClientFactory`

**Purpose**: Abstract client creation, support multiple implementations

**Example**:
```java
public interface SnapshotApiClientFactory {
    InPlaySnapshotApiClient createInPlaySnapshotHttpClient(URI baseUrl, PackageCredentials credentials);
    PreMatchSnapshotApiClient createPreMatchSnapshotHttpClient(URI baseUrl, PackageCredentials credentials);
}
```

### 2. Template Method Pattern
**Usage**: `ApiRestClient` interface with `SpringBootApiRestClient` implementation

**Purpose**: Define HTTP operation structure, allow custom implementations

**Example**:
```java
public interface ApiRestClient {
    <Req, Res> Mono<BaseResponse<Res>> postRequest(Req body, TypeReference<BaseResponse<Res>> type, String url);
    <Req, Res> Mono<BaseResponse<Res>> getRequest(Req query, TypeReference<BaseResponse<Res>> type, String url);
}
```

### 3. Registry Pattern
**Usage**: `EntityRegistry` for message handler lookup

**Purpose**: Dynamically route messages to appropriate handlers

### 4. Builder Pattern
**Usage**: Spring `WebClient.Builder` for HTTP client construction

**Purpose**: Fluent configuration of complex HTTP clients

### 5. Strategy Pattern
**Usage**: `MessageRecoverer` and `RabbitListenerErrorHandler` interfaces

**Purpose**: Pluggable error handling strategies

**Example**:
```java
public interface MessageRecoverer {
    void recover(Message message, Throwable cause);
}

// User provides custom strategy
public class CustomRecoveryStrategy implements MessageRecoverer {
    @Override
    public void recover(Message message, Throwable cause) {
        // Custom error handling
    }
}
```

### 6. Dependency Injection Pattern
**Usage**: Throughout, via Spring Framework

**Purpose**: Loose coupling, testability, configuration flexibility

**Example**:
```java
@Bean
public SnapshotApiClientFactory snapshotFactory(WebClient.Builder builder) {
    return new SpringBootSnapshotApiClientFactory(builder);
}
```

## Component Relationships

### Feed Module Architecture

```
┌─────────────────────────────────────────────────────┐
│              @RabbitListener Method                 │
│              (User-defined in app)                  │
└────────────────────┬────────────────────────────────┘
                     │ Receives AMQP Message
                     ▼
┌─────────────────────────────────────────────────────┐
│             AmqpMessageHandler                       │
│  1. Extract type ID from message header            │
│  2. Lookup MessageType enum                        │
│  3. Deserialize JSON body to entity class          │
│  4. Extract message headers                        │
└────────────────────┬────────────────────────────────┘
                     │ Lookup handler
                     ▼
┌─────────────────────────────────────────────────────┐
│              EntityRegistry                          │
│  Map<TypeId, EntityHandler>                        │
└────────────────────┬────────────────────────────────┘
                     │ Return handler
                     ▼
┌─────────────────────────────────────────────────────┐
│           EntityHandler<T>                          │
│           (User implementation)                     │
│  process(entity, header, transportHeaders)         │
└─────────────────────────────────────────────────────┘
```

### HTTP API Client Architecture

```
┌─────────────────────────────────────────────────────┐
│         Client Application                          │
│  var response = snapshotClient.getFixtures(req)    │
└────────────────────┬────────────────────────────────┘
                     │ Call API method
                     ▼
┌─────────────────────────────────────────────────────┐
│      InPlaySnapshotApiClientImplementation          │
│  1. Build request URL                              │
│  2. Set request body/query params                  │
│  3. Call ApiRestClient                             │
└────────────────────┬────────────────────────────────┘
                     │ Delegate HTTP call
                     ▼
┌─────────────────────────────────────────────────────┐
│        SpringBootApiRestClient                       │
│  1. Add authentication headers                      │
│  2. Set content type                               │
│  3. Configure WebClient                            │
│  4. Make HTTP request                              │
│  5. Extract errors on failure                      │
│  6. Deserialize response on success                │
└────────────────────┬────────────────────────────────┘
                     │ HTTP call
                     ▼
┌─────────────────────────────────────────────────────┐
│         Spring WebClient (Reactive)                  │
│  Non-blocking HTTP with Netty                      │
└────────────────────┬────────────────────────────────┘
                     │ Network I/O
                     ▼
┌─────────────────────────────────────────────────────┐
│            Trade360 HTTP API                         │
│  (Snapshot or Customers API)                       │
└─────────────────────────────────────────────────────┘
```

### Configuration Loading Flow

```
┌─────────────────────────────────────────────────────┐
│         application.properties                       │
│  rabbitmq.inplay.host=...                          │
│  snapshotapi.base_snapshot_api=...                 │
└────────────────────┬────────────────────────────────┘
                     │ Spring Boot reads
                     ▼
┌─────────────────────────────────────────────────────┐
│     @ConfigurationProperties Binding                 │
│  RabbitConnectionConfiguration                      │
│  Trade360Settings                                   │
└────────────────────┬────────────────────────────────┘
                     │ Injects into
                     ▼
┌─────────────────────────────────────────────────────┐
│   DynamicRabbitMQDefinitionRegistrar                 │
│  Creates RabbitMQ connection factory beans          │
└─────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────┐
│       Factory Beans (User-defined)                   │
│  @Bean SnapshotApiClientFactory                     │
│  @Bean CustomersApiClientFactory                    │
└────────────────────┬────────────────────────────────┘
                     │ Create clients
                     ▼
┌─────────────────────────────────────────────────────┐
│         API Client Instances                         │
│  InPlaySnapshotApiClient                            │
│  PreMatchSnapshotApiClient                          │
│  PackageDistributionApiClient                       │
│  MetadataApiClient                                  │
│  SubscriptionApiClient                              │
└─────────────────────────────────────────────────────┘
```

## Architectural Principles

### 1. Separation of Concerns
- **Feed Module**: Only RabbitMQ concerns
- **API Modules**: Only HTTP client concerns
- **Common Module**: Shared utilities, no business logic
- **Samples**: User-facing code, no SDK internals

### 2. Dependency Inversion
- High-level modules depend on abstractions (interfaces)
- Low-level modules implement interfaces
- Example: `SnapshotApiClient` interface → `InPlaySnapshotApiClientImplementation`

### 3. Open/Closed Principle
- Open for extension: Users create new `EntityHandler` implementations
- Closed for modification: Core SDK classes don't need changes

### 4. Single Responsibility
- Each class has one reason to change
- `AmqpMessageHandler` only handles message routing
- `ApiRestClient` only handles HTTP operations
- `EntityRegistry` only handles handler registration

### 5. Interface Segregation
- Small, focused interfaces
- `PackageDistributionApiClient` only has distribution methods
- `SubscriptionApiClient` only has subscription methods
- Users don't depend on methods they don't use

## Error Handling Architecture

### Exception Hierarchy
```
Throwable
└── Exception
    └── RuntimeException
        └── Trade360Exception
            ├── message: String
            └── errors: List<Error>
```

### Error Flow
```
HTTP Error Response (4xx/5xx)
         │
         ▼
LSportsHeaderErrorsExtractor or ProblemJsonErrorsExtractor
         │ Extracts error details
         ▼
Trade360Exception
         │ Propagated via Mono.error()
         ▼
User's error handler
(.doOnError() or .subscribe())
```

## Resilience Patterns

### 1. Retry with Exponential Backoff
```
Attempt 1 → Fail → Wait 1s
Attempt 2 → Fail → Wait 2s
Attempt 3 → Fail → Wait 4s
Attempt 4 → Fail → Call MessageRecoverer
```

### 2. Circuit Breaker (via Spring Retry)
- Configurable via `retry_attempts` and intervals
- Prevents cascading failures

### 3. Connection Pooling
- Spring AMQP manages connection pools
- WebClient manages HTTP connection pools

### 4. Graceful Degradation
- Feed errors don't crash application
- Error handlers allow custom recovery logic

## Testing Architecture

### Test Organization
```
src/test/java/eu/lsports/trade360_java_sdk/
├── common/
│   ├── configuration/     # Config bean tests
│   ├── http/              # HTTP client tests
│   ├── serialization/     # Jackson serializer tests
│   └── springframework/   # Spring integration tests
├── customers_api/         # Customers API client tests
├── snapshot_api/          # Snapshot API client tests
└── feed/                  # RabbitMQ handler tests
```

### Testing Strategies
- **Unit Tests**: Mock dependencies, test single classes
- **Integration Tests**: Use `MockWebServer` for HTTP, embedded RabbitMQ
- **Serialization Tests**: Verify JSON → Java object mapping
- **Configuration Tests**: Verify property binding

**Last Updated**: November 2025  
**Owner**: LSports Development Team

