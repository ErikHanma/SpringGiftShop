package ru.kors.giftstore.controller.rest;

import org.springframework.web.bind.annotation.*;
import ru.kors.giftstore.model.Cart;
import ru.kors.giftstore.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class ApiCartController {

    private final CartService cartService;

    public ApiCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        // Return cart from cartService
        return cartService.getCartById(id);
    }

    @PostMapping("/add/{productId}")
    public void addProduct(@PathVariable Long productId,
                           @RequestParam(defaultValue = "1") int quantity) {
        // Add product to cart using cartService
        cartService.addToCart(productId, quantity);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeProduct(@PathVariable Long cartItemId) {
        // Remove product from cart using cartService
        cartService.removeFromCart(cartItemId);
    }
}
