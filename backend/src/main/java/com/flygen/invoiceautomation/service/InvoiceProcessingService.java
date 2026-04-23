package com.flygen.invoiceautomation.service;

import com.flygen.invoiceautomation.dto.InvoiceFetchRequest;
import com.flygen.invoiceautomation.dto.InvoiceReviewDto;
import com.flygen.invoiceautomation.dto.paypal.PaypalInvoiceSearchItem;
import com.flygen.invoiceautomation.dto.paypal.PaypalInvoiceSearchResponse;
import com.flygen.invoiceautomation.repository.ProcessedInvoiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceProcessingService {

    private final PaypalInvoiceService paypalInvoiceService;
    private final ProcessedInvoiceRepository processedInvoiceRepository;

    public InvoiceProcessingService(PaypalInvoiceService paypalInvoiceService,
                                    ProcessedInvoiceRepository processedInvoiceRepository) {
        this.paypalInvoiceService = paypalInvoiceService;
        this.processedInvoiceRepository = processedInvoiceRepository;
    }

    public List<InvoiceReviewDto> fetchInvoicesForReview(InvoiceFetchRequest request) {
        PaypalInvoiceSearchResponse response =
                paypalInvoiceService.fetchInvoices(request.getFromDate(), request.getToDate());

        if (response == null || response.getItems() == null || response.getItems().isEmpty()) {
            return Collections.emptyList();
        }

        return response.getItems().stream()
                .filter(this::isPaidInvoice)
                .map(this::mapToReviewDto)
                .collect(Collectors.toList());
    }

    private boolean isPaidInvoice(PaypalInvoiceSearchItem item) {
        String status = item.getStatus();
        return "MARKED_AS_PAID".equals(status) || "PAID".equals(status);
    }

    private InvoiceReviewDto mapToReviewDto(PaypalInvoiceSearchItem item) {
        InvoiceReviewDto dto = new InvoiceReviewDto();

        dto.setPaypalInvoiceId(item.getId());
        dto.setStatus(item.getStatus());

        if (item.getDetail() != null) {
            dto.setPaypalInvoiceNumber(item.getDetail().getInvoiceNumber());

            if (item.getDetail().getInvoiceDate() != null) {
                dto.setInvoiceDate(LocalDate.parse(item.getDetail().getInvoiceDate()));
            }
        }

        if (item.getAmount() != null) {
            dto.setCurrencyCode(item.getAmount().getCurrencyCode());

            if (item.getAmount().getValue() != null) {
                dto.setForeignAmount(new BigDecimal(item.getAmount().getValue()));
            }
        }

        if (item.getPrimaryRecipients() != null
                && !item.getPrimaryRecipients().isEmpty()
                && item.getPrimaryRecipients().get(0).getBillingInfo() != null) {
            dto.setClientEmail(item.getPrimaryRecipients().get(0).getBillingInfo().getEmailAddress());
        }

        dto.setAlreadyProcessed(processedInvoiceRepository.existsByPaypalInvoiceId(item.getId()));

        return dto;
    }
}