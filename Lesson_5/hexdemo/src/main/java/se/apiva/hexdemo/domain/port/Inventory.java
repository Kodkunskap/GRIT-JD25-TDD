package se.apiva.hexdemo.domain.port;

import se.apiva.hexdemo.domain.model.ProductId;

public interface Inventory {
    boolean reserve(ProductId productId, int quantity);
}
