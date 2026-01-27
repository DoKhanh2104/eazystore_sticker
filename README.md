# 🛍️ Eazy Store - Full-Stack E-Commerce Platform

<div align="center">

![React](https://img.shields.io/badge/React-19.0-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Stripe](https://img.shields.io/badge/Stripe-Payment-008CDD?style=for-the-badge&logo=stripe&logoColor=white)

**A modern, production-ready e-commerce application built with enterprise-grade technologies**

</div>

---

## 🎯 Project Overview

Eazy Store is a comprehensive full-stack e-commerce platform featuring secure authentication, payment processing, and real-time inventory management. Built with modern web technologies and best practices, this project demonstrates proficiency in both frontend and backend development.

## ✨ Features

### 🔐 Authentication & Security

- **JWT-based Authentication** - Secure token-based auth with refresh mechanism
- **Role-Based Access Control (RBAC)** - Admin and customer role separation
- **Password Encryption** - BCrypt hashing for secure password storage
- **CSRF Protection** - Token-based CSRF prevention

### 🛒 E-Commerce Functionality

- **Product Catalog** - Paginated product listings with search and filters
- **Shopping Cart** - Redux-powered cart with persistent storage
- **Checkout Flow** - Multi-step checkout with address validation
- **Order Management** - Order tracking and history for customers
- **Admin Dashboard** - Product, order, and customer management

### 💳 Payment Integration

- **Stripe Integration** - Secure payment processing
- **Payment Intent API** - PCI-compliant card handling
- **Order Confirmation** - Real-time payment status updates

### 🎨 User Experience

- **Responsive Design** - Mobile-first approach with Tailwind CSS
- **Dark Mode** - System-aware theme switching
- **Toast Notifications** - Real-time feedback with Sonner
- **Loading States** - Skeleton screens and spinners
- **Error Handling** - User-friendly error messages

### 🔧 Technical Features

- **RESTful API** - Clean, documented API endpoints
- **Database Migrations** - Hibernate ORM with JPA
- **Caching** - Caffeine cache for improved performance
- **Docker Deployment** - Multi-container orchestration
- **Nginx Reverse Proxy** - API gateway and static file serving

---

## 🚀 Tech Stack

### Frontend

| Technology          | Purpose                                  |
| ------------------- | ---------------------------------------- |
| **React 19**        | UI library with hooks and context        |
| **Redux Toolkit**   | State management for cart and user       |
| **React Router v7** | Client-side routing with loaders/actions |
| **Tailwind CSS v4** | Utility-first styling with dark mode     |
| **Vite**            | Fast build tool and dev server           |
| **Axios**           | HTTP client with interceptors            |
| **Sonner**          | Toast notifications                      |
| **Stripe.js**       | Payment UI components                    |

### Backend

| Technology          | Purpose                          |
| ------------------- | -------------------------------- |
| **Spring Boot 3.5** | Enterprise Java framework        |
| **Spring Security** | Authentication and authorization |
| **Spring Data JPA** | Database abstraction layer       |
| **Hibernate**       | ORM for MySQL                    |
| **JWT (JJWT)**      | Token generation and validation  |
| **Stripe Java SDK** | Payment processing               |
| **Caffeine Cache**  | In-memory caching                |
| **Bean Validation** | Request validation               |
| **Lombok**          | Boilerplate reduction            |

### Database & DevOps

| Technology         | Purpose                          |
| ------------------ | -------------------------------- |
| **MySQL 8.0**      | Relational database              |
| **Docker**         | Containerization                 |
| **Docker Compose** | Multi-container orchestration    |
| **Nginx**          | Reverse proxy and static hosting |
| **Maven**          | Build automation                 |

---

## 📁 Project Structure

```
fullstack-react-springboot/
├── eazystore/                    # Spring Boot Backend
│   ├── src/main/java/
│   │   └── com/devithedev/eazystore/
│   │       ├── config/           # Security, CORS, Cache config
│   │       ├── controller/       # REST API endpoints
│   │       ├── dto/              # Data Transfer Objects
│   │       ├── entity/           # JPA entities
│   │       ├── filter/           # JWT validation filter
│   │       ├── repository/       # Data access layer
│   │       ├── service/          # Business logic
│   │       └── util/             # JWT utilities
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── sql/data.sql          # Sample data
│   └── Dockerfile                # Multi-stage build
│
├── eazystore_ui/                 # React Frontend
│   ├── src/
│   │   ├── api/                  # API client with interceptors
│   │   ├── components/           # React components
│   │   │   ├── admin/            # Admin dashboard
│   │   │   └── ...               # Product, Cart, Checkout, etc.
│   │   ├── store/                # Redux store and slices
│   │   └── main.jsx              # App entry point
│   ├── nginx.conf                # Nginx configuration
│   ├── Dockerfile                # Node build + Nginx serve
│   └── .env.production           # Production environment
│
├── database/
│   └── init-clean.sql            # Database initialization
│
└── docker-compose.yaml           # Multi-container setup
```

---

## 🏃 Quick Start

### Prerequisites

- Docker & Docker Compose
- Git

### 1️⃣ Clone the Repository

```bash
git clone
cd fullstack-react-springboot
```

### 2️⃣ Start with Docker Compose

```bash
docker-compose up -d
```

This will start:

- **MySQL** on port `3307`
- **Backend API** on port `8080`
- **Frontend** on port `3000`

### 3️⃣ Access the Application

- **Frontend:** http://localhost:3000
- **Backend API:** http://localhost:8080/api/v1
- **API Docs:** http://localhost:8080/eazystore/actuator

---

## 🛠️ Development Setup

### Backend (Spring Boot)

```bash
cd eazystore
./mvnw spring-boot:run
```

### Frontend (React + Vite)

```bash
cd eazystore_ui
npm install
npm run dev
```

---

## 📈 Performance Optimizations

- ✅ **Caffeine Cache** - Product catalog caching
- ✅ **Connection Pooling** - HikariCP for database
- ✅ **Lazy Loading** - JPA fetch strategies
- ✅ **Code Splitting** - Vite dynamic imports
- ✅ **Image Optimization** - Compressed assets
- ✅ **Nginx Gzip** - Response compression

---

<div align="center">

**⭐ Star this repo if you find it helpful!**

Made with ❤️ and ☕

</div>
