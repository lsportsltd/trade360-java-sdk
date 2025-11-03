# Project Brief: Trade360 Java SDK

## Project Overview
The Trade360 Java SDK is a comprehensive Java library developed by LSports to simplify integration with Trade360 services within the Sports Trading Management (STM) ecosystem.

## Core Goals

### Primary Objective
Provide a production-ready, type-safe, and developer-friendly SDK that enables Java applications to:
1. Consume real-time sports data from RabbitMQ feeds
2. Access snapshot APIs for data recovery
3. Manage customer subscriptions and metadata

### Success Criteria
- **Developer Experience**: Seamless Spring Boot integration with minimal configuration
- **Reliability**: Built-in connection resilience, retry mechanisms, and error handling
- **Type Safety**: Strongly typed entities for all Trade360 data structures
- **Performance**: Reactive, non-blocking operations using Project Reactor
- **Quality**: 80%+ test coverage with comprehensive unit and integration tests
- **Documentation**: Complete API documentation and usage examples

## Project Scope

### In Scope
- ✅ RabbitMQ feed integration (InPlay & PreMatch)
- ✅ Snapshot API client (fixture recovery, market snapshots)
- ✅ Customers API client (subscriptions, metadata, package management)
- ✅ Spring Boot auto-configuration support
- ✅ Comprehensive entity models for all data types
- ✅ Error handling and retry mechanisms
- ✅ Sample applications demonstrating usage
- ✅ Maven Central publication

### Out of Scope
- ❌ Non-Java language implementations (separate SDKs exist)
- ❌ Direct database integration (client responsibility)
- ❌ UI components or visualization tools
- ❌ Business logic or trading algorithms
- ❌ Custom data transformations beyond LSports API contracts

## Target Audience

### Primary Users
- **Java Developers**: Building sports trading platforms
- **Integration Engineers**: Connecting systems to LSports Trade360
- **Backend Teams**: Implementing real-time sports data processing

### Prerequisites
- Java 17+ knowledge
- Spring Boot experience (recommended but not required)
- Understanding of reactive programming concepts (Project Reactor)
- Basic RabbitMQ knowledge for feed integration

## Key Requirements

### Functional Requirements
1. **Real-Time Feed**
   - Connect to RabbitMQ brokers with configurable connection parameters
   - Automatically deserialize and route messages by type
   - Support multiple message types (fixtures, markets, livescore, settlements, outrights)
   - Handle InPlay and PreMatch feeds independently

2. **Snapshot API**
   - HTTP client for fixture and market recovery
   - Authentication handling
   - Request/response serialization
   - Reactive response handling with `Mono<T>`

3. **Customers API**
   - Package distribution control (start/stop)
   - Subscription management (by fixture or league)
   - Metadata retrieval (sports, leagues, locations, markets)
   - Quota and status queries

### Non-Functional Requirements
1. **Performance**: Handle high-throughput message processing (1000+ msgs/sec)
2. **Reliability**: Automatic connection recovery, exponential backoff retries
3. **Maintainability**: Clean architecture, SOLID principles, comprehensive tests
4. **Security**: Secure credential management, no hardcoded secrets
5. **Observability**: Detailed logging, health checks, metrics support

## Constraints

### Technical Constraints
- **Java 17**: Minimum required version
- **Spring Boot 3.3.2**: Framework version (for Spring implementations)
- **Maven**: Build tool and dependency management
- **Jackson**: JSON serialization library
- **Project Reactor**: Reactive streams implementation

### Business Constraints
- Must maintain backward compatibility within major versions
- Breaking changes require major version bump
- Must follow LSports API contracts and schemas
- Maven Central publication requires signing and documentation

## Success Metrics

### Adoption Metrics
- Download count from Maven Central
- GitHub stars and forks
- Community contributions (PRs, issues)

### Quality Metrics
- ✅ 80%+ test coverage (JaCoCo)
- ✅ Zero critical security vulnerabilities (Trivy/Codacy scans)
- ✅ Codacy quality grade A or B
- Response time for bug fixes < 7 days

### Documentation Metrics
- Complete Javadoc for all public APIs
- Up-to-date README with examples
- Sample applications for each integration pattern

## Project Timeline

### Current Status
- **Version**: 2.4.0
- **Status**: Production-ready, actively maintained
- **Last Major Update**: Package namespace migration (com.lsports → eu.lsports)

### Ongoing Work
- Test coverage improvements (TR-19546)
- Documentation enhancements (TR-20193)
- Bug fixes and minor improvements
- Community support and issue resolution

## Source of Truth
This document is the foundation for all architectural and implementation decisions. Any changes to core goals, scope, or requirements must be reflected here first.

**Last Updated**: November 2025  
**Owner**: LSports Development Team  
**Stakeholders**: LSports customers, integration partners, internal teams

