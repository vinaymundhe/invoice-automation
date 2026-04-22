package com.flygen.invoiceautomation.controller;

import com.flygen.invoiceautomation.dto.InvoiceFetchRequest;
import com.flygen.invoiceautomation.dto.paypal.PaypalInvoiceSearchResponse;
import com.flygen.invoiceautomation.service.PaypalInvoiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final PaypalInvoiceService paypalInvoiceService;

    public InvoiceController(PaypalInvoiceService paypalInvoiceService) {
        this.paypalInvoiceService = paypalInvoiceService;
    }

    @PostMapping("/fetch")
    public PaypalInvoiceSearchResponse fetchInvoices(@RequestBody @Valid InvoiceFetchRequest request) {
        return paypalInvoiceService.fetchInvoices(request.getFromDate(), request.getToDate());
    }

    @PostMapping("/fetch2")
    public PaypalInvoiceSearchResponse fetchInvoicesWithoutDateFilter() {
        return paypalInvoiceService.fetchInvoicesWithoutDateFilter();
    }

    @PostMapping("/fetch-raw")
    public String fetchInvoicesRaw(@RequestBody @Valid InvoiceFetchRequest request) {
        return paypalInvoiceService.fetchInvoicesRaw(request.getFromDate(), request.getToDate());
    }
}