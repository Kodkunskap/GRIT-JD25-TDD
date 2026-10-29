package se.apiva.hexdemo.domain.port;

import se.apiva.hexdemo.domain.model.Cart;
import se.apiva.hexdemo.domain.model.Customer;
import se.apiva.hexdemo.domain.model.Money;

public interface PricingPolicy {
    Money priceFor(Cart cart, Customer customer);
}
