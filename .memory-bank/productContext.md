# Product Context: Trade360 Java SDK

## Why This Project Exists

### Business Context
LSports provides real-time sports data and trading solutions to customers worldwide. Customers need to integrate Trade360 services into their Java-based applications, but direct integration is complex:
- Raw RabbitMQ requires manual connection management, error handling, and message parsing
- HTTP APIs need authentication, retry logic, and response handling
- Entity models must be manually created and maintained

### Problem Statement
Before this SDK existed, customers faced:
1. **High Integration Complexity**: 2-3 weeks to implement basic RabbitMQ feed
2. **Inconsistent Implementations**: Each customer recreated the same boilerplate
3. **Error-Prone Code**: Manual JSON parsing, type casting, error handling
4. **Maintenance Burden**: API changes required updates across all customer codebases
5. **Poor Developer Experience**: Steep learning curve, limited examples

### Solution
The Trade360 Java SDK solves these problems by:
- **Abstracting Complexity**: Hide RabbitMQ, HTTP, and serialization details
- **Providing Ready-Made Components**: Pre-built clients, handlers, entity models
- **Ensuring Type Safety**: Compile-time checks prevent runtime errors
- **Offering Best Practices**: Built-in retry, error handling, connection resilience
- **Reducing Time-to-Market**: Integration time reduced from weeks to days

## Problems It Solves

### 1. Connection Management
**Problem**: RabbitMQ connections are fragile and require careful configuration  
**Solution**: 
- `RabbitConnectionConfiguration` with sensible defaults
- Automatic network recovery
- Exponential backoff retries
- Health monitoring and reconnection

### 2. Message Routing
**Problem**: Messages arrive as generic JSON; manual routing is error-prone  
**Solution**:
- `AmqpMessageHandler` automatically deserializes based on type ID
- `EntityRegistry` maps message types to user handlers
- Type-safe entity classes for all message types

### 3. Authentication & HTTP Clients
**Problem**: Every API call requires auth headers, error extraction, retry logic  
**Solution**:
- `ApiRestClient` abstraction handles authentication automatically
- Built-in error extractors (LSports header format, ProblemJSON)
- Reactive `Mono<T>` responses with automatic error propagation

### 4. Entity Models
**Problem**: Manually creating and maintaining hundreds of Java classes for API entities  
**Solution**:
- Complete entity model library (fixtures, markets, livescore, enums)
- Jackson annotations for correct serialization/deserialization
- Strongly typed enums for status codes and message types

### 5. Spring Boot Integration
**Problem**: Wiring everything together requires deep Spring knowledge  
**Solution**:
- Factory beans for client creation
- Configuration property binding
- Dependency injection support
- Auto-configuration patterns

## How It Should Work

### User Experience Goals

#### 1. Minimal Configuration
**Goal**: Get started with < 20 lines of configuration

```properties
# RabbitMQ Feed
rabbitmq.inplay.package_id=12345
rabbitmq.inplay.host=rabbitmq.lsports.eu
rabbitmq.inplay.user_name=myuser
rabbitmq.inplay.password=mypassword

# Snapshot API
snapshotapi.base_snapshot_api=https://stm-snapshot.lsports.eu
snapshotapi.inplay.package_id=12345
snapshotapi.inplay.user_name=myuser
snapshotapi.inplay.password=mypassword
```

#### 2. Intuitive API Design
**Goal**: Self-documenting code that follows Java conventions

```java
// Create Snapshot API client
SnapshotApiClient client = factory.createInPlaySnapshotHttpClient(baseUrl, credentials);

// Make async request
Mono<BaseResponse<Fixture>> response = client.getFixtures(request);

// Handle result reactively
response.subscribe(
    data -> process(data),
    error -> handleError(error)
);
```

#### 3. Type Safety First
**Goal**: Catch errors at compile time, not runtime

```java
// Strongly typed handler
public class MarketUpdateHandler implements EntityHandler<MarketUpdate> {
    @Override
    public void process(MarketUpdate entity, Map<String, String> header, Map<String, String> transportHeaders) {
        // IDE autocomplete for entity.events
        entity.events.forEach(event -> {
            // Compile-time type checking
            int fixtureId = event.fixtureId;
            BetStatus status = event.status; // Enum, not String
        });
    }
}
```

#### 4. Resilience by Default
**Goal**: Application stays running even during network issues

- Automatic retry with exponential backoff
- Connection recovery after broker restarts
- Configurable error handlers for custom logic
- Detailed error context in exceptions

