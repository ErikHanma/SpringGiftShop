package ru.kors.giftstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // Аннотация Lombok для геттеров, сеттеров, equals, hashCode, toString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String imageUrl; // URL к изображению продукта
    // Добавьте другие соответствующие поля (категория, количество на складе и т. д.)
}
