package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
}
