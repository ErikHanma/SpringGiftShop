package ru.kors.giftstore.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kors.giftstore.model.Category;
import ru.kors.giftstore.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listCategories(Model model) {
        // Get categories from categoryService
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories/list"; // Thymeleaf template name
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        // Add empty category to model for form binding
        model.addAttribute("category", new Category()); // Replace Category with your actual category model
        return "categories/create"; // Thymeleaf template name
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category) { // Replace Category with your actual category model
        // Save category using categoryService
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Get category by id from categoryService
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "categories/edit"; // Thymeleaf template name
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute Category category) { // Replace Category with your actual category model
        // Update category using categoryService
        categoryService.updateCategory(id, category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        // Delete category using categoryService
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
