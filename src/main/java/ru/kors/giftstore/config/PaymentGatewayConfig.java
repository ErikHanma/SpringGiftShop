package ru.kors.giftstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayConfig {

    @Value("${payment.gateway.url}")
    private String paymentGatewayUrl;

    @Value("${payment.gateway.api.key}")
    private String paymentGatewayApiKey;

    public String getPaymentGatewayUrl() {
        return paymentGatewayUrl;
    }

    public void setPaymentGatewayUrl(String paymentGatewayUrl) {
        this.paymentGatewayUrl = paymentGatewayUrl;
    }

    public String getPaymentGatewayApiKey() {
        return paymentGatewayApiKey;
    }

    public void setPaymentGatewayApiKey(String paymentGatewayApiKey) {
        this.paymentGatewayApiKey = paymentGatewayApiKey;
    }
}
