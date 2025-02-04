package ru.kors.giftstore.controller.mvc;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.kors.giftstore.dto.ProductDTO;
import ru.kors.giftstore.service.ProductService;
import ru.kors.giftstore.dto.CategoryDTO;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@Transactional
@Rollback(value = false)
public class MVCProductControllerTest extends CommonTestMVC {

    @Autowired
    private ProductService productService;

    private final ProductDTO testProduct = new ProductDTO(
            "Детский конструктор",
            1999.99,
            "Описание конструктора",
            CategoryDTO.TOYS,
            new byte[0],
            false
    );

    private final ProductDTO updatedProduct = new ProductDTO(
            "Обновленный конструктор",
            2499.99,
            "Новое описание",
            CategoryDTO.TOYS,
            new byte[0],
            false
    );

    @Override
    @Test
    @DisplayName("Просмотр списка продуктов")
    @Order(0)
    @WithAnonymousUser
    protected void listAll() throws Exception {
        mvc.perform(get("/products")
                        .param("page", "1")
                        .param("size", "5"))
                .andExpect(status().isOk())
                .andExpect(view().name("products/list"))
                .andExpect(model().attributeExists("products"));
    }

    @Override
    @Test
    @Order(1)
    @DisplayName("Создание продукта")
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin")
    void testCreateProduct() throws Exception {
        mvc.perform(post("/products/add")
                        .flashAttr("productForm", testProduct))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));
    }

    @Override
    protected void createProduct() throws Exception {

    }

    @Test
    @Order(2)
    @DisplayName("Обновление продукта")
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin")
    void updateProduct() throws Exception {
        ProductDTO existingProduct = productService.getAll(PageRequest.of(0, 5))
                .getContent()
                .stream()
                .filter(p -> p.getName().equals(testProduct.getName()))
                .findFirst()
                .orElseThrow();

        mvc.perform(post("/products/update/{id}", existingProduct.getId())
                        .flashAttr("productForm", updatedProduct))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));
    }

    @Override
    @Test
    @Order(3)
    @DisplayName("Удаление продукта")
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin")
    protected void deleteProduct() throws Exception {
        ProductDTO productToDelete = productService.getAll(PageRequest.of(0, 5))
                .getContent()
                .get(0);

        mvc.perform(get("/products/delete/{id}", productToDelete.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));

        assertTrue(productService.getById(productToDelete.getId()).isDeleted());
    }
}