package com.ecommerce.events;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

// Testes unitários para a classe OrderCreated, garantindo que a criação de eventos de pedido funcione corretamente e que as validações sejam aplicadas conforme esperado.
public class OrderCreatedTest {

    // Verificar a criação bem-sucedida de um evento OrderCreated com dados válidos.
    @Test
    void shouldCreateOrderCreatedEventWithValidData() {
        UUID eventId = UUID.randomUUID();
        UUID orderId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        BigDecimal totalAmount = new BigDecimal("150.00");
        String currency = "EUR";
        Instant createdAt = Instant.now();

        OrderCreated orderCreated = new OrderCreated(eventId, orderId, customerId, totalAmount, currency, createdAt);

        // verficar se os dados foram correctamente atribuídos ao objeto OrderCreated
        assertNotNull(orderCreated);
        assertEquals(eventId, orderCreated.eventId());
        assertEquals(orderId, orderCreated.orderId());
        assertEquals(customerId, orderCreated.customerId());
        assertEquals(totalAmount, orderCreated.totalAmount());
        assertEquals(currency, orderCreated.currency());
        assertEquals(createdAt, orderCreated.createdAt());
    }

    // Verificar se o evento rejeita identficadores de pedido nulos, garantindo que
    // a validação de não-nulo funcione corretamente.
    @Test
    void shouldRejectNullEventId() {
        UUID orderId = UUID.randomUUID();
        UUID customerId = UUID.randomUUID();
        BigDecimal totalAmount = new BigDecimal("150.00");
        String currency = "EUR";
        Instant createdAt = Instant.now();

        Exception exception = assertThrows(NullPointerException.class, () -> {
            new OrderCreated(null, orderId, customerId, totalAmount, currency, createdAt);
        });

        assertEquals("eventId cannot be null", exception.getMessage());
    }

    // verificar se o evento rejeita valores iguais ou inferiores a zero.

    @Test
    void shouldRejectNonPositiveTotalAmount() {

        assertThrows(IllegalArgumentException.class, () -> {
            new OrderCreated(
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                UUID.randomUUID(), 
                BigDecimal.ZERO, "EUR", 
                Instant.now());
        });
}

// Verificar se o evento rejeita moedas vazias. 
@Test 
void shouldRejectBlankCurrency() {
    assertThrows(IllegalArgumentException.class, () -> {
        new OrderCreated(
            UUID.randomUUID(), 
            UUID.randomUUID(), 
            UUID.randomUUID(), 
            new BigDecimal("150.00"), "", 
            Instant.now());
    });

}

// verificar se o evento rejeita códigos de moeda com tamanho incorreto (não 3 caracteres).
@Test
void shouldRejectInvalidCurrencyLength() {
    assertThrows(IllegalArgumentException.class, () -> {
        new OrderCreated(
            UUID.randomUUID(), 
            UUID.randomUUID(), 
            UUID.randomUUID(), 
            new BigDecimal("150.00"), "EURO", 
            Instant.now());
    });

}

}