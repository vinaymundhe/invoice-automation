package com.flygen.invoiceautomation.dto.paypal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalInvoiceSearchItem {

    private String id;

    @JsonProperty("detail")
    private PaypalInvoiceDetail detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaypalInvoiceDetail getDetail() {
        return detail;
    }

    public void setDetail(PaypalInvoiceDetail detail) {
        this.detail = detail;
    }
}