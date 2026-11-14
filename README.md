
# Distributed E-commerce Event Streaming Platform

A distributed, event-driven e-commerce platform built with
Java 21 and Apache Kafka.

The project explores distributed systems, event-driven
architecture, real-time data processing, reliability,
observability and business analytics.

---

## 1. Project Vision

The goal is to build a distributed e-commerce platform
where independent microservices communicate through
Apache Kafka.

The platform will process the lifecycle of an order,
from its creation to payment, inventory reservation
and shipping.

It will also provide real-time business analytics
and technical observability.

## 2. Business Perspective

The platform will provide visibility into:

- Total orders.
- Confirmed, pending and cancelled orders.
- Sales volume and revenue.
- Sales per minute.
- Best-selling products.
- Revenue evolution.
- Operational indicators.

A dedicated Business Dashboard will present these
indicators.

## 3. Technical Architecture

The platform will include:

- Apache Kafka with KRaft.
- Kafka UI for Kafka administration.
- Java 21 microservices.
- PostgreSQL for data persistence.
- Apache Avro and Schema Registry.
- Kafka Streams for real-time analytics.
- Kafka Connect and Debezium for CDC.
- Prometheus for metrics collection.
- Grafana for observability.

## 4. Microservices

The planned services are:

| Service | Responsibility |
|---|---|
| Order Service | Order lifecycle management |
| Inventory Service | Product stock management |
| Payment Service | Payment processing |
| Shipping Service | Shipment management |
| Notification Service | Customer notifications |
| Audit Service | Event tracking and auditing |

## 5. Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Application development |
| Maven | Build and dependency management |
| Apache Kafka | Event streaming |
| Kafka Streams | Stream processing |
| Avro | Event serialization |
| PostgreSQL | Data persistence |
| Docker | Infrastructure |
| Kafka UI | Kafka administration |
| Prometheus | Metrics collection |
| Grafana | Observability |
| Git | Version control |

## 6. Project Structure

```text
distributed-ecommerce/
├── docs/
│   ├── adr/
│   └── architecture/
├── infrastructure/
│   └── docker/
└── scripts/
```

The repository structure will evolve as new
components are implemented.

## 7. Reliability and Distributed Systems

The project will explore:

- Event-driven architecture.
- Consumer groups and partitioning.
- Message delivery guarantees.
- Idempotent processing.
- Retry and Dead Letter Queues.
- Saga pattern.
- Outbox and Inbox patterns.
- Eventual consistency.
- Failure recovery.

## 8. Observability

Prometheus and Grafana will be used to monitor:

- Kafka brokers.
- Consumer lag.
- Throughput.
- Processing latency.
- Infrastructure performance.

## 9. Project Roadmap

| Phase | Description |
|---|---|
| 1 | Infrastructure and Kafka Fundamentals |
| 2 | Kafka Internals |
| 3 | Event-driven Architecture |
| 4 | Event Contracts and Schema Registry |
| 5 | Reliability |
| 6 | Distributed Systems |
| 7 | Kafka Streams |
| 8 | Kafka Connect and Debezium |
| 9 | Observability |
| 10 | Performance |
| 11 | Security and Deployment |

## 10. Project Status

**Current phase:** Phase 1 - Infrastructure and Kafka Fundamentals.

**Current stage:** Initial repository setup.

## 11. Learning Objectives

This project aims to develop practical knowledge of:

- Apache Kafka.
- Distributed Systems.
- Event-driven Microservices.
- Real-time Data Engineering.
- Stream Processing.
- Data Integration.
- Observability.
- Distributed System Reliability.

## 12. License

...