#### 5. Observable Operations
**Goal**: Full visibility into what's happening

- Structured logging at key decision points
- Support for Spring Boot Actuator metrics
- Health check endpoints
- Debug-level logging for troubleshooting

### Expected Usage Patterns

#### Pattern 1: RabbitMQ Feed Consumer
```java
@Configuration
public class FeedConfiguration {
    @Bean
    public EntityRegistry entityRegistry() {
        EntityRegistry registry = new EntityRegistry();
        registry.setEntityHandler(new MarketUpdateHandler());
        registry.setEntityHandler(new LivescoreUpdateHandler());
        return registry;
    }
}

@RabbitListener(containerFactory = "${rabbitmq.inplay.rabbit_listener_container_factory_name}", 
                queues = "_${rabbitmq.inplay.package_id}_")
public void handleMessage(Message message) {
    messageHandler.process(message); // SDK handles the rest
}
```

#### Pattern 2: Snapshot API for Recovery
```java
@Service
public class RecoveryService {
    private final InPlaySnapshotApiClient snapshotClient;
    
    public void recoverFixtures() {
        GetFixtureRequest request = new GetFixtureRequest();
        request.fixtureId = 12345;
        
        snapshotClient.getFixtures(request)
            .subscribe(
                response -> saveToDatabase(response.body),
                error -> logError(error)
            );
    }
}
```

#### Pattern 3: Subscription Management
```java
@Service
public class SubscriptionService {
    private final SubscriptionApiClient subscriptionClient;
    
    public void subscribeToFixture(int fixtureId) {
        FixtureSubscriptionRequest request = new FixtureSubscriptionRequest();
        request.fixtureIds = List.of(fixtureId);
        
        subscriptionClient.subscribeByFixture(request)
            .doOnSuccess(response -> log.info("Subscribed to fixture {}", fixtureId))
            .doOnError(error -> log.error("Subscription failed", error))
            .subscribe();
    }
}
```

## User Journey

### Phase 1: Discovery (5 minutes)
1. Developer reads README and understands SDK capabilities
2. Views architecture diagrams and code examples
3. Decides which integration pattern to use (feed, snapshot, or customers)

### Phase 2: Setup (15 minutes)
1. Adds Maven dependency to `pom.xml`
2. Copies configuration template to `application.properties`
3. Fills in credentials (package ID, username, password, RabbitMQ host)

### Phase 3: Implementation (1-2 hours)
1. Creates handler classes implementing `EntityHandler<T>`
2. Registers handlers in Spring configuration
3. Sets up `@RabbitListener` methods (if using feed)
4. Tests with sample data

### Phase 4: Testing & Validation (2-4 hours)
1. Verifies messages are received and processed
2. Tests error scenarios (invalid credentials, network issues)
3. Monitors logs and metrics
4. Validates data consistency

### Phase 5: Production (Ongoing)
1. Monitors health checks and metrics
2. Handles errors via configured error handlers
3. Updates SDK version as needed
4. Reports issues or requests features

## Success Indicators

### For Developers
- ✅ "I integrated Trade360 in less than a day"
- ✅ "The SDK handles all the complex stuff for me"
- ✅ "Type safety caught bugs before production"
- ✅ "Spring Boot integration was seamless"
- ✅ "Documentation and examples were sufficient"

### For LSports
- ✅ Reduced customer support requests for integration issues
- ✅ Faster customer onboarding (days vs weeks)
- ✅ Fewer integration-related bugs reported
- ✅ Positive feedback and adoption metrics
- ✅ Active community contributions

## Non-Goals

### What This SDK Does NOT Do
- **Business Logic**: SDK provides data, not trading decisions
- **Data Storage**: Customers choose their own database solutions
- **UI Components**: No frontend libraries or visualizations
- **Data Transformation**: Delivers data as-is from Trade360 APIs
- **Custom Protocols**: Only supports official LSports integration methods

## Evolution Path

### Current State (v2.4.0)
- Production-ready for all core features
- Spring Boot 3.x support
- Reactive HTTP clients
- Comprehensive entity models

### Near Future (v2.x)
- Improved test coverage (80%+)
- Enhanced documentation and examples
- Minor bug fixes and improvements
- Community-requested features

### Future Vision (v3.x+)
- Support for additional Java frameworks (Quarkus, Micronaut)
- Performance optimizations
- Advanced observability features
- Simplified configuration DSL

**Last Updated**: November 2025  
**Owner**: LSports Development Team

