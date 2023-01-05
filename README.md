# Bank Project

This project explores the capabilities of the CompletableFuture in Java specifically in Spring Boot.

The below image is an architecture of the application showing the flow of data and the asynchronous API calls that happen in between them.

![architecture](https://github.com/haystacklab/Bankproject/blob/dev/resources/bank-project.jpg "Bank project architecture")

## Services
There are three services used in the project which are microservices. They are:
Account service (entrypoint)
Checking Account service
Credit Account service
History service

## Flow
As the image suggests, the customer requests for the details of the account. The account service asynchronously calls checking and credit services to fetch customer's checking and credit accounts.

## Tech
Spring Boot - 2.7.7
Java - 11.0.9
Lombok
Spring JPA
Spring Cloud API gateway
Spring cloud config
Open Feign
H2 database
Spring web

# Config
port 8888

# Gateway
port 8000

# Account
port 8001

# Checking
port 8002

# Credit
port 8003

# History
port 8004

