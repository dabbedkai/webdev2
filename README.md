# WebDev 2 — Course Repository (`webdev2`)

This repository contains coursework and laboratory assignments for **WebDev 2 (Web Backend Development)**.

* **Repository URL:** `https://github.com/dabbedkai/webdev2`
* **Author:** dabbedkai
* **Branch for Lab 2:** `week2`

---

## Lab 2: First Spring Boot Application

### Overview
Lab 2 transitions our foundational Java knowledge into Spring Boot backend development. It covers Spring Boot bootstrapping, bean management with `@Repository` and `@Service`, constructor-based dependency injection, externalized application properties with `@ConfigurationProperties`, and automated startup execution using `CommandLineRunner`.

---

### How to Build and Run

#### Prerequisites
* **Java Development Kit (JDK):** Version 17 or higher
* **Build Tool:** Maven Wrapper (`mvnw` / `mvnw.cmd` included in repository)

#### Build Command
Run the following command in the project root directory:

```cmd
mvnw.cmd clean package
```

#### Run Command
Start the Spring Boot embedded Tomcat web server:

```cmd
mvnw.cmd spring-boot:run
```

---

### Application Configuration

* **Server Port:** `8082` (configured via `src/main/resources/application.properties`)
* **Configuration File:** `application.properties`

```properties
server.port=8082
shop.name=My Web Store
shop.currency=PHP
```

---

### Lab 2 Tasks & Architecture

| Task | Description | Key Spring Concepts |
| :--- | :--- | :--- |
| **Task 1 — Project Setup** | Bootstrapped Spring Boot application using Maven, Spring Web starter, Java 17, and configured port 8082. | `Spring Boot Starter`, `application.properties` |
| **Task 2 — Beans & Repositories** | Created `Product` model, `@Repository ProductRepository` with in-memory product list, and `@Service ProductService`. | `@Repository`, `@Service`, In-Memory Data |
| **Task 3 — Dependency Injection** | Injected `ProductRepository` into `ProductService` using constructor injection (no `new` keywords). | Constructor Injection, IoC Container |
| **Task 4 — External Configuration** | Externalized `shop.name` and `shop.currency` into `ShopProperties` bean using `@ConfigurationProperties(prefix = "shop")`. | `@ConfigurationProperties`, `@Component` |
| **Task 5 — Startup Wiring Report** | Built `StartupReportRunner` (`CommandLineRunner`) to print a formatted shop product report at application startup. | `CommandLineRunner`, Bean Wiring |

---

### Task 5: Sample Startup Output

When starting the application via `mvnw.cmd spring-boot:run`, the following output is displayed in the console:

```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \\
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \\
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

... Tomcat initialized with port(s): 8082 (http)
... Tomcat started on port 8082 (http) with context path ''
... Started Webdev2Application in 1.832 seconds

================================
       PRODUCT REPORT
================================
Shop: My Web Store
Currency: PHP

Products above PHP 5000:

Laptop - PHP 45000
Monitor - PHP 12000
Printer - PHP 8500
================================
```

---

## Branch Structure

* **`week1`:** Lab 1 — Core Java OOP, Generics, Custom Exceptions (`InvalidAgeException`), and Stream API Roster Reports.
* **`week2`:** Lab 2 — Spring Boot Fundamentals, IoC Container, Dependency Injection, and External Configuration.