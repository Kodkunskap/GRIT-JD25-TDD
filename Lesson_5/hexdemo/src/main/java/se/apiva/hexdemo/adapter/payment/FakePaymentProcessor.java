package se.apiva.hexdemo.adapter.payment;

import org.springframework.stereotype.Component;
import se.apiva.hexdemo.domain.model.CustomerId;
import se.apiva.hexdemo.domain.model.Money;
import se.apiva.hexdemo.domain.port.PaymentProcessor;

@Component
public class FakePaymentProcessor implements PaymentProcessor {
    @Override
    public String charge(CustomerId customerId, Money amount) {
        return "PAY-"+customerId.value() + " " + amount.amount();
    }
}
