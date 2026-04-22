package com.flygen.invoiceautomation;

import java.util.TimeZone;

import com.flygen.invoiceautomation.config.PaypalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PaypalProperties.class)
public class InvoiceAutomationApplication {

	public static void main(String[] args) {
		// PostgreSQL rejects the legacy "Asia/Calcutta" JVM timezone identifier.
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(InvoiceAutomationApplication.class, args);
	}

}
