package br.com.duckstore.duckbuy.domain.request;

import java.util.Set;

public record ShoppingCartRequest(Set<CartItemRequest> items) {}