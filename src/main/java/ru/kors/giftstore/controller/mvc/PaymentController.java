package ru.kors.giftstore.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kors.giftstore.service.PaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{orderId}")
    public String showPaymentForm(@PathVariable Long orderId, Model model) {
        // Get order from orderService
        //Model.addAttribute("order",orderService.getOrder(orderId))
        // Prepare model for payment form

        return "payments/form"; // Thymeleaf template name
    }

    @PostMapping("/{orderId}/process")
    public String processPayment(@PathVariable Long orderId,
                                  @RequestParam String paymentMethod,
                                  @RequestParam String cardNumber,
                                  @RequestParam String expiryDate,
                                  @RequestParam String cvv) {
        // Process payment using paymentService
        //PaymentService.processPayment(orderId, paymentMethod, cardNumber, expiryDate, cvv);
        return "redirect:/orders/" + orderId;
    }
}
