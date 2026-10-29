package se.apiva.hexdemo.domain.model;

import java.math.BigDecimal;

public record CartItem(ProductId productId, Money unitPrice, int quantity) {

    public Money lineTotal() {
        return new Money(unitPrice.amount().multiply(BigDecimal.valueOf(quantity)));
    }


}
