package br.com.duckstore.duckbuy.domain.repository;

import br.com.duckstore.duckbuy.domain.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}