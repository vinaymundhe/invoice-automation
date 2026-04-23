package com.flygen.invoiceautomation.controller;

import com.flygen.invoiceautomation.dto.InvoiceFetchRequest;
import com.flygen.invoiceautomation.dto.InvoiceReviewDto;
import com.flygen.invoiceautomation.service.InvoiceProcessingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceProcessingService invoiceProcessingService;

    public InvoiceController(InvoiceProcessingService invoiceProcessingService) {
        this.invoiceProcessingService = invoiceProcessingService;
    }

    @PostMapping("/fetch")
    public List<InvoiceReviewDto> fetchInvoices(@RequestBody @Valid InvoiceFetchRequest request) {
        return invoiceProcessingService.fetchInvoicesForReview(request);
    }
}