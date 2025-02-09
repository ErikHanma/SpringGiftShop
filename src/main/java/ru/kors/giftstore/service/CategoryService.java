package ru.kors.giftstore.service;

import org.springframework.stereotype.Service;
import ru.kors.giftstore.model.Category;
import ru.kors.giftstore.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null); // Handle not found
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            updatedCategory.setId(id); // Ensure ID is set for update
            return categoryRepository.save(updatedCategory);
        }
        return null; // Or throw an exception if category not found
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
