package ru.kors.giftstore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CartItemDTO extends GenericDTO {
    private Long cartId; // ID корзины, к которой принадлежит элемент
    private Long productId; // ID товара
    private Integer quantity; // Количество товара
}
