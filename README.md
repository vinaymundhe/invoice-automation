# Invoice Automation (Flygen)

This project automates the process of converting paid PayPal invoices into GST-compliant export invoice PDFs for accounting and CA submission.

## Problem

Currently, invoice processing involves:
- manually copying PayPal invoice data
- updating a Google Sheets template
- converting foreign currency to INR
- exporting PDFs
- storing invoices for GST filing

This is repetitive, error-prone, and time-consuming.

## Solution

This system automates the entire workflow:

1. Fetch paid PayPal invoices within a selected date range
2. Generate internal invoice numbers (FY-based)
3. Convert foreign currency (USD/GBP) to INR
4. Populate a Google Sheets export invoice template
5. Export invoices as PDF
6. Save PDFs locally / to Google Drive
7. Maintain a database to prevent duplicate processing

## Tech Stack

### Backend
- Spring Boot (Java 21)
- PostgreSQL
- JPA / Hibernate
- PayPal REST APIs
- Google Sheets API
- Google Drive API

### Frontend
- React (Vite)
- Axios

### Infrastructure
- Docker (PostgreSQL)

## Features (Planned)

- Date-range based invoice fetching
- Batch invoice processing
- GST-ready export invoice generation
- Financial year-based invoice numbering (April–March)
- FX rate integration for INR conversion
- Duplicate prevention using DB tracking
- PDF storage in structured folders

## Project Structure
invoice-automation/
backend/ # Spring Boot API
frontend/ # React UI
docker-compose.yml # PostgreSQL setup


## Status

🚧 In development  
Currently working on:
- Backend setup
- Database integration
- PayPal invoice fetching

## Future Scope

- Webhook-based real-time processing
- Multi-user SaaS version
- Dashboard for invoice tracking
- CA-friendly export reports

## Author

Vinay Mundhe  
Flygen Media
