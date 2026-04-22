package com.flygen.invoiceautomation.dto.paypal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalInvoiceSearchResponse {

    @JsonProperty("items")
    private List<PaypalInvoiceSearchItem> items;

    public List<PaypalInvoiceSearchItem> getItems() {
        return items;
    }

    public void setItems(List<PaypalInvoiceSearchItem> items) {
        this.items = items;
    }
}