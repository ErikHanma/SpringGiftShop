package ru.kors.giftstore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends GenericDTO {
    private String title; // Название категории
    private String description; // Описание категории
}
