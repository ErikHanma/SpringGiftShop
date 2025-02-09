package ru.kors.giftstore.controller.rest;

import org.springframework.web.bind.annotation.*;
import ru.kors.giftstore.model.Order;
import ru.kors.giftstore.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class ApiOrderController {

    private final OrderService orderService;

    public ApiOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        // Return all orders from orderService
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        // Return order from orderService
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Create order using orderService
        return orderService.createOrder(order);
    }
}
