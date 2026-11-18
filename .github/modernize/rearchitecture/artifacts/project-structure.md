# Project Structure

## Current project type

Java/Maven repository with a Maven aggregator and one implemented JAR module. The codebase is currently a small library foundation, not a running e-commerce application or a collection of microservices. Docker Compose separately defines local infrastructure services.

## Implemented code and layers

- Maven modules: one, `common/event-models`.
- Main Java files: one, `PlatformInfo.java`.
- Test Java files: one, `PlatformInfoTest.java`.
- Application layers such as controller, service, repository, domain entities, or UI: not implemented.
- Java application entry point (`main` method): none found.
- HTTP/API routes, scheduled jobs, and message handlers: none found.
- Public Java API: `com.ecommerce.events.PlatformInfo.getName()`.

The implemented Java code is one utility class returning a constant platform name, with one JUnit test. Despite the module name, there are no event payload/model classes yet.

## Configuration and infrastructure

- `pom.xml`: root Maven parent, module aggregation, Java release, dependency management, and plugin versions.
- `common/event-models/pom.xml`: JAR module and JUnit test dependency.
- `infrastructure/docker/docker-compose.yml`: local Kafka broker, PostgreSQL, and Kafka UI services.
- `.gitignore`: Java/Maven outputs, IDE and OS files, local environment/secrets, and local data.
- `.vscode/settings.json`: Java extension build-configuration setting.
- `docs/adr/ADR-001-technology-stack.md`: selected technology and constraints.
- `docs/architecture/system-architecture.md`: target platform architecture and incremental strategy.

## Important implementation boundary

Kafka, Kafka UI, and PostgreSQL are present in Compose and were running during this inspection. The Java application does not yet connect to them. The README's project-structure section says `infrastructure/docker` is still planned, which no longer matches the tracked Compose file and current containers.

