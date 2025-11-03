# Active Context: Trade360 Java SDK

## Current Work Focus

### Active Task: Documentation Enhancement (TR-20193)
**Status**: ✅ Completed  
**Description**: Update README.md following LSports STM template  
**Branch**: main  
**Last Update**: November 2025

**Completed Actions**:
- ✅ Analyzed existing README structure
- ✅ Fetched Confluence page with template structure
- ✅ Created comprehensive README with:
  - Project brief and overview
  - Tech context and architecture diagrams (Mermaid)
  - Core components documentation
  - Key features and design patterns
  - Complete getting started guide
  - Deployment instructions (Maven, Docker, CI/CD)
  - Testing and debugging guides
  - Configuration reference tables
  - Monitoring and observability section
  - Contributing guidelines
- ✅ Increased documentation from ~508 lines to 800+ lines
- ✅ Added professional LSports STM branding and structure

### Previous Task: Test Coverage Improvement (TR-19546)
**Status**: ⚠️ Paused  
**Description**: Increase test coverage from ~71% to 80%  
**Branch**: TR-19546-increase-coverage (abandoned due to issues)  
**Challenges Encountered**:
- Java 24 compatibility issues with Mockito's Byte Buddy
- pom.xml changes caused Codacy coverage drop (78% → 23%)
- Need to add tests without modifying pom.xml

**Lessons Learned**:
- Avoid mocking final classes (records) due to Java 24 limitations
- Avoid modifying pom.xml as it affects Codacy metrics
- Use real instances instead of mocks for Spring components
- Focus on testing business logic, not framework internals

### Memory Bank Initialization
**Status**: ✅ Completed  
**Description**: Created Memory Bank structure for AI context persistence  
**Actions**:
- ✅ Created 10 comprehensive memories in Cursor memory system
- ✅ Created `.memory-bank/` directory with structured documentation:
  - `projectbrief.md` - Project goals and scope
  - `productContext.md` - Why project exists, problems it solves
  - `systemPatterns.md` - Architecture and design patterns
  - `techContext.md` - Technical stack and setup
  - `activeContext.md` - This file (current work)
  - `Progress.md` - Completed and pending tasks

## Recent Changes

### November 2025

#### README.md Rewrite
- **Date**: November 3, 2025
- **Type**: Documentation
- **Impact**: Major improvement in documentation quality
- **Changes**:
  - Complete restructure following LSports STM template
  - Added Mermaid diagrams for architecture and flows
  - Comprehensive configuration reference tables
  - Step-by-step guides for all integration patterns
  - Professional formatting with emoji section markers
  - Links to official documentation and resources

#### Memory Bank Setup
- **Date**: November 3, 2025
- **Type**: Project Infrastructure
- **Impact**: Enables AI context persistence across sessions
- **Changes**:
  - Created `.memory-bank/` directory structure
  - Documented all aspects of the project
  - Stored 10 memories in Cursor memory system
  - Established single source of truth for project knowledge

#### Package Namespace Migration (Earlier 2025)
- **Date**: Earlier in 2025
- **Type**: Breaking Change
- **Impact**: All packages renamed from `com.lsports` to `eu.lsports`
- **Reason**: Organizational alignment with domain structure
- **Status**: Complete, version 2.4.0+ uses new namespace

## Next Steps

### Immediate (This Week)
1. ✅ Complete Memory Bank setup
2. ✅ Finalize README.md updates
3. ⏳ Review and merge any pending documentation PRs
4. ⏳ Update Confluence documentation if needed

### Short Term (Next 2 Weeks)
1. ⏳ Revisit test coverage improvement (TR-19546)
   - Identify low-coverage classes without mocking limitations
   - Add tests for simple POJOs, enums, utility classes
   - Target 2% coverage increase without pom.xml changes
2. ⏳ Address any customer-reported issues
3. ⏳ Review and update sample applications

### Medium Term (Next Month)
1. ⏳ Consider Java 21 compatibility testing
2. ⏳ Evaluate migration from JUnit 4 to JUnit 5
3. ⏳ Investigate Mockito alternatives for Java 24 compatibility
4. ⏳ Performance benchmarking and optimization
5. ⏳ Additional integration examples (Kafka, gRPC if applicable)

### Long Term (Next Quarter)
1. ⏳ Support for additional frameworks (Quarkus, Micronaut)
2. ⏳ Advanced observability features (OpenTelemetry)
3. ⏳ Configuration DSL for simplified setup
4. ⏳ Version 3.0 planning with breaking changes if needed

