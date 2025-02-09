package ru.kors.giftstore.constants;

import java.util.List;

public interface SecurityConstants {
    List<String> RESOURCES_WHITE_LIST = List.of(
            "/resources/**",
            "/static/**",
            "/js/**",
            "/css/**",
            "/",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api/v1/auth/register",
            "/api/v1/auth/login"
    );

    List<String> PRODUCTS_WHITE_LIST = List.of(
            "/api/v1/products",
            "/api/v1/products/{id}",
            "/api/v1/products/search"
    );

    List<String> USERS_WHITE_LIST = List.of(
            "/api/v1/auth/login",
            "/api/v1/users/registration",
            "/api/v1/users/remember-password",
            "/api/v1/users/change-password"
    );

    List<String> ADMIN_PERMISSION_LIST = List.of(
            "/api/v1/products/**",
            "/api/v1/admin/**",
            "/api/v1/categories/**",
            "/api/v1/orders/**"
    );

    List<String> CUSTOMER_PERMISSION_LIST = List.of(
            "/api/v1/cart/**",
            "/api/v1/orders/my-orders"
    );
}
