package se.apiva.hexdemo.adapter.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import se.apiva.hexdemo.domain.model.Customer;
import se.apiva.hexdemo.domain.port.Notifier;

@Component
public class LogNotifier implements Notifier {

    private static final Logger log = LoggerFactory.getLogger(LogNotifier.class);

    @Override
    public void orderConfirmation(String paymentId, Customer customer) {
            log.info("Order Confirmation: {} {}", paymentId, customer);
    }
}
