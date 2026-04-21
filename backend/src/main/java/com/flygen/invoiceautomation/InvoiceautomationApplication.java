package com.flygen.invoiceautomation;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiceautomationApplication {

	public static void main(String[] args) {
		// PostgreSQL rejects the legacy "Asia/Calcutta" JVM timezone identifier.
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
		SpringApplication.run(InvoiceautomationApplication.class, args);
	}

}
