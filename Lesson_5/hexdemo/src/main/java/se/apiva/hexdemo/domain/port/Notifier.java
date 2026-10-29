package se.apiva.hexdemo.domain.port;

import se.apiva.hexdemo.domain.model.Customer;

public interface Notifier {
    void orderConfirmation(String paymentId, Customer customer);
}
