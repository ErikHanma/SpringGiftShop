package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
