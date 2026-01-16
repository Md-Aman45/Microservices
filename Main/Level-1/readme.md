# 🚀 Level 1 – Microservices Fundamentals (Spring Boot)

This level focuses on building a **strong foundation in Microservices architecture** using **Spring Boot** and **Netflix Eureka**.
The goal of Level 1 is to understand **service decomposition**, **service discovery**, and **inter-service communication**.

---

## 📌 What I Learned in Level 1

* What Microservices are and why they are used
* Difference between Monolith, SOA, and Microservices
* Client-side Service Discovery
* Netflix OSS and Eureka
* How microservices register and discover each other
* How services communicate using service names instead of hardcoded URLs
* Load balancing with Spring Cloud LoadBalancer
* Practical debugging of real-world configuration and version issues

---

## 🧩 Architecture Overview

This level consists of **four Spring Boot applications**:

```
Level-1/
│
├── discovery-server          # Eureka Server (Service Registry)
│
├── movie-info-service        # Provides movie information
│
├── ratings-data-service      # Provides movie ratings
│
└── movie-catalog-service     # Aggregates data from other services
```

---

## 🏗️ Services Description

### 🔹 Discovery Server

* Acts as a **Service Registry**
* Built using **Netflix Eureka Server**
* All microservices register here
* Runs on port **8761**

---

### 🔹 Movie Info Service

* Provides basic movie information
* Registers itself with Eureka
* Does not know about other services
* Example: movie name, description

---

### 🔹 Ratings Data Service

* Provides ratings for movies
* Registers itself with Eureka
* Independent microservice

---

### 🔹 Movie Catalog Service

* Aggregator service
* Communicates with:

  * Movie Info Service
  * Ratings Data Service
* Uses:

  * Eureka for service discovery
  * Spring Cloud LoadBalancer
  * RestTemplate with `@LoadBalanced`

---

## ⚙️ Technologies Used

* **Java 11**
* **Spring Boot 2.7.x**
* **Spring Cloud 2021.x**
* **Netflix Eureka**
* **Spring Cloud LoadBalancer**
* **Maven**
* **REST APIs**

---

## ▶️ How to Run Level 1 (Local Setup)

### 1️⃣ Start Eureka Server first

```bash
cd discovery-server
mvn spring-boot:run
```

Open dashboard:
👉 [http://localhost:8761](http://localhost:8761)

---

### 2️⃣ Start the microservices (in any order)

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

Eureka Dashboard should show:

```
DISCOVERY-SERVER
MOVIE-INFO-SERVICE
RATINGS-DATA-SERVICE
MOVIE-CATALOG-SERVICE
```

All services should be **UP**.

---

## 🧠 Key Concepts Practiced

* `spring.application.name` as service identity
* Service registration and heartbeat mechanism
* Dynamic service discovery at runtime
* Client-side load balancing
* Failure handling during service startup
* Importance of version compatibility (Java, Spring Boot, Spring Cloud)

---

## 📈 Outcome of Level 1

After completing Level 1, I am confident in:

* Designing basic microservice architectures
* Running multiple Spring Boot services together
* Using Eureka for service discovery
* Debugging real-world microservices issues
* Understanding how services communicate dynamically

---

## 🚀 What’s Next (Level 2)

In **Level 2**, the focus will shift to:

* API Gateway
* Centralized Configuration
* Fault Tolerance
* Resilience patterns
* Better production-ready practices

---

## ✍️ Author

**Aman**
Backend / Microservices Learner
Java • Spring Boot • Microservices
