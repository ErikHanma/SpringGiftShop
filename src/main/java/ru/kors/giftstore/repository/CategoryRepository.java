package ru.kors.giftstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.giftstore.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
