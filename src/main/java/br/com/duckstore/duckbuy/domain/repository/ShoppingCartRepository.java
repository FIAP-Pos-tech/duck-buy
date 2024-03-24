package br.com.duckstore.duckbuy.domain.repository;


import br.com.duckstore.duckbuy.domain.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
