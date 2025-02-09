package ru.kors.giftstore.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kors.giftstore.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String listOrders(Model model) {
        // Get all orders from orderService
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list"; // Thymeleaf template name
    }

    @GetMapping("/{id}")
    public String viewOrder(@PathVariable Long id, Model model) {
        // Get order by id from orderService
        model.addAttribute("order", orderService.getOrderById(id));
        return "orders/view"; // Thymeleaf template name
    }

    @PostMapping("/{id}/ship")
    public String shipOrder(@PathVariable Long id) {
        // Mark order as shipped using orderService
        orderService.shipOrder(id);
        return "redirect:/orders";
    }
    //Implement delete method, implement create method
}
