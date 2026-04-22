package com.flygen.invoiceautomation.service;

import com.flygen.invoiceautomation.config.PaypalProperties;
import com.flygen.invoiceautomation.dto.paypal.PaypalAccessTokenResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Service
public class PaypalAuthService {

    private final WebClient webClient;
    private final PaypalProperties paypalProperties;

    private String cachedAccessToken;
    private Instant tokenExpiryTime;

    public PaypalAuthService(PaypalProperties paypalProperties) {
        this.paypalProperties = paypalProperties;
        this.webClient = WebClient.builder()
                .baseUrl(paypalProperties.getBaseUrl())
                .build();
    }

    public synchronized String getAccessToken() {
        if (paypalProperties.getBaseUrl().contains("{") || paypalProperties.getBaseUrl().contains("}")) {
            throw new IllegalStateException("paypal.base-url is unresolved. Set PAYPAL_BASE_URL in your environment.");
        }

        if (cachedAccessToken != null && tokenExpiryTime != null && Instant.now().isBefore(tokenExpiryTime)) {
            return cachedAccessToken;
        }

        String basicAuth = Base64.getEncoder().encodeToString(
                (paypalProperties.getClientId() + ":" + paypalProperties.getClientSecret())
                        .getBytes(StandardCharsets.UTF_8)
        );

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");

        PaypalAccessTokenResponse response = webClient.post()
                .uri("/v1/oauth2/token")
                .header(HttpHeaders.AUTHORIZATION, "Basic " + basicAuth)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT_LANGUAGE, "en_US")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(formData)
                .retrieve()
                .bodyToMono(PaypalAccessTokenResponse.class)
                .block();

        if (response == null || response.getAccessToken() == null) {
            throw new IllegalStateException("Failed to fetch PayPal access token");
        }

        this.cachedAccessToken = response.getAccessToken();
        this.tokenExpiryTime = Instant.now().plusSeconds(response.getExpiresIn() - 60);

        return cachedAccessToken;
    }
}
