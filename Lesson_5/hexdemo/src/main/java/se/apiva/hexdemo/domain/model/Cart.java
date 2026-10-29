package se.apiva.hexdemo.domain.model;

import java.util.List;

public record Cart(List<CartItem> items) {
}
