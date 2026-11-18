package com.ecommerce.events;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


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

        if(totalAmount.signum() <= 0){
            throw new IllegalArgumentException("totalAmount must be greater than zero");
        }

        if(currency.isBlank()){
            throw new IllegalArgumentException("currency cannot be blank");
        }

        if(currency.length() != 3){
            throw new IllegalArgumentException("currency must contain exactly 3 characters");
        }
    }
}
