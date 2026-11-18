package com.ecommerce.events;

import java.util.UUID;
import java.time.Instant;
import java.util.Objects;

public record OrderCancelled(UUID eventId, UUID orderId, UUID customerId, String reason, Instant cancelledAt) {
   
    public OrderCancelled {
        Objects.requireNonNull(eventId, "eventId cannot be null");
        Objects.requireNonNull(orderId, "orderId cannot be null");
        Objects.requireNonNull(customerId, "customerId cannot be null");
        Objects.requireNonNull(reason, "reason cannot be null");
        // Não permitimos motivos vazios ou em branco.
        // isBlank() verifica se a String está vazia ou contém apenas espaços.
        if (reason.isBlank()) {
            throw new IllegalArgumentException("reason cannot be blank");
        }
        Objects.requireNonNull(cancelledAt, "cancelledAt cannot be null");
    }

  


    
}
