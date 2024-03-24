package br.com.duckstore.duckbuy.repository;

import br.com.duckstore.duckbuy.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}