package br.com.duckstore.duckbuy.service;

import br.com.duckstore.duckbuy.domain.entity.CartItem;
import br.com.duckstore.duckbuy.domain.entity.ShoppingCart;
import br.com.duckstore.duckbuy.domain.request.CartItemRequest;
import br.com.duckstore.duckbuy.domain.response.CartItemResponse;
import br.com.duckstore.duckbuy.domain.repository.CartItemRepository;
import br.com.duckstore.duckbuy.domain.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final RestTemplate restTemplate;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository, RestTemplate restTemplate) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.cartItemRepository = cartItemRepository;
        this.restTemplate = restTemplate;
    }


    public CartItemResponse addItemToCart(Long cartId, CartItemRequest cartItemRequest) {

        ShoppingCart cart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        CartItem item = new CartItem(null, cartItemRequest.itemId(), cartItemRequest.quantity());
        item.setShoppingCart(cart);

        cart.getItems().add(item);

        shoppingCartRepository.save(cart);

        return new CartItemResponse(item.getId(), item.getItemId(), item.getQuantity());
    }


    public CartItemResponse addItem(Long cartId, CartItemRequest itemRequest) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartItem item = new CartItem(null, itemRequest.itemId(), itemRequest.quantity());
        item.setShoppingCart(cart);
        cart.getItems().add(item);
        cartItemRepository.save(item);
        shoppingCartRepository.save(cart);
        return new CartItemResponse(item.getId(), item.getItemId(), item.getQuantity());
    }

    public void removeItem(Long cartId, Long itemId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().removeIf(item -> item.getId().equals(itemId));
        shoppingCartRepository.save(cart);
    }

    public Set<CartItemResponse> getItems(Long cartId) {
        ShoppingCart cart = shoppingCartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getItems().stream()
                .map(item -> new CartItemResponse(item.getId(), item.getItemId(), item.getQuantity()))
                .collect(Collectors.toSet());
    }
}