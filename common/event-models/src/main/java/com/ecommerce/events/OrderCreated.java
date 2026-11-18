package com.ecommerce.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

// Este record representa um evento de criação de pedido em um sistema de e-commerce distribuído. Ele contém informações essenciais sobre o pedido, como IDs, valor total, moeda e timestamp de criação.
public  record OrderCreated(
    UUID eventId,
    UUID orderId,
    UUID customerId,
    BigDecimal totalAmount,
    String currency,
    Instant createdAt
) {

    public OrderCreated {
        Objects.requireNonNull(eventId, "eventId cannot be null");
        Objects.requireNonNull(orderId, "orderId cannot be null");
        Objects.requireNonNull(customerId, "customerId cannot be null");
        Objects.requireNonNull(totalAmount, "totalAmount cannot be null");
        Objects.requireNonNull(currency, "currency cannot be null");
        Objects.requireNonNull(createdAt, "createdAt cannot be null");

        // Validações adicionais para garantir que os valores sejam consistentes e válidos
        if(totalAmount.signum() <= 0){
            throw new IllegalArgumentException("totalAmount must be greater than zero");
        }
// Valida se a moeda é uma string de 3 caracteres (ISO 4217)
        if(currency.isBlank()){
            throw new IllegalArgumentException("currency cannot be blank");
        }
// Valida se a moeda é uma string de 3 caracteres (ISO 4217)
        if(currency.length() != 3){
            throw new IllegalArgumentException("currency must contain exactly 3 characters");
        }
    }
}
