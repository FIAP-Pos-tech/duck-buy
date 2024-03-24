package br.com.duckstore.duckbuy.repository;


import br.com.duckstore.duckbuy.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
