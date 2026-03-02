# Spring Vehicle Management System

A simple Vehicle Management System built using **Spring (IoC)** and
**JDBC** following a clean layered architecture (DAO → Service → App).

## Version Information

- **Current Version:** v1 
  - Configuration: XML-based Spring configuration
- **Next Version:** v2 (planned) 
  - Will use annotation-based Spring configuration
  
## Features

-   Add new vehicles to database
-   Layered architecture:
    -   DAO Layer (Database access)
    -   Service Layer (Business logic)
    -   Model Layer (Entities)
-   Custom `DaoException` for better error handling
-   Externalized configuration using `app.properties`

## Project Structure

    spring-vehicle-management-system
    │
    ├── config/
    │   └── app.xml
    │
    ├── resources/
    │   └── app.properties
    │
    ├── src/
    │   ├── dao/
    │   ├── model/
    │   ├── service/
    │   └── app/
    │
    └── Database/

## Technologies Used

-   Java 17
-   Spring Framework (IoC Container)
-   JDBC
-   MySQL
-   IntelliJ IDEA

## Configuration

Database configuration is stored inside:

    resources/app.properties

Example:

``` properties
db.url=jdbc:mysql://localhost:3306/vehicle_db
db.username=root
db.password=1234
```

## Database Setup

Example table:

``` sql
CREATE TABLE vehicle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50),
    brand VARCHAR(50),
    color VARCHAR(50),
    price DECIMAL(10,2)
);
```

> Make sure `price` uses `DECIMAL(10,2)` or larger to avoid
> out-of-range errors.

## How to Run

1.  Create the MySQL database.
2.  Update `app.properties` with your DB credentials.
3.  Run the `main` class inside `app` package.

## Architecture Overview

    App → Service → DAO → Database

-   **App**: Entry point\
-   **Service**: Business logic\
-   **DAO**: Database operations\
-   **Model**: Entity classes

This project demonstrates:

-   Spring IoC usage
-   Constructor/Setter injection
-   Clean separation of concerns
-   Custom exception handling
-   JDBC best practices
