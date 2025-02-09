package ru.kors.giftstore.service;

import org.springframework.stereotype.Service;
import ru.kors.giftstore.model.Product;
import ru.kors.giftstore.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null); // Handle null case properly
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            updatedProduct.setId(id); // Ensure the ID is set for updating
            return productRepository.save(updatedProduct);
        } else {
            return null; // Product not found
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
