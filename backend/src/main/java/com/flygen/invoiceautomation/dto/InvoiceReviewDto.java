package com.flygen.invoiceautomation.dto;

public class InvoiceReviewDto {

    private String paypalInvoiceId;
    private String paypalInvoiceNumber;
    private String status;

    public InvoiceReviewDto() {
    }

    public InvoiceReviewDto(String paypalInvoiceId, String paypalInvoiceNumber, String status) {
        this.paypalInvoiceId = paypalInvoiceId;
        this.paypalInvoiceNumber = paypalInvoiceNumber;
        this.status = status;
    }

    public String getPaypalInvoiceId() {
        return paypalInvoiceId;
    }

    public void setPaypalInvoiceId(String paypalInvoiceId) {
        this.paypalInvoiceId = paypalInvoiceId;
    }

    public String getPaypalInvoiceNumber() {
        return paypalInvoiceNumber;
    }

    public void setPaypalInvoiceNumber(String paypalInvoiceNumber) {
        this.paypalInvoiceNumber = paypalInvoiceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}