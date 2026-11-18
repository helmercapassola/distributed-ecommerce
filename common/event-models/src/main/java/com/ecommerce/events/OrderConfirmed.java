package com.ecommerce.events;

import java.util.UUID;
import java.time.Instant;

import java.util.Objects;

// Rpresenta o evento de confirmação de pedido, que é emitido quando um pedido é confirmado com sucesso.

// Este evento poderá ser publicado no kafka para notificar outros serviços do sistema sobre a confirmação do pedido.

public record OrderConfirmed(
    // Identificador único deste evento
    UUID eventId,
    // Identificador do pedido que foi confirmado
    UUID orderId,
    // Identificador do cliente que fez o pedido
    UUID customerId,
    // data e hora da confirmação do pedido
     Instant confirmedAt
    ) {

        /*
        constructor que cria um novo evento de confirmação de pedido com um identificador de evento gerado automaticamente e a data e hora atual.
        Executa validações para garantir que os identificadores do pedido e do cliente não sejam nulos.
        */
    
        public OrderConfirmed{

            // O evento tem obrigatoriamente de possuir um identificador

            Objects.requireNonNull(eventId, "eventId cannot be null");
            Objects.requireNonNull(orderId, "orderId cannot be null");
            Objects.requireNonNull(customerId, "customerId cannot be null");
            Objects.requireNonNull(confirmedAt, "confirmedAt cannot be null");
            
        }
}
