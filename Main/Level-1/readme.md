# 🚀 Level 1 – Microservices Fundamentals with Spring Boot

Level 1 focuses on building a **strong foundation in Microservices architecture** using **Spring Boot**.
The goal of this level is to understand **how microservices are structured, registered, discovered, and communicate with each other**.

This level intentionally keeps the system simple to focus on **core concepts**, not frameworks overload.

---

## 🎯 Objectives of Level 1

* Understand **what microservices are** and why they exist
* Learn **Service Discovery** using Netflix Eureka
* Replace hardcoded URLs with **dynamic service discovery**
* Build confidence running multiple services together
* Debug real-world version and configuration issues

---

## 🧩 Architecture Overview

```
Level-1/
│
├── discovery-server          # Eureka Server (Service Registry)
│
├── movie-info-service        # Provides movie details
│
├── ratings-data-service      # Provides movie ratings
│
└── movie-catalog-service     # Aggregates data from other services
```

---

## 🏗️ Services Breakdown

### 🔹 Discovery Server

* Central **Service Registry**
* Built using **Netflix Eureka**
* All services register here
* Runs on port **8761**

---

### 🔹 Movie Info Service

* Independent microservice
* Provides movie-related data
* Registers with Eureka
* Does not depend on other services

---

### 🔹 Ratings Data Service

* Independent microservice
* Provides ratings for movies
* Registers with Eureka

---

### 🔹 Movie Catalog Service

* Aggregator service
* Communicates with:

  * Movie Info Service
  * Ratings Data Service
* Uses:

  * Eureka for discovery
  * Spring Cloud LoadBalancer
  * `@LoadBalanced` RestTemplate

---

## ⚙️ Tech Stack

* **Java 11**
* **Spring Boot 2.7.x**
* **Spring Cloud 2021.x**
* **Netflix Eureka**
* **Spring Cloud LoadBalancer**
* **Maven**
* **REST APIs**

---

## ▶️ How to Run (Local)

### 1️⃣ Start Eureka Server

```bash
cd discovery-server
mvn spring-boot:run
```

Dashboard:

```
http://localhost:8761
```

---

### 2️⃣ Start Microservices

```bash
cd movie-info-service
mvn spring-boot:run
```

```bash
cd ratings-data-service
mvn spring-boot:run
```

```bash
cd movie-catalog-service
mvn spring-boot:run
```

---

## ✅ Expected Result

Eureka Dashboard should show all services as **UP**:

```
DISCOVERY-SERVER
MOVIE-INFO-SERVICE
RATINGS-DATA-SERVICE
MOVIE-CATALOG-SERVICE
```

---

## 🧠 Key Concepts Learned

* Service registration and discovery
* `spring.application.name` as service identity
* Client-side service discovery
* Load-balanced inter-service communication
* Importance of version compatibility
* Debugging microservices startup issues

---

## 📈 Outcome

After completing Level 1, I am confident in:

* Designing basic microservice systems
* Running and debugging multiple Spring Boot services
* Using Eureka for dynamic discovery
* Understanding how services communicate without hardcoded endpoints

---

## 🚀 Next Step – Level 2

Level 2 will focus on **production-ready microservices**, including:

* API Gateway
* Centralized Configuration
* Fault tolerance and resilience
* Better system design practices

---

## ✍️ Author

**Aman**
Backend / Microservices Developer
Java • Spring Boot • Microservices






