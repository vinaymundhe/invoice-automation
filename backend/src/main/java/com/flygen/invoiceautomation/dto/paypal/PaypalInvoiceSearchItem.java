package com.flygen.invoiceautomation.dto.paypal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalInvoiceSearchItem {

    private String id;
    private String status;

    @JsonProperty("detail")
    private PaypalInvoiceDetail detail;

    @JsonProperty("primary_recipients")
    private List<PaypalPrimaryRecipient> primaryRecipients;

    private PaypalAmount amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaypalInvoiceDetail getDetail() {
        return detail;
    }

    public void setDetail(PaypalInvoiceDetail detail) {
        this.detail = detail;
    }

    public List<PaypalPrimaryRecipient> getPrimaryRecipients() {
        return primaryRecipients;
    }

    public void setPrimaryRecipients(List<PaypalPrimaryRecipient> primaryRecipients) {
        this.primaryRecipients = primaryRecipients;
    }

    public PaypalAmount getAmount() {
        return amount;
    }

    public void setAmount(PaypalAmount amount) {
        this.amount = amount;
    }
}