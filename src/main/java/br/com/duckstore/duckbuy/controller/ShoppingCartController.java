package br.com.duckstore.duckbuy.controller;

import br.com.duckstore.duckbuy.domain.CartItem;
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
    public ResponseEntity<CartItem> addItem(@PathVariable Long cartId, @RequestBody CartItem item) {
        return ResponseEntity.ok(shoppingCartService.addItem(cartId, item));
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Void> removeItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        shoppingCartService.removeItem(cartId, itemId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<Set<CartItem>> getItems(@PathVariable Long cartId) {
        return ResponseEntity.ok(shoppingCartService.getItems(cartId));
    }
}