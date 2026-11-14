
# Distributed E-commerce Event Streaming Platform

## 1. Architecture Overview

This document describes the high-level architecture
of the Distributed E-commerce Event Streaming Platform.

The platform follows an Event-Driven Architecture (EDA)
using Apache Kafka as its central event streaming platform.

## 2. System Architecture

```mermaid
flowchart TB

    subgraph CLIENT["Business Layer"]
        UI["Business Dashboard"]
    end

    subgraph SERVICES["Java 21 Microservices"]
        ORDER["Order Service"]
        INVENTORY["Inventory Service"]
        PAYMENT["Payment Service"]
        SHIPPING["Shipping Service"]
        NOTIFICATION["Notification Service"]
        AUDIT["Audit Service"]
    end

    subgraph KAFKA["Apache Kafka Platform - KRaft"]
        BROKER["Kafka Broker"]
        TOPIC1["orders.events"]
        TOPIC2["inventory.events"]
        TOPIC3["payments.events"]
        TOPIC4["shipping.events"]
    end

    subgraph DATA["Data Layer"]
        POSTGRES["PostgreSQL"]
        CONNECT["Kafka Connect"]
        DEBEZIUM["Debezium"]
        ANALYTICS["Analytics Storage"]
    end

    subgraph STREAMS["Stream Processing"]
        KS["Kafka Streams"]
    end

    subgraph MONITORING["Monitoring and Administration"]
        KAFKAUI["Kafka UI"]
        PROM["Prometheus"]
        GRAFANA["Grafana"]
    end

    ORDER --> BROKER
    BROKER --> TOPIC1

    TOPIC1 --> INVENTORY
    INVENTORY --> BROKER
    BROKER --> TOPIC2

    TOPIC2 --> PAYMENT
    PAYMENT --> BROKER
    BROKER --> TOPIC3

    TOPIC3 --> ORDER
    ORDER --> SHIPPING
    SHIPPING --> BROKER
    BROKER --> TOPIC4

    BROKER --> NOTIFICATION
    BROKER --> AUDIT

    ORDER --> POSTGRES
    INVENTORY --> POSTGRES
    PAYMENT --> POSTGRES

    POSTGRES --> DEBEZIUM
    DEBEZIUM --> CONNECT
    CONNECT --> BROKER

    BROKER --> KS
    KS --> ANALYTICS
    ANALYTICS --> UI

    BROKER -.-> KAFKAUI
    BROKER -.-> PROM
    PROM --> GRAFANA
```

## 3. Architecture Components

| Component | Responsibility |
|---|---|
| Apache Kafka | Event streaming and communication |
| Kafka UI | Kafka administration |
| Order Service | Order lifecycle management |
| Inventory Service | Stock management |
| Payment Service | Payment processing |
| Shipping Service | Shipment management |
| Notification Service | Customer notifications |
| Audit Service | Event auditing |
| PostgreSQL | Persistent data storage |
| Debezium | Change Data Capture |
| Kafka Connect | Data integration |
| Kafka Streams | Real-time analytics |
| Prometheus | Metrics collection |
| Grafana | Monitoring and dashboards |
| Business Dashboard | Business indicators |

## 4. Architectural Principles

- Event-Driven Architecture.
- Independent Java microservices.
- Asynchronous communication.
- Loose coupling between services.
- Event-based integration.
- Separation of business and technical monitoring.
- Distributed data ownership.
- Eventual consistency.

## 5. Implementation Strategy

The architecture will be implemented incrementally.

The initial environment will use a single Kafka broker
with KRaft and Kafka UI.

Additional infrastructure and services will be
introduced progressively throughout the project roadmap.
