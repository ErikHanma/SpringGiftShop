package ru.kors.giftstore.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends GenericDTO {
    private Long userId; // ID пользователя, сделавшего заказ
    private LocalDateTime orderDate; // Дата оформления заказа
    private String status; // Статус заказа (например, "В обработке", "Отправлен", "Доставлен")
    private List<Long> orderItemIds; // Список ID элементов заказа
}
