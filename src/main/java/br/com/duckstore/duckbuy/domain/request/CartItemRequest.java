package br.com.duckstore.duckbuy.domain.request;

public record CartItemRequest(Long itemId, int quantity) {}