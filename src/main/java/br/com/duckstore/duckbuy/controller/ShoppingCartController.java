package br.com.duckstore.duckbuy.controller;

import br.com.duckstore.duckbuy.domain.request.CartItemRequest;
import br.com.duckstore.duckbuy.domain.response.CartItemResponse;
import br.com.duckstore.duckbuy.domain.response.ShoppingCartResponse;
import br.com.duckstore.duckbuy.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemResponse> addItem(@PathVariable Long cartId, @RequestBody CartItemRequest itemRequest) {
        return ResponseEntity.ok(shoppingCartService.addItem(cartId, itemRequest));
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<?> removeItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        shoppingCartService.removeItem(cartId, itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<Set<CartItemResponse>> getItems(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.getItems(cartId));
    }
}