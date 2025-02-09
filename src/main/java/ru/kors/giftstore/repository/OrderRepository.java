package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
