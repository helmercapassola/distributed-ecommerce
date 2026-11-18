package com.ecommerce.events;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

 class OrderCancelledTest {

    // 1. Verificar se conseguimos criar um evento
    // de cancelamento com todos os dados válidos.
    @Test
    void shouldCreateOrderCancelledEventWithValidData() {
        UUID eventId = UUID.randomUUID();
        UUID orderId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        String reason = "Customer requested cancellation";
        Instant cancelledAt = Instant.now();

        OrderCancelled event = new OrderCancelled(eventId, orderId, customerId, reason, cancelledAt);

        assertNotNull(event);
        assertEquals(eventId, event.eventId());
        assertEquals(orderId, event.orderId());
        assertEquals(customerId, event.customerId());
        assertEquals(reason, event.reason());
        assertEquals(cancelledAt, event.cancelledAt());
    }

    // 2. verificar se o evento rejeita um eventID nulo.
    @Test
    void shouldRejectNullEventId() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new OrderCancelled(
                null, 
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                "Reason", 
                Instant.now());
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("eventId cannot be null", exception.getMessage());
    }

    // 3. verificar se o evento rejeita um orderID nulo.
    @Test
    void shouldRejectNullOrderId() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new OrderCancelled(
                UUID.randomUUID(), 
                null, 
                UUID.randomUUID(), 
                "Reason", 
                Instant.now());
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("orderId cannot be null", exception.getMessage());
    }
    
    // 4. verificar se o evento rejeita um customerID nulo.
    @Test   
    void shouldRejectNullCustomerId() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new OrderCancelled(
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                null, 
                "Reason", 
                Instant.now());
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("customerId cannot be null", exception.getMessage());
    }

    // 5. verificar se o evento rejeita um reason nulo.
    @Test
    void shouldRejectNullReason() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new OrderCancelled(
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                null, 
                Instant.now());
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("reason cannot be null", exception.getMessage());
    }

    // 6. verificar se o evento rejeita um cancelledAt nulo.
    @Test
    void shouldRejectBlankReason() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new OrderCancelled(
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                "", 
                Instant.now());
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("reason cannot be blank", exception.getMessage());
    }

    // 7. verificar se o evento rejeita um cancelledAt nulo.
    @Test
    void shouldRejectNullCancelledAt() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new OrderCancelled(
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                "customer requested cancellation", 
                null);
        });
        // confirmar se a mensagem de exceção é a esperada
        assertEquals("cancelledAt cannot be null", exception.getMessage());
    }
}
