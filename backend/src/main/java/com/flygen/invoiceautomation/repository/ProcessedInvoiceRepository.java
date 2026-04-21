package com.flygen.invoiceautomation.repository;

import com.flygen.invoiceautomation.entity.ProcessedInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedInvoiceRepository extends JpaRepository<ProcessedInvoice, Long> {
    boolean existsByPaypalInvoiceId(String paypalInvoiceId);
}