package ru.kors.giftstore.service;

import org.springframework.stereotype.Service;
import ru.kors.giftstore.model.Order;
import ru.kors.giftstore.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null); // Handle not found
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            updatedOrder.setId(id); // Ensure ID is set for update
            return orderRepository.save(updatedOrder);
        }
        return null; // Or throw an exception if order not found
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void shipOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus("Shipped"); // Replace with enum or constant
            orderRepository.save(order);
        }
        // You might want to throw an exception if the order is not found
    }
}
