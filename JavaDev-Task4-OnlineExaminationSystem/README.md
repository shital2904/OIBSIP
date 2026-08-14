# 🚆 Online Reservation System

A desktop-based **Online Reservation System** developed using **Java Swing, JDBC, and MySQL** as part of the **OIBSIP Java Development Internship – Task 1**.

The application provides a user-friendly interface for account creation, authentication, train selection, railway reservation, PNR generation, booking retrieval, reservation cancellation, and logout.

---

## ✨ Features

* 🆕 Create a new user account
* 🔐 User login and authentication
* ⚠️ Invalid login / access denied handling
* 🚆 Train search and selection
* 🎫 Railway ticket reservation
* 👤 Passenger information management
* 🧾 Automatic PNR generation
* 🔎 Retrieve booking details using PNR
* ❌ Cancel existing reservations
* ✅ Booking confirmation
* ⚠️ Cancellation confirmation
* 🚪 Logout functionality
* 🗄️ MySQL database integration
* 🔗 JDBC connectivity
* 🔒 Protected database configuration

---

## 🛠️ Technologies Used

| Technology        | Purpose                           |
| ----------------- | --------------------------------- |
| **Java**          | Core application development      |
| **Java Swing**    | Graphical User Interface          |
| **JDBC**          | Database connectivity             |
| **MySQL**         | Data storage and management       |
| **Maven**         | Project and dependency management |
| **IntelliJ IDEA** | Development environment           |

---

## 🏗️ Project Architecture

The application follows a simple **layered architecture** to separate the user interface, business logic, database operations, and data models.

```text
Online Reservation System
│
├── UI Layer
│   ├── LoginFrame
│   ├── MainFrame
│   ├── ReservationPanel
│   └── CancellationPanel
│
├── DAO Layer
│   ├── UserDAO
│   ├── TrainDAO
│   └── ReservationDAO
│
├── Service Layer
│   └── PNRGenerator
│
├── Model Layer
│   └── Reservation
│
└── Database Layer
    └── DBConnection
          │
          ▼
        MySQL
```

---

## 📂 Project Structure

```text
JavaDev-Task1-OnlineReservationSystem
│
├── database
│   └── schema.sql
│
├── screenshots
│   ├── create-account.png
│   ├── login-screen.png
│   ├── access-denied.png
│   ├── reservation-booking-form.png
│   ├── booking-confirmation-pnr.png
│   ├── fetched-booking-details.png
│   ├── cancellation-confirmation.png
│   ├── cancellation-success.png
│   ├── logout.png
│   ├── mysql-database-tables.png
│   ├── mysql-users-table.png
│   ├── mysql-trains-table.png
│   └── mysql-reservations-table.png
│
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── shital
│       │           └── reservation
│       │               ├── Main.java
│       │               │
│       │               ├── dao
│       │               │   ├── UserDAO.java
│       │               │   ├── TrainDAO.java
│       │               │   └── ReservationDAO.java
│       │               │
│       │               ├── db
│       │               │   └── DBConnection.java
│       │               │
│       │               ├── model
│       │               │   └── Reservation.java
│       │               │
│       │               ├── service
│       │               │   └── PNRGenerator.java
│       │               │
│       │               └── ui
│       │                   ├── LoginFrame.java
│       │                   ├── MainFrame.java
│       │                   ├── ReservationPanel.java
│       │                   └── CancellationPanel.java
│       │
│       └── resources
│           └── config.example.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🔄 Application Workflow

```text
Create Account
      ↓
    Login
      ↓
  Main Menu
      ↓
Reservation Form
      ↓
Enter Passenger Details
      ↓
Select Train
      ↓
Generate PNR
      ↓
Booking Confirmation
      ↓
Fetch Booking Details
      ↓
Cancel Reservation
      ↓
Cancellation Confirmation
      ↓
Cancellation Success
      ↓
    Logout
```

---

## 🗄️ Database

The application uses **MySQL** to store user, train, and reservation information.

### Database

```text
reservation_system
```

### Tables

```text
users
trains
reservations
```

### Database Relationship

```text
trains
   │
   │ train_number
   ▼
reservations
```

The `train_number` in the `reservations` table references the `train_number` in the `trains` table using a **foreign key relationship**.

---

## 📋 Database Schema

### 👤 Users Table

Stores registered user login information.

| Column     | Description     |
| ---------- | --------------- |
| `id`       | Unique user ID  |
| `username` | User login name |
| `password` | User password   |

### 🚆 Trains Table

Stores available train information.

| Column         | Description         |
| -------------- | ------------------- |
| `train_number` | Unique train number |
| `train_name`   | Name of the train   |

### 🎫 Reservations Table

Stores passenger reservation information.

| Column                | Description                    |
| --------------------- | ------------------------------ |
| `pnr`                 | Unique reservation PNR         |
| `passenger_name`      | Passenger name                 |
| `train_number`        | Selected train                 |
| `class_type`          | Travel class                   |
| `journey_date`        | Date of journey                |
| `source_station`      | Starting station               |
| `destination_station` | Destination station            |
| `created_at`          | Reservation creation timestamp |

---

## 🔌 JDBC Configuration

The application connects Java to MySQL using **JDBC**.

Create the following file:

```text
src/main/resources/config.properties
```

Add your local MySQL configuration:

```properties
db.url=jdbc:mysql://localhost:3306/reservation_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

