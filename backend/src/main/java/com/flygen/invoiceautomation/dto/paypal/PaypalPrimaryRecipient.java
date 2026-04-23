package com.flygen.invoiceautomation.dto.paypal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaypalPrimaryRecipient {

    @JsonProperty("billing_info")
    private PaypalBillingInfo billingInfo;

    public PaypalBillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(PaypalBillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }
}