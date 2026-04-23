package com.flygen.invoiceautomation.service;

import com.flygen.invoiceautomation.config.PaypalProperties;
import com.flygen.invoiceautomation.dto.paypal.PaypalInvoiceSearchResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
public class PaypalInvoiceService {

    private final PaypalAuthService paypalAuthService;
    private final WebClient webClient;

    public PaypalInvoiceService(PaypalAuthService paypalAuthService, PaypalProperties paypalProperties) {
        this.paypalAuthService = paypalAuthService;
        this.webClient = WebClient.builder()
                .baseUrl(paypalProperties.getBaseUrl())
                .build();
    }

    public PaypalInvoiceSearchResponse fetchInvoices(LocalDate fromDate, LocalDate toDate) {
        String accessToken = paypalAuthService.getAccessToken();

        String startDate = fromDate.atStartOfDay().atOffset(ZoneOffset.UTC).toString();
        String endDate = toDate.plusDays(1).atStartOfDay().atOffset(ZoneOffset.UTC).toString();

        String uri = "/v2/invoicing/invoices?page=1&page_size=100&total_required=true"
                + "&start_invoice_date=" + startDate
                + "&end_invoice_date=" + endDate;

        return webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(PaypalInvoiceSearchResponse.class)
                .block();
    }

    public String fetchInvoicesRaw(LocalDate fromDate, LocalDate toDate) {
        String accessToken = paypalAuthService.getAccessToken();

        String startDate = fromDate.atStartOfDay().atOffset(ZoneOffset.UTC).toString();
        String endDate = toDate.plusDays(1).atStartOfDay().atOffset(ZoneOffset.UTC).toString();

        String uri = "/v2/invoicing/invoices?page=1&page_size=100&total_required=true"
                + "&start_invoice_date=" + startDate
                + "&end_invoice_date=" + endDate;

        return webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}