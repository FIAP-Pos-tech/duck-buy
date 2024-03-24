package br.com.duckstore.duckbuy.domain.response;

import java.util.Set;

public record ShoppingCartResponse(Long id, Set<CartItemResponse> items) {}