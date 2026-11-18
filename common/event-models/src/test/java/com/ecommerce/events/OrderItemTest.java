package com.ecommerce.events;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

 class OrderItemTest {
    
    // Testas a criação de um produto com dados válidos.
    @Test 
    void shouldCreateOrderItemWithValidData() {
        UUID productId = UUID.randomUUID();
        int quantity = 2;
        BigDecimal unitPrice = new BigDecimal("15.00");

        OrderItem orderItem = new OrderItem(productId, quantity, unitPrice);

        // confirmar que os valores do item de pedido correspondem aos valores fornecidos.
        assertEquals(productId, orderItem.productId());
        assertEquals(quantity, orderItem.quantity());
        assertEquals(unitPrice, orderItem.unitPrice());
    }

    // Testa se o identificador do produto não pode ser nulo.
    @Test
    void shouldRejectNullProductId(){

        assertThrows(NullPointerException.class, () -> {
            new OrderItem(null, 1, new BigDecimal("15.00"));
        });
    }

    // Testa se a quantidade zero é rejeitada.
    @Test 
    void shouldRejectZeroQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(UUID.randomUUID(), 0, new BigDecimal("15.00"));
        });
    }

    // Testa se a quantidade negativa é rejeitada.
    @Test 
    void shouldRejectNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(UUID.randomUUID(), -1, new BigDecimal("15.00"));
        });
    }

    // Testa se preços negativos são rejeitados.
    @Test
    void shouldRejectNegativeUnitPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(UUID.randomUUID(), 2, new BigDecimal("-15.00"));
        });
    }

    // Testa se o subtotal é calculado corretamente.
    @Test
    void shouldCalculateSubtotalCorrectly() {
       
        OrderItem orderItem = new OrderItem(UUID.randomUUID(), 3, new BigDecimal("15.00"));
        BigDecimal expectedSubtotal = new BigDecimal("45.00");

        assertEquals(0, orderItem.subtotal().compareTo(expectedSubtotal));
    }

    // Testa se um produto gratuito é permitido.
    @Test 
    void shouldAcceptZeroUnitPrice() {
        OrderItem orderItem = new OrderItem(UUID.randomUUID(), 1, BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, orderItem.unitPrice());
    }
}
