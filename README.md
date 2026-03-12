# Spring Vehicle Management System (v2)

A simple **Vehicle Management System** built using **Spring IoC** and **JDBC**, following a clean layered architecture: **DAO → Service → App → Database**.

This version upgrades the project to **annotation-based Spring configuration** with constructor-based dependency injection and better entity design.

## Version Information

* **Current Version:** v2
* **Configuration:** Annotation-based Spring configuration
* **Previous Version:** v1 (XML-based configuration)

## Features

* Add, update, delete, and retrieve vehicles from the database
* Clean layered architecture:

  * **DAO Layer:** Database operations
  * **Service Layer:** Business logic
  * **Model Layer:** Entity classes (Vehicle, Plane, etc.)
* Constructor-based dependency injection using Spring IoC
* Lifecycle management with `@PostConstruct` and `@PreDestroy`
* Proper JDBC resource management with try-with-resources
* Validation and immutability in entity classes
* Custom `DaoException` for better error handling
* Externalized configuration using `app.properties`

## Project Structure

```
spring-vehicle-management-system
│
├── Database/                       
├── libs/                           
├── resources/
│   └── app.properties              
├── src/
│   └── main/
│       ├── config/                 
│       ├── dao/                    
│       ├── model/                  
│       ├── service/                
│       └── app/                        
```

## Technologies Used

* Java 17
* Spring Framework (IoC container)
* JDBC (with MySQL)
* MySQL Database
* IntelliJ IDEA

## Configuration

Database configuration is stored in:

`resources/app.properties`

Example:

```properties
db.url=jdbc:mysql://localhost:3306/vehicle_db
db.username=root
db.password=1234
```

## Database Setup

Example table for vehicles:

```sql
CREATE TABLE vehicle (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(50),
    brand VARCHAR(50),
    color VARCHAR(50),
    price DECIMAL(10,2)
);
```

> Make sure `price` uses `DECIMAL(10,2)` or larger to avoid out-of-range errors.

## How to Run

1. Create the MySQL database.
2. Update `app.properties` with your DB credentials.
3. Run the main class inside the `app` package.

## Architecture Overview

```
App → Service → DAO → Database
```

* **App:** Entry point
* **Service:** Business logic and validation
* **DAO:** Database operations
* **Model:** Entity classes (Vehicle, Plane, etc.)

## Improvements in v2

* Replaced XML configuration with **annotation-based Spring configuration** (`@Component`, `@Service`, `@Repository`)
* **Constructor-based dependency injection** for all services and DAOs
* Lifecycle management with `@PostConstruct` / `@PreDestroy` in `DBConfig`
* Entities (`Vehicle`, `Plane`) are now **immutable and plain POJOs**
* Better **resource management** in DAO layer (try-with-resources)
* Ready for **unit testing** and **multi-instance objects** (prototype beans if needed)
