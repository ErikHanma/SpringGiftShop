package ru.kors.giftstore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CartDTO extends GenericDTO {
    private Long userId; // ID пользователя, которому принадлежит корзина
    private List<Long> cartItemIds; // Список ID товаров в корзине
}
