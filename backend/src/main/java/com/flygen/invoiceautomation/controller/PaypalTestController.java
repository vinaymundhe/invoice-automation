package com.flygen.invoiceautomation.controller;

import com.flygen.invoiceautomation.service.PaypalAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaypalTestController {

    private final PaypalAuthService paypalAuthService;

    public PaypalTestController(PaypalAuthService paypalAuthService) {
        this.paypalAuthService = paypalAuthService;
    }

    @GetMapping("/api/paypal/token-test")
    public String tokenTest() {
        String token = paypalAuthService.getAccessToken();
        return token != null && !token.isBlank() ? "PayPal token fetched successfully" : "Token fetch failed";
    }
}