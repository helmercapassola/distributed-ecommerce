ADR-001: Technology Stack
Status

Accepted

Date

2026-11-14

Context

The Distributed E-commerce Event Streaming Platform requires a technology stack capable of supporting:

Event-driven architecture.
Distributed microservices.
Real-time event streaming.
Scalable data processing.
Reliable message delivery.
Observability and monitoring.
Reproducible local development environments.

The platform is also intended to serve as a practical learning project covering Apache Kafka, Distributed Systems, Data Engineering and Microservices Architecture.

Decision

The following technology stack has been selected:

Technology	Purpose
Java 21	Microservices development
Apache Maven	Build and dependency management
Apache Kafka	Distributed event streaming
Kafka KRaft	Kafka cluster metadata management
Kafka Java Client	Producer and Consumer implementation
Kafka Streams	Real-time stream processing
Avro	Event serialization
Schema Registry	Event schema management
PostgreSQL	Relational data persistence
Kafka Connect	Data integration
Debezium	Change Data Capture (CDC)
Docker Compose	Local infrastructure
Kafka UI	Kafka administration
Prometheus	Metrics collection
Grafana	Monitoring and visualization
JUnit 5	Automated testing
Testcontainers	Integration testing
Architectural Constraints
All microservices will use Java 21.
Spring Framework and Spring Boot will not be used.
Microservices will communicate asynchronously through Apache Kafka.
Kafka will use KRaft instead of ZooKeeper.
Each microservice will maintain clear separation between domain, application and infrastructure responsibilities.
Event contracts will be managed using Avro and Schema Registry.
Infrastructure services will run locally through Docker Compose.
Consequences
Positive Consequences
Greater control over Kafka integration.
Deeper understanding of distributed systems.
Clear separation of business logic and infrastructure.
Reproducible development environments.
Explicit event contracts.
Improved architectural documentation.
Trade-offs
More infrastructure code must be implemented manually.
Dependency and configuration management require additional attention.
Error handling and lifecycle management must be implemented explicitly.
Development may initially take longer than using a framework such as Spring Boot.
Alternatives Considered
Spring Boot

Not selected because the project aims to explore Java and Kafka integration without relying on an application framework.

ZooKeeper

Not selected because Kafka KRaft provides native metadata management without requiring an external ZooKeeper cluster.

References
Apache Kafka Documentation: https://kafka.apache.org/documentation/
Java Documentation: https://docs.oracle.com/en/java/javase/21/
Apache Maven: https://maven.apache.org/
PostgreSQL Documentation: https://www.postgresql.org/docs/