**Currency Exchange API**
Overview
The Currency Exchange API is designed to provide two primary services:

Currency Exchange: Returns the exchange rate between two currencies.
Currency Conversion: Converts a specified amount from one currency to another by using the exchange rate provided by the Currency Exchange service.
The API architecture includes a Service Registry, API Gateway, and Rate Limiting to ensure efficient service discovery, secure API routing, and controlled access.

**Features**
Currency Exchange: Returns the exchange rate between the specified currencies.
Currency Conversion: Converts a specified amount from one currency to another using the exchange rate fetched from the Currency Exchange service via a Feign client.
Service Registry: Registers the Currency Exchange and Currency Conversion services for easy discovery and load balancing.
API Gateway: Acts as a single entry point for all API requests, handling routing, security, and traffic management.
Rate Limiting: Controls the number of requests a client can make to the API within a specified time frame to prevent abuse and ensure fair usage.
Getting Started

**Prerequisites**
Java 8+: The API is developed using Java. Ensure you have the correct version installed.
Spring Boot: Used for building and running the application.
Maven: For managing dependencies and building the project.
Eureka: Used as the service registry.
Zuul/Spring Cloud Gateway: Used for the API Gateway.
