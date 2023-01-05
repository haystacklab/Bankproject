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
| Tech | Version |
| ------ | ------ |
| Java | 11.0.9 |
| Spring Boot | 2.7.7 |
| Spring Cloud | 2021.0.5 |
| Lombok | Resolved from Spring Boot Parent |
| Spring JPA | Resolved from Spring Boot Parent |
| Spring Cloud API gateway | Resolved from Spring Cloud |
| Spring cloud config | Resolved from Spring Cloud |
| Open Feign | Resolved from Spring Cloud |
| H2 database | Resolved from Spring Boot Parent |
| Spring web | Resolved from Spring Boot Parent |

> Another feature of Spring Boot is demonstrated here (automated dependency management) as the versions
> for all the dependencies are resolved from their parent artifacts and we do not have to manually maintain them.

# Application configuration
The ports configured to be used by each microservice:

| Service | Port |
| ------ | ------ |
| Config | 8888 |
| Gateway | 8000 |
| Account | 8001 |
| Checking | 8002 |
| Credit | 8003 |
| History | 8004 |

