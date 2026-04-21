package com.flygen.invoiceautomation.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "processed_invoice")
public class ProcessedInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paypal_invoice_id", nullable = false, unique = true)
    private String paypalInvoiceId;

    public ProcessedInvoice() {
    }

    public Long getId() {
        return id;
    }

    public String getPaypalInvoiceId() {
        return paypalInvoiceId;
    }

    public void setPaypalInvoiceId(String paypalInvoiceId) {
        this.paypalInvoiceId = paypalInvoiceId;
    }
}