Replace `YOUR_MYSQL_PASSWORD` with your own MySQL password.

For security, `config.properties` is excluded from GitHub.

A safe example file is provided:

```text
src/main/resources/config.example.properties
```

---

# ▶️ How to Run

## 1. Clone the Repository

```bash
git clone https://github.com/shital2904/OIBSIP.git
```

## 2. Open the Project

Open the following folder in **IntelliJ IDEA**:

```text
JavaDev-Task1-OnlineReservationSystem
```

Make sure IntelliJ recognizes the project as a **Maven project**.

## 3. Configure MySQL

Start your MySQL server.

Open:

```text
database/schema.sql
```

Run the SQL script in **MySQL Workbench**.

This creates:

* Database
* Users table
* Trains table
* Reservations table
* Sample train data

## 4. Configure Database Credentials

Create:

```text
src/main/resources/config.properties
```

Add:

```properties
db.url=jdbc:mysql://localhost:3306/reservation_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

## 5. Run the Application

Open:

```text
src/main/java/com/shital/reservation/Main.java
```

Run `Main.java`.

The Java Swing login screen will appear.

---

## 🔑 Demo Login

For internship demonstration:

```text
Username: admin
Password: admin123
```

> These credentials are intended only for educational and demonstration purposes.

---

# 📸 Application Screenshots

The screenshots below are arranged according to the **actual application workflow**.

---

## 01. 🆕 Create Account

![Create Account](./screenshots/create-account.png)

---

## 02. 🔐 Login

![Login Screen](./screenshots/login-screen.png)

---

## 03. ⚠️ Access Denied

![Access Denied](./screenshots/access-denied.png)

---

## 04. 🎫 Reservation Booking Form

![Reservation Booking Form](./screenshots/reservation-booking-form.png)

---

## 05. 🧾 Booking Confirmation & PNR

![Booking Confirmation & PNR](./screenshots/booking-confirmation-pnr.png)

---

## 06. 🔎 Fetched Booking Details

![Fetched Booking Details](./screenshots/fetched-booking-details.png)

---

## 07. ⚠️ Cancellation Confirmation

![Cancellation Confirmation](./screenshots/cancellation-confirmation.png)

---

## 08. ✅ Cancellation Success

![Cancellation Success](./screenshots/cancellation-success.png)

---

## 09. 🚪 Logout

![Logout](./screenshots/logout.png)

---

## 10. 📊 Database Tables

![MySQL Database Tables](./screenshots/mysql-database-tables.png)

---

## 11. 👤 Users Table

![MySQL Users Table](./screenshots/mysql-users-table.png)

---

## 12. 🚆 Trains Table

![MySQL Trains Table](./screenshots/mysql-trains-table.png)

---

## 13. 🎫 Reservations Table

![MySQL Reservations Table](./screenshots/mysql-reservations-table.png)
## 🔎 Useful SQL Commands

### Create Database

```sql
CREATE DATABASE IF NOT EXISTS reservation_system;
```

### Select Database

```sql
USE reservation_system;
```

### Show Tables

```sql
SHOW TABLES;
```

### View Users

```sql
SELECT id, username
FROM users;
```

### View Trains

```sql
SELECT *
FROM trains;
```

### View Reservations

```sql
SELECT *
FROM reservations;
```

### Search Reservation Using PNR

```sql
SELECT *
FROM reservations
WHERE pnr = 'YOUR_PNR';
```

### Count Available Trains

```sql
SELECT COUNT(*) AS total_trains
FROM trains;
```

---

## 🔒 Security

Sensitive database credentials are not committed to the GitHub repository.

The following file is excluded using `.gitignore`:

```text
src/main/resources/config.properties
```

Only the safe example configuration is included:

```text
src/main/resources/config.example.properties
```

For a production application:

* User passwords should be securely hashed.
* Database credentials should be stored using environment variables or a secure secrets manager.
* Authentication and authorization should follow stronger security practices.

---

## 📚 Concepts Demonstrated

This project demonstrates practical implementation of:

* Object-Oriented Programming
* Java Swing GUI development
* Event handling
* JDBC
* MySQL
* SQL
* CRUD operations
* DAO pattern
* Layered architecture
* Foreign key relationships
* Exception handling
* Input validation
* Database connectivity
* PNR generation
* Maven dependency management

---

## 🎓 Internship

**OIBSIP – Java Development Internship**

**Task 1 – Online Reservation System**
