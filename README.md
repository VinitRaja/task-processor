# Task Processor

A Spring Boot application for processing tasks with the following features:

- REST API with JSON-only endpoints
- Request validation using Java Bean Validation
- Task submission, queuing, and database persistence
- Scheduled task to process a queue and asynchronously post to an HTTPS URL
- Data retrieval with caching
- Centralized error handling
- MySQL database integration
- Basic HTTP authentication
- Unit tests with JUnit and Mockito
- Docker support

## Prerequisites
- Java 17+
- Maven 3.6+
- Docker (optional, for containerization)

## Configuration
Edit `src/main/resources/application.properties` for my H2 database credentials:
```
spring.datasource.url=jdbc:h2:mem:taskdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
# Enables the H2 console for debugging
spring.h2.console.enabled=true
```

## Build
```
mvn clean package
```

## Run (Local)
```
java -jar target/*.jar
```

## Run (Docker)
1. Build the image:
	```
	docker build -t task-processor .
	```
2. Run the container:
	```
	docker run -p 8081:8081 --env SPRING_PROFILES_ACTIVE=prod task-processor
	```

## API Endpoints
- `POST /api/tasks` — Submit a new task (JSON)
- `GET /api/tasks/{id}` — Retrieve a task (cached)

## Security
- HTTP Basic authentication is enabled for endpoints.

## Testing
```
mvn test
```

---

