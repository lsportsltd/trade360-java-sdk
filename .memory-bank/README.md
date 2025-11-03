# Memory Bank - Trade360 Java SDK

This directory contains structured documentation that serves as persistent context for AI-assisted development and team onboarding.

## 📚 Purpose

The Memory Bank solves four key problems:
1. **Model Lost Context** - AI agents can reference these files across sessions
2. **Forgotten Solutions** - Design decisions and patterns are documented
3. **Session Continuity** - New sessions can pick up where previous ones left off
4. **Team Onboarding** - New team members get comprehensive project context

## 🗂️ File Structure

### Core Files

#### `projectbrief.md` - Project Foundation
**Purpose**: Defines project goals, scope, and requirements  
**When to Read**: Starting new features, making architectural decisions  
**When to Update**: When project scope or goals change

**Contains**:
- Project overview and objectives
- Core goals and success criteria
- Project scope (in/out of scope)
- Target audience
- Constraints and requirements

#### `productContext.md` - Why This Exists
**Purpose**: Explains business context and user experience goals  
**When to Read**: Understanding user needs, designing features  
**When to Update**: When new use cases emerge or user feedback changes direction

**Contains**:
- Business context and problem statement
- Problems the SDK solves
- How it should work (user experience)
- User journey and success indicators

#### `systemPatterns.md` - Architecture & Design
**Purpose**: Documents technical decisions and design patterns  
**When to Read**: Implementing new features, refactoring code  
**When to Update**: After major architectural decisions or pattern changes

**Contains**:
- System architecture diagrams
- Key technical decisions and rationale
- Design patterns in use
- Component relationships
- Error handling architecture

#### `techContext.md` - Technical Stack
**Purpose**: Lists technologies, tools, and setup instructions  
**When to Read**: Setting up dev environment, adding dependencies  
**When to Update**: When adding new dependencies or changing tools

**Contains**:
- Technology stack (Java, Spring Boot, Maven, etc.)
- Development setup instructions
- Build commands and workflows
- Technical constraints
- Dependency list and versions

#### `activeContext.md` - Current Work
**Purpose**: Tracks current tasks, recent changes, and next steps  
**When to Read**: Starting work, checking project status  
**When to Update**: **Frequently** - after completing tasks, making decisions

**Contains**:
- Current work focus
- Recent changes (last 30 days)
- Next steps (immediate, short-term, long-term)
- Active decisions and considerations
- Known issues

#### `Progress.md` - What's Done & What's Left
**Purpose**: Tracks completed features and remaining work  
**When to Read**: Planning sprints, reporting status  
**When to Update**: After completing features or identifying new work

**Contains**:
- What works (production-ready features)
- What's left to build
- Current status and metrics
- Known issues and limitations
- Recent milestones

## 🔄 Update Workflow

### When to Update Memory Bank

1. **After Completing a Feature**
   - Update `Progress.md` - Move from "What's Left" to "What Works"
   - Update `activeContext.md` - Add to "Recent Changes"

2. **When Making Architectural Decisions**
   - Update `systemPatterns.md` - Document decision and rationale
   - Update `activeContext.md` - Add to "Active Decisions"

3. **When Changing Project Scope**
   - Update `projectbrief.md` - Adjust goals or constraints
   - Update `productContext.md` - Update user experience goals

4. **When Adding Dependencies**
   - Update `techContext.md` - Add to dependency list with rationale

5. **When Starting New Work**
   - Update `activeContext.md` - Set new work focus
   - Update `Progress.md` - Add to "What's Left to Build"

6. **Daily/Weekly**
   - Review `activeContext.md` - Keep current work section up to date

### How to Update

#### Manual Updates
1. Open the relevant file in your IDE
2. Make changes following the existing structure
3. Keep formatting consistent
4. Update "Last Updated" date at bottom

#### AI-Assisted Updates
Use this command in Cursor:
```
@.memory-bank Update [filename] to reflect [changes]
```

Example:
```
@.memory-bank Update activeContext.md to reflect completion of TR-20193 (README update)
```

## 🤖 Using with Cursor IDE

### Initial Setup

1. **Add Project Rule** (if using Cursor rules)
   - Add a rule that references Memory Bank files
   - Rule should instruct AI to check these files for context

2. **Reference in Prompts**
   ```
   @.memory-bank/projectbrief.md What are the project goals?
   @.memory-bank/systemPatterns.md What design patterns are we using?
   @.memory-bank/activeContext.md What's the current work focus?
   ```

### Best Practices

#### ✅ Do
- Reference Memory Bank files when asking architectural questions
- Update activeContext.md frequently
- Keep files focused and well-structured
- Include rationale for decisions
- Use clear, concise language

#### ❌ Don't
- Store code snippets (use actual code files)
- Duplicate information across files
- Let files get stale (review monthly)
- Write in first person (use third person)
- Include sensitive information (credentials, keys)

## 📖 Reading Guide

### For New Team Members

**Day 1**: Read in this order:
1. `projectbrief.md` - Understand the "why"
2. `productContext.md` - Understand the user perspective
3. `techContext.md` - Set up your environment
4. `activeContext.md` - Know what's happening now

**Week 1**: Read:
5. `systemPatterns.md` - Understand the architecture
6. `Progress.md` - Know what's done and what's next

### For AI Agents

**Starting a new session**:
1. Read `activeContext.md` first
2. Check `Progress.md` for current status
3. Reference other files as needed for specific questions

**During development**:
1. Check relevant file before making decisions
2. Reference patterns from `systemPatterns.md`
3. Follow constraints from `projectbrief.md` and `techContext.md`

### For Experienced Developers

**Before starting work**:
- Skim `activeContext.md` for recent changes
- Check `Progress.md` for status

**When making decisions**:
- Reference `systemPatterns.md` for established patterns
- Check `projectbrief.md` for constraints

**When context switching**:
- Read `activeContext.md` to catch up

## 🔗 Related Documentation

- **Main README**: `/README.md` - User-facing documentation
- **API Docs**: Generate with `mvn javadoc:javadoc`
- **Sample Code**: `/samples/` - Working examples
- **Confluence**: https://lsports-data.atlassian.net/wiki/spaces/LSPORTS/
- **Jira**: https://lsports-data.atlassian.net/

## 📊 File Maintenance Schedule

| File | Update Frequency | Owner |
|------|------------------|-------|
| `projectbrief.md` | Quarterly | Product/Tech Lead |
| `productContext.md` | Quarterly | Product Manager |
| `systemPatterns.md` | Monthly or after major changes | Tech Lead |
| `techContext.md` | As needed (dependency changes) | Dev Team |
| `activeContext.md` | **Daily/Weekly** | Current Developer/AI |
| `Progress.md` | **Weekly** | Dev Team |

## 🎯 Success Metrics

The Memory Bank is successful when:
- ✅ AI agents provide contextually relevant responses
- ✅ New team members onboard faster (< 1 week)
- ✅ Architectural decisions are consistent
- ✅ Knowledge is retained across team changes
- ✅ Context switches are smoother

## 📝 Template Source

This Memory Bank structure is based on the LSports STM standard documented at:
https://lsports-data.atlassian.net/wiki/spaces/LSPORTS/pages/1730281482/Memory+Bank

Original concept from: https://gist.github.com/ipenywis/1bdb541c3a612dbac4a14e1e3f4341ab

---

**Created**: November 3, 2025  
**Last Updated**: November 3, 2025  
**Maintained By**: LSports Development Team  
**Version**: 1.0

