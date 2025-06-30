# 🛒 E-commerce Product Catalog - Backend Service

## 📌 Overview

This is a backend service for an e-commerce product catalog built with Java 21 and Spring Boot. 
It exposes RESTful APIs for product management, user authentication via JWT, and includes a basic UI using Thymeleaf.

---

## 🎯 Goals

- ✅ Full CRUD for products
- 🔐 JWT-based user authentication & authorization
- 🛡️ Strong validation and global exception handling
- 🌐 Basic product listing UI using Thymeleaf
- 🗃️ PostgreSQL/MySQL support

---

## ⚙️ Tech Stack

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL or MySQL
- Thymeleaf (UI)
- Swagger/OpenAPI
- Lombok

---

## 🧩 Features

### ✅ REST API Endpoints

| Method | Endpoint             | Description               | Roles         |
|--------|----------------------|---------------------------|---------------|
| GET    | `/api/products`      | Get all products          | USER, ADMIN   |
| GET    | `/api/products/{id}` | Get product by ID         | USER, ADMIN   |
| POST   | `/api/products`      | Add new product           | ADMIN only    |
| PUT    | `/api/products/{id}` | Update product            | ADMIN only    |
| DELETE | `/api/products/{id}` | Delete product            | ADMIN only    |

### 🔐 Authentication & Roles

- JWT-based login (`/api/auth/login`)
- Registration (`/api/auth/register`)
- Roles: `ROLE_USER`, `ROLE_ADMIN`

### 🌐 Swagger Documentation

Visit [http://localhost:8181/swagger-ui/index.html](http://localhost:8181/swagger-ui/index.html) after starting the app to explore all API endpoints.

### 🖥️ Thymeleaf UI

- List products from the catalog
- Simple admin interface (optional)

---

## 📁 Project Structure

ecommerce-catalog/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ecommerce/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── exception/
│   │   │       ├── filter/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       ├── util/
│   │   │       └── ECommerceProductCatalogApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── schema.sql
│   │       └── templates/ (Thymeleaf HTML files)
├── pom.xml

---

## 🚀 Running the App

### Prerequisites

- Java 21+
- Maven
- PostgreSQL or MySQL running

### Steps

# Clone repo
git clone https://github.com/your-username/ecommerce-catalog.git
cd ecommerce-catalog

# Build and run
mvn clean install
mvn spring-boot:run

---

## 🧪 Testing APIs

Use tools like Postman or Swagger UI:

- Login: `POST /api/auth/login`
- Register: `POST /api/auth/register`
- Access protected: `GET /api/products` (with Bearer Token)

---

## 📦 Database

- Schema is initialized from `schema.sql` in `src/main/resources`.
- Ensure DB credentials are configured in `application.yml`.

---

## 📝 License

MIT License — free to use and modify.

---