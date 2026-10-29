package se.apiva.hexdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.apiva.hexdemo.adapter.payment.FakePaymentProcessor;
import se.apiva.hexdemo.adapter.pricing.SimplePricingPolicy;
import se.apiva.hexdemo.domain.port.Inventory;
import se.apiva.hexdemo.domain.port.Notifier;
import se.apiva.hexdemo.domain.port.PaymentProcessor;
import se.apiva.hexdemo.domain.port.PricingPolicy;
import se.apiva.hexdemo.domain.service.CheckoutService;

@Configuration
public class BeanConfig {

    @Bean
    PricingPolicy pricingPolicy() {
        return new SimplePricingPolicy();
    }

    @Bean
    CheckoutService checkoutService(
        PricingPolicy pricingPolicy,
        Inventory inventory,
        PaymentProcessor paymentProcessor,
        Notifier notifier
    ) {
        return new CheckoutService(pricingPolicy, inventory, paymentProcessor, notifier);
    }

}
