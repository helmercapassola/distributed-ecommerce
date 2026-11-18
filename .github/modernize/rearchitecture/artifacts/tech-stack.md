# Technology Stack

## Implemented

- Language/runtime target: Java 21 (`java.version` and Maven compiler release in the root POM).
- Build: Apache Maven aggregator; one current module, packaged as a JAR.
- Dependency management: root POM manages Apache Kafka clients `4.1.1` and JUnit Jupiter `5.11.4`.
- Implemented module dependency: JUnit Jupiter for tests. The module has no Kafka client dependency, so Kafka is not yet used by Java code.
- Build plugins managed in the parent: Maven Compiler Plugin `3.13.0`, Maven Surefire Plugin `3.5.2`.
- Test framework: JUnit 5; one unit test currently covers `PlatformInfo.getName()`.
- Environment observed: OpenJDK Temurin `21.0.5`, Maven `3.9.16`, Docker `27.4.0`, Docker Compose `v2.31.0`.

## Configured local infrastructure

`infrastructure/docker/docker-compose.yml` configures:

- Apache Kafka image `apache/kafka:4.1.1`, in single-node KRaft mode.
- Kafka UI image `provectuslabs/kafka-ui:v0.7.2`.
- PostgreSQL image `postgres:16-alpine`.
- Named Kafka and PostgreSQL volumes and a shared Docker bridge network.

At inspection time, all three containers were running; Kafka and PostgreSQL reported healthy. Kafka UI was running on port `8080`. These resources are local infrastructure only; no Java producer/consumer, database access, application schema, or analytics code was found.

## Planned, not implemented

The README, ADR, system-architecture document, and attached roadmap describe Kafka Java clients, Avro, Schema Registry, Kafka Streams, Kafka Connect, Debezium, Prometheus, Grafana, OpenTelemetry, Testcontainers, microservices, and a Business UI. These have no corresponding application modules/configuration in the current repository, except the Kafka/PostgreSQL/Kafka UI Compose services above.

Spring is explicitly excluded by the ADR. No Spring or other application framework was found. No CI workflow or Maven wrapper was found.

