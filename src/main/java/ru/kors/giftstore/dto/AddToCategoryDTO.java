package ru.kors.giftstore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO для добавления товара в категорию.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для добавления товара в категорию")
public class AddToCategoryDTO {

    @Schema(description = "ID товара", example = "1")
    private Long productId;  // ID товара, который нужно добавить в категорию

    @Schema(description = "ID категории", example = "2")
    private Long categoryId; // ID категории, в которую добавляется товар
}