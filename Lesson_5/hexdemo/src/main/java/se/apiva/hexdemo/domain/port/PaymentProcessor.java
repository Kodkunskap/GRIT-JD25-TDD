package se.apiva.hexdemo.domain.port;

import se.apiva.hexdemo.domain.model.CustomerId;
import se.apiva.hexdemo.domain.model.Money;

public interface PaymentProcessor {
    String charge(CustomerId customerId, Money amount);
}
