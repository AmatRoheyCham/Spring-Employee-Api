# Employee API

> This is a Class Sample for Spring Boot Learners.

A simple REST API for managing employees, built with Spring Boot, Spring Data JPA and SQLite. It shows the typical layered structure of a Spring Boot application: controller, service, repository, DTOs, validation and global exception handling.

## Tech Stack

- Java 21
- Spring Boot 3.3.6 (Web, Data JPA, Validation)
- SQLite (via `sqlite-jdbc` and Hibernate community dialects)
- Maven (wrapper included)

## Project Structure

```
src/main/java/com/example/employeeapi
├── EmployeeApiApplication.java   # Application entry point
├── controller/                   # REST endpoints
├── dto/                          # Request / response objects
├── exception/                    # Custom exceptions and global error handler
├── model/                        # JPA entity
├── repository/                   # Spring Data JPA repository
└── service/                      # Business logic
```

## Running the Application

```bash
# Windows
mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`. An `employees.db` SQLite file is created in the project folder on first run, and the table is generated automatically (`ddl-auto=update`).

## API Endpoints

| Method | Endpoint              | Description            |
|--------|-----------------------|------------------------|
| GET    | `/api/employees`      | Get all employees      |
| GET    | `/api/employees/{id}` | Get an employee by id  |
| POST   | `/api/employees`      | Create a new employee  |
| PUT    | `/api/employees/{id}` | Update an employee     |
| DELETE | `/api/employees/{id}` | Delete an employee     |

### Sample Request Body

```json
{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "department": "Engineering",
  "salary": 75000.00
}
```

### Example

```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Jane","lastName":"Doe","email":"jane.doe@example.com","department":"Engineering","salary":75000.00}'
```

## Validation Rules

- `firstName`, `lastName`, `department`: required, max 50 characters
- `email`: required, must be a valid email, must be unique
- `salary`: required, greater than 0, at most 2 decimal places

## Running Tests

```bash
./mvnw test
```
