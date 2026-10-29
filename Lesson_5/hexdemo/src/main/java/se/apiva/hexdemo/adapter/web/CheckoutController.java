package se.apiva.hexdemo.adapter.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.apiva.hexdemo.domain.model.*;
import se.apiva.hexdemo.domain.service.CheckoutService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    public final CheckoutService checkoutService;
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public ResponseEntity<Receipt> checkout(@Valid @RequestBody CheckoutRequest checkoutRequest){

        var cart = new Cart(
                checkoutRequest.items.stream().map(
                        i -> new CartItem(
                            new ProductId(i.productId),
                            new Money(i.unitPrice),
                            i.quantity
                        )
                ).toList()
        );

        var customer = new Customer(
            new CustomerId(checkoutRequest.customerId),
            checkoutRequest.email
        );

        return ResponseEntity.ok(checkoutService.checkout(cart, customer));
    }

    public static class CheckoutRequest {

        @NotBlank
        public String customerId;

        @Email @NotBlank
        public String email;

        @NotEmpty
        public List<Item> items;

        public static class Item {

            @NotBlank
            public String productId;

            @Positive
            public int quantity;

            @NotNull @DecimalMin("0.0")
            public BigDecimal unitPrice;

        }

    }


}