## Active Decisions and Considerations

### Decision: Memory Bank Structure
**Context**: Need persistent context across AI sessions  
**Decision**: Follow LSports STM Memory Bank pattern from Confluence  
**Status**: ✅ Implemented  
**Rationale**: Standardized approach across LSports projects

### Decision: Test Coverage Strategy
**Context**: Need to increase coverage from 71% to 80% without breaking Codacy  
**Decision**: Focus on non-mocked, simple classes; avoid pom.xml changes  
**Status**: ⏳ Pending implementation  
**Considerations**:
- Test enum edge cases
- Test POJO constructors, getters, setters
- Test configuration binding
- Test serialization/deserialization
- Avoid testing Spring framework internals

### Decision: Java 24 Compatibility
**Context**: Mockito Byte Buddy has issues with Java 24  
**Decision**: Use real instances instead of mocks where possible  
**Status**: ⏳ Ongoing  
**Impact**: 
- Cannot mock certain final classes (records)
- Cannot mock some Spring components
- Need alternative testing strategies

### Consideration: JUnit 5 Migration
**Context**: Project uses JUnit 4, but JUnit 5 is modern standard  
**Decision**: Defer to future release  
**Reason**: 
- Current tests work fine
- Migration would require significant effort
- No immediate benefit
- Could be part of v3.0

### Consideration: Additional Framework Support
**Context**: Customers may use Quarkus, Micronaut, or other frameworks  
**Decision**: Evaluate demand before implementation  
**Status**: ⏳ Gathering feedback  
**Approach**: Factory pattern already supports this, just need implementations

## Known Issues

### Java 24 Mockito Compatibility
- **Issue**: `java.lang.IllegalArgumentException: Java 24 (68) is not supported by the current version of Byte Buddy`
- **Impact**: Cannot mock certain classes in tests
- **Workaround**: Use real instances or alternative testing approaches
- **Long-term Fix**: Wait for Mockito/Byte Buddy update or migrate to alternative mocking framework

### Codacy Coverage Reporting
- **Issue**: pom.xml changes can cause coverage to drop dramatically (78% → 23%)
- **Impact**: Blocks test coverage improvement efforts
- **Workaround**: Add tests without modifying pom.xml
- **Root Cause**: Unknown, possibly related to JaCoCo/Surefire plugin configuration

### Package Namespace Migration Remnants
- **Issue**: Some old `com.lsports` references may still exist in comments or docs
- **Impact**: Minimal, mostly cosmetic
- **Status**: ⏳ Ongoing cleanup as discovered

## Development Environment

### Current Setup (User: shir.b)
- **OS**: macOS (darwin 25.0.0)
- **IDE**: Cursor IDE / Rider
- **Shell**: zsh
- **Workspace**: `/Users/shir.b/RiderProjects/trade360-java-sdk`
- **Git Branch**: Currently on `main` after branch recreation

### Git State
- **Current Branch**: `main`
- **Status**: Clean working directory (after recent commits)
- **Remote**: Behind origin/main by 377 commits (needs `git pull`)
- **Note**: Feature branches follow pattern `TR-{ticket}-{description}`

### Codacy Integration
- **Status**: Configured but CLI has initialization issues
- **Rules**: Strict quality gates enforced
- **Process**: Must run analysis after any file edit
- **Note**: Codacy MCP Server integration via Cursor IDE

## Communication Preferences

### User (shir.b) Preferences
- **Style**: Direct and concise, minimal confirmations
- **Autonomy**: Expects AI to execute tasks without excessive questions
- **Quality**: Values code quality, test coverage, Codacy metrics
- **Feedback**: Uses short responses ("yes", "approve", "stop")
- **Paths**: Prefers absolute paths in commands

## Resources

### Documentation
- **Confluence**: https://lsports-data.atlassian.net/wiki/spaces/LSPORTS/
- **Jira**: https://lsports-data.atlassian.net/
- **GitHub**: https://github.com/lsportsltd/trade360-java-sdk
- **Maven Central**: eu.lsports:trade360-java-sdk

### Key URLs
- **Snapshot API**: https://stm-snapshot.lsports.eu
- **Customers API**: https://stm-api.lsports.eu
- **API Docs**: https://docs.lsports.eu/lsports/v/integration

### Contact
- **Team**: LSports Development Team
- **Email**: dev@lsports.eu

**Last Updated**: November 3, 2025  
**Maintained By**: AI Agent with user guidance

