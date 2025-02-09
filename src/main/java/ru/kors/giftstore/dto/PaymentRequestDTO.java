package ru.kors.giftstore.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Long orderId; // ID заказа, за который производится оплата
    private String paymentMethod; // Способ оплаты (например, "Карта", "PayPal")
    private String cardNumber; // Номер карты
    private String expiryDate; // Срок действия карты
    private String cvv; // CVV код
}
