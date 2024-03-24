package br.com.duckstore.duckbuy.service;

import br.com.duckstore.duckbuy.domain.CartItem;
import br.com.duckstore.duckbuy.domain.ShoppingCart;
import br.com.duckstore.duckbuy.repository.CartItemRepository;
import br.com.duckstore.duckbuy.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addItem(Long cartId, CartItem item) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        item.setShoppingCart(cart);
        cart.getItems().add(item);
        cartItemRepository.save(item);
        shoppingCartRepository.save(cart);
        return item;
    }

    public ShoppingCart removeItem(Long cartId, Long itemId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().removeIf(item -> item.getId().equals(itemId));
        return shoppingCartRepository.save(cart);
    }

    public Set<CartItem> getItems(Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getItems();
    }
}