# Task Processor

A Spring Boot application for processing tasks with the following features:

- REST API with JSON-only endpoints
- Request validation using Java Bean Validation
- Task submission, queuing, and database persistence
- Scheduled task to process a queue and asynchronously post to an HTTPS URL
- Data retrieval with caching (Caffeine, 10 min TTL)
- Centralized error handling
- MySQL database integration
- Basic HTTP authentication (Spring Security)
- Unit tests with JUnit and Mockito
- Docker support

## Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8+ (or compatible)
- Docker (optional, for containerization)

## Configuration
Edit `src/main/resources/application.properties` for your MySQL credentials:
```
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_mysql_password
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
<<<<<<< HEAD
- HTTP Basic authentication is enabled for all endpoints.
- Configure users/roles as needed in the security config.
=======
- HTTP Basic authentication is enabled for endpoints.
>>>>>>> 287a90fbedcb58079f1ce692d56402047735593c

## Testing
```
mvn test
```

<<<<<<< HEAD
## Notes
- Caching uses Caffeine with a 10-minute TTL.
- Scheduled tasks process the queue every 5 seconds.
- Centralized error handling via `@ControllerAdvice`.

=======
>>>>>>> 287a90fbedcb58079f1ce692d56402047735593c
---

