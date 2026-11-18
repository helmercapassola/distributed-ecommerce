package com.ecommerce.events;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*; 

 class OrderConfirmedTest {

    // Testa se conseguimos criar um evento com todos os dados válidos
    @Test
    void shouldCreateOrderConfirmedWithValidData() {
        UUID eventId = UUID.randomUUID();
        UUID orderId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        Instant confirmedAt = Instant.now();

        OrderConfirmed event = new OrderConfirmed(eventId, orderId, customerId, confirmedAt);

        assertEquals(eventId, event.eventId());
        assertEquals(orderId, event.orderId());
        assertEquals(customerId, event.customerId());
        assertEquals(confirmedAt, event.confirmedAt());
    }

    // Testa se o evento rejeita um identificador de pedido nulo
    @Test
    void shouldRejectNullOrderId() {
        

        assertThrows(NullPointerException.class, () -> {
            new OrderConfirmed(null, UUID.randomUUID(),  UUID.randomUUID(), Instant.now());
        });
    }

    // Testa se o evento rejeita um identificador de encomenda nulo
    @Test
    void shoulRejectNullOrderId() {
        assertThrows(NullPointerException.class, () -> {
            new OrderConfirmed(UUID.randomUUID(), null, UUID.randomUUID(), Instant.now());
        });
    }

    // Testa se o evento rejeita um identificador de cliente nulo
    @Test 
    void shouldRejectNullCustomerId() {
        assertThrows(NullPointerException.class, () -> {
            new OrderConfirmed(UUID.randomUUID(), UUID.randomUUID(), null, Instant.now());
        });
    }

    // Testa se o evento rejeita uma data de confirmação nula
    @Test
    void shouldRejectNullConfirmedAt() {
        assertThrows(NullPointerException.class, () -> {
            new OrderConfirmed(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), null);
        });
    }
    
}
