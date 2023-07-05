# Backend-SpringBoot-LikeMeApp

[![Java CI](https://github.com/andrei-punko/articles-backend-app/actions/workflows/maven.yml/badge.svg)](https://github.com/andrei-punko/articles-backend-app/actions/workflows/maven.yml)

This should be purely a REST endpoints backend application with Swagger UI.

_Build tool_: Maven

_DB_: MYSQL

_Source Control:_ Git Hub (public)

_Application name:_ Backend SpringBoot LikeMeApp

Application must be implemented using Spring Data (JPA/Hibernate) layer for communication with DB.

SQL queries should not be used, JPA Repositories and Entities should be used instead.

## Swagger UI
<img width="1339" alt="Screenshot 2023-07-05 at 11 14 43 PM" src="https://github.com/Dheeraj-01/Backend-SpringBoot-LikeMeApp/assets/54698983/7907ac4a-19ac-47b0-b44a-45bdf3a29e11">


## Prerequisites
- Maven 3
- JDK 11

## Build instructions

#### Build application:
    mvn clean install

#### Build Docker image with application inside:
    docker build -t likemeapi .

## How to start application

#### Start application using Docker container:
    docker-compose up


#### Start application using Maven (via production DB):
    mvn spring-boot:run 

Or next way, using `dev` spring profile (change Active profile to **dev**):

    mvn spring-boot:run

#### Swagger URL:
    http://localhost:8080/swagger-ui/index.html
