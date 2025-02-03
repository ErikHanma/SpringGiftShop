package ru.kors.giftstore.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.kors.giftstore.dto.AddToCategoryDTO;
import ru.kors.giftstore.dto.ProductDTO;
import ru.kors.giftstore.exception.MyDeleteException;
import ru.kors.giftstore.mapper.ProductMapper;

import ru.kors.giftstore.model.Product;
import ru.kors.giftstore.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest extends GenericTest<Product, ProductDTO> {

    public ProductServiceTest() {
        super();
        repository = Mockito.mock(ProductRepository.class);
        mapper = Mockito.mock(ProductMapper.class);
        service = new ProductService((ProductRepository) repository, (ProductMapper) mapper);

        ProductTestData.PRODUCT_1.setDeleted(false);
        ProductTestData.PRODUCT_2.setDeleted(false);
        ProductTestData.PRODUCT_3.setDeleted(false);
    }

    @Test
    @Order(1)
    public void getAll() {
        Mockito.when(repository.findAll()).thenReturn(ProductTestData.PRODUCT_LIST);
        Mockito.when(mapper.toDTOs(ProductTestData.PRODUCT_LIST)).thenReturn(ProductTestData.PRODUCT_DTO_LIST);

        List<ProductDTO> productDTOS = service.listAll();
        log.info("Testing getAll(): " + productDTOS);
        assertEquals(ProductTestData.PRODUCT_LIST.size(), productDTOS.size());
    }

    @Test
    @Order(2)
    public void getOne() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(ProductTestData.PRODUCT_1));
        Mockito.when(mapper.toDTO(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_DTO_1);

        ProductDTO productDTO = service.getOne(1L);
        log.info("Testing getOne(): " + productDTO);
        assertSame(ProductTestData.PRODUCT_DTO_1, productDTO);
    }

    @Order(3)
    @Test
    protected void create() {
        Mockito.when(mapper.toEntity(ProductTestData.PRODUCT_DTO_1)).thenReturn(ProductTestData.PRODUCT_1);
        Mockito.when(mapper.toDTO(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        Mockito.when(repository.save(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_1);

        ProductDTO productDTO = service.create(ProductTestData.PRODUCT_DTO_1);
        System.out.println("Testing create(): " + productDTO);
    }

    @Order(4)
    @Test
    protected void update() {
        Mockito.when(mapper.toEntity(ProductTestData.PRODUCT_DTO_1)).thenReturn(ProductTestData.PRODUCT_1);
        Mockito.when(mapper.toDTO(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        Mockito.when(repository.save(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_1);

        ProductDTO productDTO = service.update(ProductTestData.PRODUCT_DTO_1);
        System.out.println("Testing update(): " + productDTO);
    }

    @Order(5)
    @Test
    protected void delete() throws MyDeleteException {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(ProductTestData.PRODUCT_1));

        service.deleteSoft(1L);
        assertTrue(ProductTestData.PRODUCT_1.isDeleted());
    }

    @Test
    @Override
    protected void restore() {
        ProductTestData.PRODUCT_3.setDeleted(true);

        Mockito.when(repository.save(ProductTestData.PRODUCT_3)).thenReturn(ProductTestData.PRODUCT_3);
        Mockito.when(repository.findById(3L)).thenReturn(Optional.of(ProductTestData.PRODUCT_3));

        System.out.println("Tested restore() before: " + ProductTestData.PRODUCT_3.isDeleted());
        service.restore(3L);
        System.out.println("Tested restore() after: " + ProductTestData.PRODUCT_3.isDeleted());

        assertFalse(ProductTestData.PRODUCT_3.isDeleted());
    }

    @Test
    @Override
    protected void getAllNotDeleted() {
        List<Product> products = ProductTestData.PRODUCT_LIST.stream()
                .filter(Predicate.not(Product::isDeleted))
                .toList();

        Mockito.when(repository.findAllByIsDeletedFalse()).thenReturn(products);
        Mockito.when(mapper.toDTOs(products))
                .thenReturn(ProductTestData.PRODUCT_DTO_LIST.stream()
                        .filter(Predicate.not(ProductDTO::isDeleted))
                        .toList());

        List<ProductDTO> productDTOS = service.listAllNotDeleted();
        System.out.println("Testing getAllNotDeleted(): " + productDTOS);
        assertEquals(products.size(), productDTOS.size());
    }

    @Test
    protected void searchProducts() {
        PageRequest pageRequest = PageRequest.of(1, 10, Sort.by(Sort.Direction.ASC, "name"));

        Mockito.when(((ProductRepository) repository)
                        .findAllByNameContainsIgnoreCaseAndIsDeletedFalse("constructor", pageRequest))
                .thenReturn(new PageImpl<>(ProductTestData.PRODUCT_LIST));

        Mockito.when(mapper.toDTOs(ProductTestData.PRODUCT_LIST))
                .thenReturn(ProductTestData.PRODUCT_DTO_LIST);

        Page<ProductDTO> productDTOPage = ((ProductService) service)
                .searchProducts("constructor", pageRequest);

        assertEquals(ProductTestData.PRODUCT_DTO_LIST, productDTOPage.getContent());
    }

    @Test
    void addToCategory() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(ProductTestData.PRODUCT_1));
        Mockito.when(service.getOne(1L)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        Mockito.when(repository.save(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_1);

        ((ProductService) service).addToCategory(new AddToCategoryDTO(1L, 1L));
        log.info("Testing addToCategory(): " + ProductTestData.PRODUCT_DTO_1.getCategoryIds());
        assertTrue(ProductTestData.PRODUCT_DTO_1.getCategoryIds().size() >= 1);
    }
}