package se.apiva.hexdemo.adapter.pricing;

import se.apiva.hexdemo.domain.model.Cart;
import se.apiva.hexdemo.domain.model.CartItem;
import se.apiva.hexdemo.domain.model.Customer;
import se.apiva.hexdemo.domain.model.Money;
import se.apiva.hexdemo.domain.port.PricingPolicy;

public class SimplePricingPolicy implements PricingPolicy {

    @Override
    public Money priceFor(Cart cart, Customer customer) {
        Money subtotal = cart.items().stream()
                .map(CartItem::lineTotal)
                .reduce(Money.zero(), Money::add);
        Money vat = subtotal.multiply(0.25);
        Money beforeDiscount = subtotal.add(vat);
        boolean isVip = customer.email().endsWith("@vip.example");
        Money discount = isVip ? beforeDiscount.multiply(0.10) : Money.zero();
        return beforeDiscount.subtract(discount);
    }

}
