package se.apiva.hexdemo.domain.service;

import se.apiva.hexdemo.domain.model.*;
import se.apiva.hexdemo.domain.port.Inventory;
import se.apiva.hexdemo.domain.port.Notifier;
import se.apiva.hexdemo.domain.port.PaymentProcessor;
import se.apiva.hexdemo.domain.port.PricingPolicy;

import java.math.BigDecimal;

public class CheckoutService {

    private final PricingPolicy pricingPolicy;
    private final Inventory inventory;
    private final PaymentProcessor paymentProcessor;
    private final Notifier notifier;

    public CheckoutService(
            PricingPolicy pricingPolicy,
            Inventory inventory,
            PaymentProcessor paymentProcessor,
            Notifier notifier
    ) {
        this.pricingPolicy = pricingPolicy;
        this.inventory = inventory;
        this.paymentProcessor = paymentProcessor;
        this.notifier = notifier;
    }

    public Receipt checkout(Cart cart, Customer customer) {

        // Total price?
        Money total = pricingPolicy.priceFor(cart, customer);

        // Boka produkter på lager
        for (CartItem ci : cart.items()) {
            if(!inventory.reserve(ci.productId(), ci.quantity())) {
                throw new IllegalStateException("Cannot reserve product " + ci.productId() + " " + ci.quantity());
            }
        }

        // Ta betalt via betalnings leverantör
        String paymentId = paymentProcessor.charge(customer.id(), total);

        // Skicka notifikation
        notifier.orderConfirmation(paymentId, customer);

        return  new Receipt(paymentId, total);
    }

}
