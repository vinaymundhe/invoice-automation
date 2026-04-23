package com.flygen.invoiceautomation.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceReviewDto {

    private String paypalInvoiceId;
    private String paypalInvoiceNumber;
    private String clientEmail;
    private String currencyCode;
    private BigDecimal foreignAmount;
    private LocalDate invoiceDate;
    private String status;
    private boolean alreadyProcessed;

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

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getForeignAmount() {
        return foreignAmount;
    }

    public void setForeignAmount(BigDecimal foreignAmount) {
        this.foreignAmount = foreignAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAlreadyProcessed() {
        return alreadyProcessed;
    }

    public void setAlreadyProcessed(boolean alreadyProcessed) {
        this.alreadyProcessed = alreadyProcessed;
    }
}