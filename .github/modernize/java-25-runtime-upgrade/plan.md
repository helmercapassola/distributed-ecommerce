# Modernization Plan: Java 25 LTS Runtime Upgrade

**Project**: distributed-ecommerce  
**Planning date**: 2026-11-17

## Technical Framework

- **Language/runtime**: Java 21 (target: Java 25 LTS)
- **Build tool**: Apache Maven, multi-module parent build
- **Framework**: None identified; Spring Boot and Spring Framework are explicitly excluded by the current ADR
- **Implemented module**: `common/event-models`
- **Key dependencies/plugins**: Kafka client 4.1.1, JUnit 5.11.4, Maven Compiler Plugin 3.13.0, Maven Surefire 3.5.2

## Overview

Upgrade the project's Java runtime and compilation target from Java 21 to Java 25, the latest generally available LTS release as of 2026-11-17. Align Maven's Java selection and project documentation so that local contributors and future services use the same runtime. Preserve the existing architecture and dependency choices; this plan does not upgrade application frameworks or migrate services.

## Migration Impact Summary

| Area | Current | Target | Expected outcome |
|---|---|---|---|
| Java runtime | Java 21 | Java 25 LTS | Consistent supported runtime |
| Maven compilation | `java.version` 21 | `java.version` 25 | Compiler release follows the shared property |
| Maven toolchain | No project toolchain config found | Select JDK 25 | Repeatable local Maven builds |
| Documentation | Java 21 requirements and diagrams | Java 25 requirements and diagrams | Accurate setup and architecture guidance |

## Scope and Requirements

- Set the root POM's `java.version` property to `25`. Keep `maven.compiler.release` and the compiler plugin's `<release>` tied to that property so the target cannot drift; update the POM project description to Java 25.
- Add project-level Maven toolchain enforcement so compilation selects a JDK 25 installation, and document the per-user `~/.m2/toolchains.xml` mapping and verification steps. Do not commit machine-specific JDK installation paths or a developer's personal toolchains file. Keep the Maven runtime and compiler toolchain expectations clear.
- Update Java 21 references that describe the selected/runtime version in `README.md`, `docs/adr/ADR-001-technology-stack.md`, and `docs/architecture/system-architecture.md`. Update the README prerequisites/build instructions and the ADR decision, architectural constraint, and Java documentation link. Retain dated historical statements only if clearly labeled as historical.
- Keep Kafka, JUnit, Maven plugin, and other dependency versions unchanged unless Java 25 compatibility evidence requires a narrowly scoped adjustment.
- The repository currently has no Maven wrapper or CI workflow; do not imply those are already configured. If the upgrade introduces a toolchain configuration file or build-plugin setup, document it as part of this change.

## Execution and Validation Strategy

Perform the runtime/property/toolchain/documentation alignment as one upgrade task, then run a separate dependency CVE scan as the plan's standard security check. Do not add Azure deployment, containerization, service migration, Spring upgrades, or new integration-test infrastructure.

Acceptance checks for the Java upgrade:

1. Run `mvn -version` with JDK 25 available and confirm the reported Java version/toolchain selection is Java 25.
2. Inspect the effective Maven model (for example, `mvn help:effective-pom`) and confirm the compiler release resolves to 25 in the root build and module build.
3. Run `mvn clean verify` from the repository root using the JDK 25 toolchain; the reactor build and all existing tests must pass.
4. Confirm generated classes target Java 25 (class-file major version 69) and that no active setup instructions or architecture claims still prescribe Java 21.
5. Review the diff to ensure only the runtime/toolchain/docs and any evidence-driven compatibility fixes changed; dependency versions remain stable absent a demonstrated incompatibility.

## Out of Scope

- Upgrading Spring Boot, Spring Framework, or Jakarta EE (none is currently used; the ADR expressly excludes Spring).
- Changing Kafka, database, or infrastructure architecture.
- Adding CI, Maven Wrapper, deployment, containerization, or Azure resources.
- Adding integration-test infrastructure beyond running the tests already present.

