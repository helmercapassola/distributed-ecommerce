package com.ecommerce.events;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.Objects;

// Representa um item de pedido em um evento de pedido, encapsulando informações como identificador do item, nome do produto, quantidade e preço unitário.
public record OrderItem (

    // Identificador único do item de pedido.
    UUID productId,
    // quantidade de uniades encome
    int quantity,
    // preço unitário do produto.
    BigDecimal unitPrice
){
    // Construtor que valida os parâmetros fornecidos, garantindo que o identificador do produto não seja nulo, a quantidade seja positiva e o preço unitário seja positivo.
    public OrderItem {
        // o produto tem obrigatoriamente de ter um identificador único, não pode ser nulo.
        Objects.requireNonNull(productId, "productId cannot be null");

        //// A quantidade tem de ser superior a zero.
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "quantity must be greater than zero"
            );
        }

        // O preço unitário não pode ser nulo.
        Objects.requireNonNull(
                unitPrice,
                "unitPrice cannot be null"
        );

        // O preço não pode ser negativo.
        if (unitPrice.signum() < 0) {
            throw new IllegalArgumentException(
                    "unitPrice cannot be negative"
            );
        }
    }

    // calcula o subtotal do item de pedido multiplicando o preço unitário pela quantidade.
    public BigDecimal subtotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}