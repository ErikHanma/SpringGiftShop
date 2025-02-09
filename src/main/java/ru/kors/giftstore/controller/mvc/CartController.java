package ru.kors.giftstore.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kors.giftstore.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        // Get cart items from cartService
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart"; // Thymeleaf template name
    }

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId,
                            @RequestParam(defaultValue = "1") int quantity) {
        // Add product to cart using cartService
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{cartItemId}")
    public String removeFromCart(@PathVariable Long cartItemId) {
        // Remove item from cart using cartService
        cartService.removeFromCart(cartItemId);
        return "redirect:/cart";
    }

    // Implement update cart item quantity endpoint

}
