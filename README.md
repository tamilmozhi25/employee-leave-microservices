Employee Leave Management - Microservices Project

This project is a Spring Boot microservices-based Employee Leave Management System. It is designed to manage employee data and leave requests using REST APIs. The architecture includes two main microservices:

1. Employee Service ("employee-service")
2. Leave Service ("leave-service")


Technical stacks,

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security (In-Memory Authentication)
* Feign Client (for inter-service communication)
* MySQL
* Swagger UI (API documentation)


Microservices Overview

 1. Employee Service

- CRUD operations on employee data with MySQL
- REST API exposed via ("/api/employee")



 2. Leave Service

- Apply for leave
- Check leave status
- Fetch leave history
- Validates employee existence using Feign Client
- REST API exposed via ("/api/leave")



 Security

Basic In-Memory Authentication 
(leave-service): 
  Username:"root"
  Password:"root123"
(Employee-service):
  Username:"ttm"
  Password:"ttm123"

Inter-Service Communication

 Uses OpenFeign to call Employee Service from Leave Service.
 Example endpoint:  
  GET-  "http://localhost:8083/api/leave/employeeinfo/{employeeId}"  
  ( Checks employee info via Feign Client before applying leave )

Supports and Checks by - Postman

API Documentation

Swagger UI - enabled in both services:
  1 Employee Service: "http://localhost:8082/swagger-ui.html"
  2 Leave Service: "http://localhost:8083/swagger-ui.html"







  Author-https://github.com/tamilmozhi25

