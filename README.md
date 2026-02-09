# Homework: Spring Boot REST API with H2 Database

## Task Description
In this homework, you will **move away from storing data in a List** (as in the previous assignment) and connect a real relational database.

You will use:
- **H2 Database** — lightweight in-memory database.
- **Spring Data JPA** — an abstraction layer over Hibernate that allows working with the database through interfaces without writing SQL queries.

## Goals
- Transform a Java class into a database entity (`@Entity`).
- Configure the database connection in `application.properties`.
- Create a repository (`JpaRepository`).
- Use "Magic Methods" such as `findAll`, `save`, `deleteById`.

## Technical Requirements

### 1. Configuration (`application.properties`)
The configuration file is already created, but make sure the **H2 Console** is enabled so you can view tables in the browser.

### 2. Entity (Task)
- Annotate the `Task` class with `@Entity`.
- The `id` field should be the primary key (`@Id`) with auto-generation (`@GeneratedValue`).
- Optionally, add the `@Table` annotation for practice.
- Ensure there is a **no-args constructor** (required by Hibernate).

### 3. Repository (TaskRepository)
- Create the `TaskRepository` interface in the `repository` package.
- It should extend `JpaRepository<Task, Long>`.
- Optional/Advanced: Add a custom search method, e.g., `findByCompleted(boolean completed)`.

### 4. Service (TaskService)
Rewrite the `TaskService`. Instead of using an `ArrayList`, call repository methods:
- `getAllTasks()` -> `repository.findAll()`
- `createTask()` -> `repository.save()`
- `getTaskById()` -> `repository.findById()`

## How to Verify (H2 Console)
1. Run the application (`TodoApplication`).
2. Open in the browser: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
3. Enter the settings from `application.properties`:
    - JDBC URL: `jdbc:h2:mem:testdb`
    - User Name: `sa`
    - Password: `password`
4. Click **Connect**. You will see the `TASK` table automatically created by Hibernate.
