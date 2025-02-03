package ru.kors.giftstore.service;

import ru.kors.giftstore.dto.ProductDTO;
import ru.kors.giftstore.model.Category;
import ru.kors.giftstore.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface ProductTestData {
    ProductDTO PRODUCT_DTO_1 = new ProductDTO(
            "Детский конструктор",
            BigDecimal.valueOf(1999.99),
            "Отличный развивающий конструктор",
            Collections.singletonList(1L),
            new byte[0],
            false
    );

    ProductDTO PRODUCT_DTO_2 = new ProductDTO(
            "Кукла Барби",
            BigDecimal.valueOf(1499.99),
            "Классическая кукла",
            Collections.singletonList(2L),
            new byte[0],
            false
    );

    ProductDTO PRODUCT_DTO_3_DELETED = new ProductDTO(
            "Мягкая игрушка",
            BigDecimal.valueOf(899.99),
            "Плюшевый медведь",
            Collections.singletonList(3L),
            new byte[0],
            true
    );

    List<ProductDTO> PRODUCT_DTO_LIST = Arrays.asList(
            PRODUCT_DTO_1,
            PRODUCT_DTO_2,
            PRODUCT_DTO_3_DELETED
    );

    Product PRODUCT_1 = new Product(
            "Детский конструктор",
            BigDecimal.valueOf(1999.99),
            "Отличный развивающий конструктор",
            new Category("Конструкторы"),
            new byte[0],
            false
    );

    Product PRODUCT_2 = new Product(
            "Кукла Барби",
            BigDecimal.valueOf(1499.99),
            "Классическая кукла",
            new Category("Куклы"),
            new byte[0],
            false
    );

    Product PRODUCT_3 = new Product(
            "Мягкая игрушка",
            BigDecimal.valueOf(899.99),
            "Плюшевый медведь",
            new Category("Мягкие игрушки"),
            new byte[0],
            true
    );

    List<Product> PRODUCT_LIST = Arrays.asList(PRODUCT_1, PRODUCT_2, PRODUCT_3);
}